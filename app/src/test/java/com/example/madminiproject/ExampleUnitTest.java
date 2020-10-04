package com.example.madminiproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExampleUnitTest {
    private proratafee2 proratafee2;
    private proratafee3 proratafee3;

    @Before
    public void setup1() {
        proratafee2 = new proratafee2();
    }

    @Test
    public void testMultiplyNumbers() {
        double result = proratafee2.multiplyNumbers(2, 1000);
        Assert.assertEquals(2000, result, 0.001);
    }

    @Before
    public void setup2() {
        proratafee3 = new proratafee3();
    }

    @Test
    public void testMultiplyNumbers2() {
        double result = proratafee3.multiplyNumbers2(3, 2000);
        Assert.assertEquals(6000, result, 0.001);
    }
}