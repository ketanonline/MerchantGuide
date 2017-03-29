package com.thoughtworks.merchantguide.service.romannumerals;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ketz on 3/30/2017.
 */
public class RomansToDecimalTest {
    @Test
    public void toDecimal() throws Exception {
        Assert.assertEquals(RomansToDecimal.toDecimal("I"), 1);
        Assert.assertEquals(RomansToDecimal.toDecimal("V"), 5);
        Assert.assertEquals(RomansToDecimal.toDecimal("X"), 10);
        Assert.assertEquals(RomansToDecimal.toDecimal("L"), 50);
        Assert.assertEquals(RomansToDecimal.toDecimal("C"), 100);
        Assert.assertEquals(RomansToDecimal.toDecimal("D"), 500);
        Assert.assertEquals(RomansToDecimal.toDecimal("M"), 1000);
        Assert.assertEquals(RomansToDecimal.toDecimal("II"), 2);
        Assert.assertEquals(RomansToDecimal.toDecimal("III"), 3);
        Assert.assertEquals(RomansToDecimal.toDecimal("IV"), 4);
        Assert.assertEquals(RomansToDecimal.toDecimal("VI"), 6);
        Assert.assertEquals(RomansToDecimal.toDecimal("VII"), 7);
        Assert.assertEquals(RomansToDecimal.toDecimal("VIII"), 8);
        Assert.assertEquals(RomansToDecimal.toDecimal("IX"), 9);
        Assert.assertEquals(RomansToDecimal.toDecimal("DXXI"), 521);
        Assert.assertEquals(RomansToDecimal.toDecimal("MMMCMXCIX"), 3999);
    }

}