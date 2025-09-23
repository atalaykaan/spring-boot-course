package com.atalaykaan.learn_spring_aop.business;

import com.atalaykaan.learn_spring_aop.annotations.TrackTime;
import com.atalaykaan.learn_spring_aop.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService;

    @Autowired
    public BusinessService1(DataService1 dataService) {

        this.dataService = dataService;
    }

    @TrackTime
    public int calculateMax() {

//        throw new RuntimeException("Something went wrong");

        try{
            Thread.sleep(30);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
