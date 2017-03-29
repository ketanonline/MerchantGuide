package com.thoughtworks.merchantguide.service.romannumerals;

import java.util.regex.Pattern;

/**
 * @author ketz
 */
public class RomanNumberFormatRules {

    public static boolean allInOne(String romans) {
        return Pattern.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$", romans);
    }

}
