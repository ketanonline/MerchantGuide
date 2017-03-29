package com.thoughtworks.merchantguide.service.romannumerals;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void testGetBase10ValueForI_ShouldReturnOne() {
        Assert.assertEquals(RomanNumerals.I.getBase10Value(), 1);
    }

    @Test
    public void testGetBase10ValueForV_ShouldReturnFive() {
        Assert.assertEquals(RomanNumerals.V.getBase10Value(), 5);
    }

    @Test
    public void testGetBase10ValueForX_ShouldReturnTen() {
        Assert.assertEquals(RomanNumerals.X.getBase10Value(), 10);
    }

    @Test
    public void testGetBase10ValueForL_ShouldReturnFifty() {
        Assert.assertEquals(RomanNumerals.L.getBase10Value(), 50);
    }

    @Test
    public void testGetBase10ValueForC_ShouldReturnHundred() {
        Assert.assertEquals(RomanNumerals.C.getBase10Value(), 100);
    }

    @Test
    public void testGetBase10ValueForD_ShouldReturnFiveHundred() {
        Assert.assertEquals(RomanNumerals.D.getBase10Value(), 500);
    }

    @Test
    public void testGetBase10ValueForM_ShouldReturnThousand() {
        Assert.assertEquals(RomanNumerals.M.getBase10Value(), 1000);
    }

    @Test
    public void testValueOfStringI_ShouldReturnI() {
        Assert.assertEquals(RomanNumerals.valueOf("I"), RomanNumerals.I);
    }

    @Test
    public void testValueOfStringV_ShouldReturnV() {
        Assert.assertEquals(RomanNumerals.valueOf("V"), RomanNumerals.V);
    }

    @Test
    public void testValueOfStringX_ShouldReturnX() {
        Assert.assertEquals(RomanNumerals.valueOf("X"), RomanNumerals.X);
    }

    @Test
    public void testValueOfStringL_ShouldReturnL() {
        Assert.assertEquals(RomanNumerals.valueOf("L"), RomanNumerals.L);
    }

    @Test
    public void testValueOfStringC_ShouldReturnC() {
        Assert.assertEquals(RomanNumerals.valueOf("C"), RomanNumerals.C);
    }

    @Test
    public void testValueOfStringD_ShouldReturnC() {
        Assert.assertEquals(RomanNumerals.valueOf("D"), RomanNumerals.D);
    }

    @Test
    public void testValueOfStringM_ShouldReturnM() {
        Assert.assertEquals(RomanNumerals.valueOf("M"), RomanNumerals.M);
    }

}
