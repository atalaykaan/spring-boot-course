package com.atalaykaan.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Mock
    private List<String> list;

    @Test
    void simpleTest() {

//        List<String> list = mock(List.class);
        when(list.size()).thenReturn(3);

        assertEquals(3, list.size());
    }

    @Test
    void multipleReturns() {

//        List<String> list = mock(List.class);
        when(list.size()).thenReturn(1).thenReturn(5);

        assertEquals(1, list.size());
        assertEquals(5, list.size());
        assertEquals(5, list.size());
        assertEquals(5, list.size());
    }

    @Test
    void specificParameters() {

//        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("SomeString");

        assertEquals("SomeString", list.get(0));
        assertEquals(null, list.get(1));
    }

    @Test
    void genericParameters() {

//        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenReturn("SomeString");

        assertEquals("SomeString", list.get(0));
        assertEquals("SomeString", list.get(1));
    }
}
