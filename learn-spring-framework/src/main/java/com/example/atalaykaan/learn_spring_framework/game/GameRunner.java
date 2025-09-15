package com.example.atalaykaan.learn_spring_framework.game;

public class GameRunner {

    Game game;

    public GameRunner(Game game) {

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
