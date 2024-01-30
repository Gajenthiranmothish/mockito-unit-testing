package com.mockito.unittesting.business;

import com.mockito.unittesting.service.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusiness someBusiness;
    @Mock
    SomeDataService someDataServiceMock;

    @Test
    public void calculateSumUsingDataServiceTest_basic() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, someBusiness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataServiceTest_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someBusiness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataServiceTest_OneElement() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, someBusiness.calculateSumUsingDataService());
    }
}


