package com.mockito.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

    @Mock
    List<Integer> listMock;

    @Test
    public void testList() {
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void testListWithMultipleCalls() {
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void testListWithDifferentParams() {
        when(listMock.get(0)).thenReturn(5);
        when(listMock.get(10)).thenReturn(10);
        assertEquals(5, listMock.get(0));
        assertEquals(10, listMock.get(10));
        assertNull(listMock.get(1));
    }

    @Test
    public void testListWithGenericParams() {
        when(listMock.get(anyInt())).thenReturn(5);
        assertEquals(5, listMock.get(0));
        assertEquals(5, listMock.get(1));
        assertEquals(5, listMock.get(10));
    }

    //Verification
    @Test
    public void verificationOfInvocation() {
        Integer value = listMock.get(0);
        Integer value1 = listMock.get(1);
        Integer value2 = listMock.get(1);
        verify(listMock, atLeastOnce()).get(anyInt());
        verify(listMock, atLeast(1)).get(0);
        verify(listMock, atMost(3)).get(anyInt());
        verify(listMock, times(1)).get(0);
        verify(listMock, times(2)).get(1);
    }


    @Test
    public void argumentCapturing() {
        int value = 65468132;
        listMock.add(value);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(listMock).add(captor.capture());

        assertEquals(value, captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        int value = 65468132;
        int value1 = 65465432;
        listMock.add(value);
        listMock.add(value1);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(listMock, atLeastOnce()).add(captor.capture());

        List<Integer> allValues = captor.getAllValues();
        assertEquals(value, allValues.get(0));
        assertEquals(value1, allValues.get(1));
    }

    @Test
    public void mocking() {
        System.out.println("mocking");
        System.out.println("--------");
        ArrayList list = mock(ArrayList.class);
        System.out.println(list.add("value1"));//false
        System.out.println(list.add("value2"));//false
        System.out.println(list.size());//0
        System.out.println(list.get(0));//null
        System.out.println(list.get(1));//null
        when(list.size()).thenReturn(5);
        System.out.println(list.size());//5
    }

    @Test
    public void spying() {
        System.out.println("spying");
        System.out.println("--------");
        ArrayList list = spy(ArrayList.class);
        System.out.println(list.add("value1"));//true
        System.out.println(list.add("value2"));//true
        System.out.println(list.get(0));//value1
        System.out.println(list.get(1));//value2
        System.out.println(list.size());//2
        when(list.size()).thenReturn(5);
        System.out.println(list.size());//5
        System.out.println(list.add("value3"));//true
        System.out.println(list.size());//5
    }
}
