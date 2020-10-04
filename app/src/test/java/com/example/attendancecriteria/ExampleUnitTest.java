package com.example.attendancecriteria;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
   private Calculate calculate;

   @Before
   public void setup(){
       calculate = new Calculate();
   }

   @Test
    public void testCalculate(){
       int result = calculate.calcuattendance(100,80);
       assertEquals(80,result);

       int result2 = calculate.calcuattendance(180,90);
       assertEquals(162,result2);

       int result3 = calculate.calcuattendance(200,50);
       assertEquals(100,result3);

       int result4 = calculate.calcuattendance(150,60);
       assertEquals(90,result4);

       int result5 = calculate.calcuattendance(120,100);
       assertEquals(120,result5);
   }


}