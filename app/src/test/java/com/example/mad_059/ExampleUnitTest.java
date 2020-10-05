package com.example.mad_059;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private proratafee1 proratafee1;
    private proratafee2 proratafee2;


    private Calculate calculate;

    private finalmarks finalMark;



    ///Modules


    @Before
    public void setup(){

        finalMark = new finalmarks();
    }

    @Test
    public  void testMarksCal() {
        int result;
        //result = finalMark.marksCal(90,80);
        //assertEquals(85,result);

    }

        //Attendance

@Before
public  void setup4() {
calculate = new Calculate();
}

@Test
public  void testCalculete() {

    int result4 = calculate.calcuattendance(100, 80);
    assertEquals(80, result4);


    int result5 = calculate.calcuattendance(180, 90);
    assertEquals(162, result5);

    int result6 = calculate.calcuattendance(200, 50);
    assertEquals(100, result6);

    int result7 = calculate.calcuattendance(150, 60);
    assertEquals(90, result7);

    int result8 = calculate.calcuattendance(120, 100);
    assertEquals(120, result8);
}
        //Library


    @Before
     public  void setup2(){

     proratafee1 = new proratafee1();

    }

     @Test
         public  void testMultiplyNumbers(){

             double result2 = proratafee1.multiplyNumbers(2,1000);
            Assert.assertEquals(2000,result2,0.001);

        }


    @Before
    public  void setup3(){

        proratafee2= new proratafee2();

    }

    @Test
    public  void testMultiplyNumbers2(){

        double result3 = proratafee2.multiplyNumbers2(2,1000);
        Assert.assertEquals(2000,result3,0.001);

    }


        //Submission

    }




