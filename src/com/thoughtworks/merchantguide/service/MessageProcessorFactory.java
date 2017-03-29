package com.thoughtworks.merchantguide.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageProcessorFactory {


    private static final String[] conversionRequestPatterns = {"HOW MUCH IS ", "HOW MANY CREDITS IS "};

    private static final String[] unitIndicatorPatterns = {"(\\w+?\\s){1}(IS){1}\\s([IVXLCDM]){1}",
            "(\\w+?\\s){1,}(IS){1}\\s(\\d+?\\s){1}(CREDITS){1}"};

    static {
        Pattern p1 = Pattern.compile("(\\w+?\\s){1}(IS){1}\\s([IVXLCDM]){1}");
        Pattern p2 = Pattern.compile("(\\w+?\\s){1,}(IS){1}\\s(\\d+?\\s){1}(CREDITS){1}");
    }

    private MessageProcessorFactory() {
    }

    public static MessageProcessor createMessageProcessor(IntergalacticUnitConverterServiceRequest msg) {
        for (String str : unitIndicatorPatterns) {
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(msg.getValue().toUpperCase());
            if (m.find()) {
                return new UnitsMessageProcessor();
            }
        }
        for (String str : conversionRequestPatterns) {
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(msg.getValue().toUpperCase());
            if (m.find()) {
                return new ConversionRequestProcessor();
            }
        }
        return UnknownMessageProcessor.getInstance();
    }

}
