package com.thoughtworks.merchantguide.service.romannumerals;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsValidatorTest {

    @Test
    public void testValidate() {
        Assert.assertEquals(true, RomanNumberValidator.validate("D"));
        Assert.assertEquals(false, RomanNumberValidator.validate("DD"));
        Assert.assertEquals(true, RomanNumberValidator.validate("L"));
        Assert.assertEquals(false, RomanNumberValidator.validate("LL"));
        Assert.assertEquals(true, RomanNumberValidator.validate("V"));
        Assert.assertEquals(false, RomanNumberValidator.validate("VV"));

        Assert.assertEquals(false, RomanNumberValidator.validate("DLL"));
        Assert.assertEquals(false, RomanNumberValidator.validate("LDD"));
        Assert.assertEquals(false, RomanNumberValidator.validate("LVV"));
        Assert.assertEquals(false, RomanNumberValidator.validate("VLL"));
        Assert.assertEquals(false, RomanNumberValidator.validate("DVV"));
        Assert.assertEquals(false, RomanNumberValidator.validate("VDD"));
        Assert.assertEquals(false, RomanNumberValidator.validate("VL"));
        Assert.assertEquals(true, RomanNumberValidator.validate("XLV"));
        Assert.assertEquals(true, RomanNumberValidator.validate("MMM"));
        Assert.assertEquals(false, RomanNumberValidator.validate("MMMM"));
        Assert.assertEquals(true, RomanNumberValidator.validate("MMMCM"));
        Assert.assertEquals(true, RomanNumberValidator.validate("CCC"));
        Assert.assertEquals(false, RomanNumberValidator.validate("CCCC"));
        Assert.assertEquals(true, RomanNumberValidator.validate("CCCXC"));
        Assert.assertEquals(true, RomanNumberValidator.validate("XXX"));
        Assert.assertEquals(false, RomanNumberValidator.validate("XXXX"));
        Assert.assertEquals(true, RomanNumberValidator.validate("XXXIX"));
        Assert.assertEquals(true, RomanNumberValidator.validate("III"));
        Assert.assertEquals(false, RomanNumberValidator.validate("IIII"));
    }

}
