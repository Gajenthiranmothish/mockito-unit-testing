package com.mockito.unittesting.business;

import com.mockito.unittesting.service.SomeDataService;

import java.util.Arrays;

public class SomeBusiness {

    SomeDataService someDataService;

    public int calculateSum(int[] data){
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data).sum();
    }
}
