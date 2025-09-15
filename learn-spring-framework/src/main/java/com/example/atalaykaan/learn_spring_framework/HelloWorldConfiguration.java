package com.example.atalaykaan.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) { };

record Address (String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {

        return "Kaan";
    }

    @Bean
    public int age() {

        return 22;
    }

    @Bean
    public Person person() {

        Person person = new Person("Kaan", 22, new Address("Germany", "Berlin"));

        return person;
    }

    @Bean
    public Person person2MethodCall() {
        Person person = new Person(name(), age(), address());

        return person;
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        Person person = new Person(name, age, address3);

        return person;
    }

    @Bean(name = "address2")
    public Address address() {

        Address address = new Address("Türkiye", "İstanbul");

        return address;
    }

    @Bean(name = "address3")
    public Address address2() {
        Address address = new Address("Paris", "France");

        return address;
    }
}
