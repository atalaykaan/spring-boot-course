package com.example.atalaykaan.learn_spring_framework;

import com.example.atalaykaan.learn_spring_framework.game.Game;
import com.example.atalaykaan.learn_spring_framework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(GamingConfiguration.class)) {

            context.getBean(GameRunner.class).run();

            context.getBean(Game.class).up();
        }
    }
}
