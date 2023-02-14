package com.sasha.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
        when(arrayListSpy.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, arrayListSpy.size());

        assertEquals(2, arrayListSpy.size());

        verify(arrayListSpy,times(2)).size();


    }
}
