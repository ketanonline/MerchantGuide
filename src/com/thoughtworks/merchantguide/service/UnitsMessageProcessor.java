package com.thoughtworks.merchantguide.service;

import com.thoughtworks.merchantguide.service.common.Constants;
import com.thoughtworks.merchantguide.service.romannumerals.RomanNumerals;
import com.thoughtworks.merchantguide.service.romannumerals.RomansToDecimal;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ketz
 */
public class UnitsMessageProcessor extends MessageProcessor {

    private final static Pattern keywordToRomanUnitMessagePattern = Pattern.compile("(\\w+?\\s){1}(IS){1}\\s([IVXLCDM]){1}");
    private final static Pattern keywordOtherMaterialUnitMessagePattern = Pattern.compile("(\\w+?\\s){1,}(IS){1}\\s(\\d+?\\s){1}(CREDITS){1}");

    public IntergalacticUnitConverterServiceResponse process(IntergalacticUnitConverterServiceRequest msg) {
        try {
            mapKeywordToRomanUnit(msg);
            keywordOtherMaterialUnitMapper(msg);
        } catch (NotARomanLetterException | NumberFormatException ex) {
            return Constants.UNKNOWN_INPUT_INTERGALACTIC_UNIT_CONVERTER_SERVICE_RESPONSE;
        } catch (Exception ex) {
            return Constants.UNKNOWN_INPUT_INTERGALACTIC_UNIT_CONVERTER_SERVICE_RESPONSE;
        }
        return Constants.DUMMY_INTERGALACTIC_UNIT_CONVERTER_SERVICE_RESPONSE;
    }

    private void mapKeywordToRomanUnit(IntergalacticUnitConverterServiceRequest msg) {
        String str = msg.getValue().trim().toUpperCase();
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }
        Matcher m = keywordToRomanUnitMessagePattern.matcher(str);

        while (m.find()) {
            RomanNumerals val = RomanNumerals.valueOf(m.group(3));
            if (val == RomanNumerals.UNKNOWN) {
                throw new NotARomanLetterException();
            }
            units.put(m.group(1).trim(), m.group(3).trim());
        }
    }


    private void keywordOtherMaterialUnitMapper(IntergalacticUnitConverterServiceRequest msg) {
        String str = msg.getValue().toUpperCase();
        if (str.endsWith(".")) {
            str = str.trim().substring(0, str.length() - 1);
        }

        Matcher m = keywordOtherMaterialUnitMessagePattern.matcher(str);
        while (m.find()) {
            double divider = convertStringToRomanAndCalculateAsDecimal(str.substring(0, m.end(1)));
            double cost = Double.parseDouble(m.group(3)) / divider;
            units.put(m.group(1).trim(), String.valueOf(cost));
        }
    }

    private double convertStringToRomanAndCalculateAsDecimal(String str) {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            String key = units.get(s.toUpperCase());
            if (key == null) {
                break;
            }
            sb.append(key);
        }
        return RomansToDecimal.toDecimal(sb.toString());
    }

    public Map<String, String> forTestOnly_getUnitsMap() {
        return units;
    }

    private class NotARomanLetterException extends RuntimeException {
    }

}
