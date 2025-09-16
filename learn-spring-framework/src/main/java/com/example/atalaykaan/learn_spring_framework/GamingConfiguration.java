package com.example.atalaykaan.learn_spring_framework;

import com.example.atalaykaan.learn_spring_framework.game.Game;
import com.example.atalaykaan.learn_spring_framework.game.GameRunner;
import com.example.atalaykaan.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public Game game() {
        Game game = new PacmanGame();

        return game;
    }

    @Bean
    public GameRunner gameRunner(Game game) {
        GameRunner gameRunner = new GameRunner(game);

        return gameRunner;
    }
}
