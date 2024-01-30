package com.mockito.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSumTest_basic(){
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SomeBusiness someBusiness = new SomeBusiness();
        int actualResult = someBusiness.calculateSum(data);
        int expectedResult = 55;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumTest_empty(){
        int[] data = new int[]{};
        SomeBusiness someBusiness = new SomeBusiness();
        int actualResult = someBusiness.calculateSum(data);
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumTest_oneValue(){
        int[] data = new int[]{10};
        SomeBusiness someBusiness = new SomeBusiness();
        int actualResult = someBusiness.calculateSum(data);
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }
}
