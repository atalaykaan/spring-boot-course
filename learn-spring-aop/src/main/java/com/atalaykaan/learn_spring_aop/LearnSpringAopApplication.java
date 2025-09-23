package com.atalaykaan.learn_spring_aop;

import com.atalaykaan.learn_spring_aop.business.BusinessService1;
import com.atalaykaan.learn_spring_aop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnSpringAopApplication {

    private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(String[] args, BusinessService1 businessService1, BusinessService2 businessService2) {

        return (runner) -> {

            logger.info("Value returned is: {}", businessService1.calculateMax());
            logger.info("Value returned is: {}", businessService2.calculateMin());
        };
    }

}
