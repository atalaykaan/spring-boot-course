package com.example.atalaykaan.learn_spring_framework;

import com.example.atalaykaan.learn_spring_framework.game.Game;
import com.example.atalaykaan.learn_spring_framework.game.GameRunner;
import com.example.atalaykaan.learn_spring_framework.game.MarioGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        Game game = new MarioGame();
        GameRunner gameRunner = new GameRunner(game);

        gameRunner.run();
    }

}
