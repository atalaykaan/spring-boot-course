package com.example.atalaykaan.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    Game game;

    public GameRunner(@Qualifier("SuperContraGameQualifier") Game game) {

        this.game = game;
    }

    public void run() {

        System.out.println("Now running game: " + game);

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
