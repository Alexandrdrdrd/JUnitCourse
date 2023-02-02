package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class ArraysCompareTest {

    @Test
    public void test(){
        int [] numbers = {12,3,4,1};
        int [] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);

    }
}
