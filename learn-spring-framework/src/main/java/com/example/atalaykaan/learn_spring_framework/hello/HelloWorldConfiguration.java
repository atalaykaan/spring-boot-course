package com.example.atalaykaan.learn_spring_framework.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        Person person = new Person(name, age, address);

        return person;
    }

    @Bean
    public Person person5Qualifier(String name, int age,@Qualifier("address3qualifier") Address address) {
        Person person = new Person(name, age, address);

        return person;
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {

        Address address = new Address("Türkiye", "İstanbul");

        return address;
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address2() {
        Address address = new Address("Paris", "France");

        return address;
    }
}
