package com.aja.guesstheword.guess_the_word.utils;

import com.aja.guesstheword.guess_the_word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils
{
    public static int MAX_TRIES = 5;

    @Autowired
    private  ConfigurableApplicationContext context;
    public static int reduceTry()
    {
        MAX_TRIES = MAX_TRIES-1;
        return MAX_TRIES;
    }

    public static int remainingTries()
    {
        return MAX_TRIES;
    }

    public  GameService reloadGame()
    {
        GameService gameService = context.getBean(GameService.class);
        return gameService;
    }
}
