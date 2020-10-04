package com.example.unistudiac;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private FinalMark finalMark;

    @Before
    public void setup(){
        finalMark = new FinalMark();
    }

    @Test
    public void testMarksCal(){
        int result;
        result = finalMark.calculate(90,80);
        assertEquals(85, result);
    }



}