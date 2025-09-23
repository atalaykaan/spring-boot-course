package com.atalaykaan.learn_spring_aop.business;

import com.atalaykaan.learn_spring_aop.annotations.TrackTime;
import com.atalaykaan.learn_spring_aop.data.DataService1;
import com.atalaykaan.learn_spring_aop.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private DataService2 dataService;

    @Autowired
    public BusinessService2(DataService2 dataService) {

        this.dataService = dataService;
    }

    @TrackTime
    public int calculateMin() {

//        throw new RuntimeException("Something went wrong");

        return Arrays.stream(dataService.retrieveData()).min().orElse(0);
    }
}
