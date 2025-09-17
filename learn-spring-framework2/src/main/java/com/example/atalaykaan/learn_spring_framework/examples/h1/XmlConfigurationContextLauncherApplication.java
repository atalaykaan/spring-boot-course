package com.example.atalaykaan.learn_spring_framework.examples.h1;

import com.example.atalaykaan.learn_spring_framework.game.Game;
import com.example.atalaykaan.learn_spring_framework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//            System.out.println(context.getBean(Game.class));

            System.out.println(context.getBean("game"));

            System.out.println(context.getBean(GameRunner.class));

            context.getBean(GameRunner.class).run();
        }
    }
}
