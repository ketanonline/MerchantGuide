package com.thoughtworks.merchantguide.service.romannumerals;

/**
 * @author ketz
 */
public class RomanNumberValidator {

    public static boolean validate(String romans) {
        return RomanNumberFormatRules.allInOne(romans);
    }
}
