package com.sasha.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());

    }

    @Test
    public void letsMockListSizeMethod_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());


    }

    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("xxx");
        assertEquals("xxx",listMock.get(0));
    }

    @Test
    public void letsMockListGet_UsingBDD(){

        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(0)).willReturn("xxx");

        //When
        String firstElement = listMock.get(0);


        //Then

        assertThat(firstElement, is("xxx"));
        assertEquals("xxx",firstElement);
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGet_WithException(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenThrow(new RuntimeException("Something wrong"));
        listMock.get(0);

    }



}
