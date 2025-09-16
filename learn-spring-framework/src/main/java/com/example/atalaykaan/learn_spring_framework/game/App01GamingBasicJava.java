package com.example.atalaykaan.learn_spring_framework.game;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        Game game = new MarioGame();
        GameRunner gameRunner = new GameRunner(game);

        gameRunner.run();
    }

}
