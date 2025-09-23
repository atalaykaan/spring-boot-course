package com.atalaykaan.learn_spring_aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] retrieveData() {

//        throw new RuntimeException("Error!");

        try{
            Thread.sleep(30);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        return new int[] {111, 222, 333, 444, 555};
    }
}
