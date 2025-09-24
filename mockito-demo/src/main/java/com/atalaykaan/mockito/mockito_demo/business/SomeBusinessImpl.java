package com.atalaykaan.mockito.mockito_demo.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {

        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {

        int greatest = Integer.MIN_VALUE;

        for(int i : dataService.retrieveAllData()) {

            if(i > greatest) {

                greatest = i;
            }
        }

        return greatest;
    }
}

interface DataService {

    int[] retrieveAllData();
}