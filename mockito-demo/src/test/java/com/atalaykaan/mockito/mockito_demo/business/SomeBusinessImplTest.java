package com.atalaykaan.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    void findTheGreatestFromAllData_basicWithThreeValues() {

        DataService dataService = new DataServiceStub1();

        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);

        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_basicWithOneValue() {

        DataService dataService = new DataServiceStub2();

        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);

        assertEquals(35, someBusiness.findTheGreatestFromAllData());
    }

}

class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {

        return new int[] {25, 15, 2};
    }
}

class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {

        return new int[] { 35 };
    }
}