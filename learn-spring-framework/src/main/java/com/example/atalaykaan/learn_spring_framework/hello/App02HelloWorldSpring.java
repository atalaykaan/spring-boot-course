package com.example.atalaykaan.learn_spring_framework.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean(Person.class));

            System.out.println(context.getBean("person4Parameters"));

            System.out.println(context.getBean("person5Qualifier"));
        }
    }
}
