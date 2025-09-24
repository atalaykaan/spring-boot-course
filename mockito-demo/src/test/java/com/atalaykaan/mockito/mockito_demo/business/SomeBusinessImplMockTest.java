package com.atalaykaan.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllData_WithThreeValues() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_WithOneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 40 });
        assertEquals(40, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });
        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestFromAllData());
    }
}
