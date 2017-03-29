package com.thoughtworks.merchantguide.service.romannumerals;

/**
 * Created by ketz on 3/30/2017.
 */
public enum RomanNumerals {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000),
    UNKNOWN(0);
    private int base10Value;

    RomanNumerals(int value) {
        this.base10Value = value;
    }

    public static RomanNumerals toRomansEnum(String s) {
        RomanNumerals r = UNKNOWN;
        if (s == null) return r;
        try {
            r = Enum.valueOf(RomanNumerals.class, s);
        } catch (IllegalArgumentException e) {
            r = UNKNOWN;
        }
        return r;
    }

    public int getBase10Value() {
        return this.base10Value;
    }
}
