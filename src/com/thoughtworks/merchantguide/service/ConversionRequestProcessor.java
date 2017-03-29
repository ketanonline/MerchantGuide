/**
 *
 */
package com.thoughtworks.merchantguide.service;

import com.thoughtworks.merchantguide.service.common.Constants;
import com.thoughtworks.merchantguide.service.romannumerals.RomanNumberValidator;
import com.thoughtworks.merchantguide.service.romannumerals.RomanNumerals;
import com.thoughtworks.merchantguide.service.romannumerals.RomansToDecimal;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * @author ketz
 */
public class ConversionRequestProcessor extends MessageProcessor {

    public IntergalacticUnitConverterServiceResponse process(IntergalacticUnitConverterServiceRequest msg) {
        return convert(msg);
    }

    private IntergalacticUnitConverterServiceResponse convert(IntergalacticUnitConverterServiceRequest msg) {
        IntergalacticUnitConverterServiceResponse resp = Constants.UNKNOWN_INPUT_INTERGALACTIC_UNIT_CONVERTER_SERVICE_RESPONSE;
        String str = msg.getValue();
        String[] ques = {"HOW MUCH IS ", "HOW MANY CREDITS IS "};

        for (String q : ques) {
            if (str.toUpperCase().startsWith(q)) {
                str = str.substring(q.length(), str.length());
                str = str.replaceAll("[\\?\\.]", "").trim();
            }
        }

        StringBuilder sb = new StringBuilder();
        double specialUnitsValue = 1d;
        String[] arr = str.split(" ");
        for (String token : arr) {
            if (token.length() == 0) continue;
            if (!units.containsKey(token.toUpperCase())) {
                return resp;
            }
            String key = units.get(token.toUpperCase());
            RomanNumerals r = RomanNumerals.toRomansEnum(key);
            if (r == RomanNumerals.UNKNOWN) {
                if (sb.length() > 0) {
                    if (!RomanNumberValidator.validate(sb.toString()))
                        throw new InvalidRomanNumberFormatException();
                    specialUnitsValue = RomansToDecimal.toDecimal(sb.toString()) * specialUnitsValue;
                    sb.setLength(0);
                }
                specialUnitsValue = specialUnitsValue * Double.valueOf(key);
            } else {
                sb.append(key);
            }
        }
        if (sb.length() > 0) {
            specialUnitsValue = RomansToDecimal.toDecimal(sb.toString()) * specialUnitsValue;
        }
        resp = new IntergalacticUnitConverterServiceResponse(formatResponse(msg, str.trim(), specialUnitsValue));
        return resp;
    }

    private String formatResponse(IntergalacticUnitConverterServiceRequest msg, String in, double result) {
        StringBuilder sb = new StringBuilder(in);
        sb.append(" is ");
        DecimalFormat df = new DecimalFormat("0.##");
        sb.append(df.format(result));
        if (msg.getValue().toUpperCase().contains("CREDITS")) {
            sb.append(" Credits");
        }
        return sb.toString();
    }

    public void forTestOnly_setUnitsMap(Map<String, String> m) {
        units.putAll(m);
    }

}
