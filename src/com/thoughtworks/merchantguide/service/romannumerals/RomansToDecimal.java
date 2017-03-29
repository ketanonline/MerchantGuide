package com.thoughtworks.merchantguide.service.romannumerals;

/**
 * Created by ketz on 3/30/2017.
 */
public class RomansToDecimal {

    public static int toDecimal(String str) {
        int val = 0;
        char[] arr = str.toCharArray();
        RomanNumerals prev = RomanNumerals.UNKNOWN;
        RomanNumerals next = RomanNumerals.UNKNOWN;
        RomanNumerals cur = RomanNumerals.UNKNOWN;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prev = RomanNumerals.UNKNOWN;
            } else {
                prev = RomanNumerals.valueOf(String.valueOf(arr[i - 1]));
            }
            if (i == arr.length - 1) {
                next = RomanNumerals.UNKNOWN;
            } else {
                next = RomanNumerals.valueOf(String.valueOf(arr[i + 1]));
            }

            cur = RomanNumerals.valueOf(String.valueOf(arr[i]));
            if (cur.getBase10Value() < next.getBase10Value()) {
                continue;
            } else if (cur.getBase10Value() > prev.getBase10Value()) {
                val = val + cur.getBase10Value() - prev.getBase10Value();
            } else {
                val = val + cur.getBase10Value();
            }
        }

        return val;
    }

}
