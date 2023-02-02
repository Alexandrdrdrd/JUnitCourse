package org.example;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickBeforeAfterTest {


    @Before
    public void setup(){
        System.out.println("before test");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 executed");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 executed");
    }

}
