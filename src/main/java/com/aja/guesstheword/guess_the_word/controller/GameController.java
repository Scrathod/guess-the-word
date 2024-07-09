package com.aja.guesstheword.guess_the_word.controller;

import com.aja.guesstheword.guess_the_word.service.GameService;
import com.aja.guesstheword.guess_the_word.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController
{

    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;
    @GetMapping("/game-home-page")
    public String showGameHomePage(String guessedChar, Model model)
    {
        if(guessedChar!=null) {
            System.out.println("Guessed Character is : " + guessedChar);
            boolean isGuessCorrect = gameService.addGuess(guessedChar.charAt(0));
            if(isGuessCorrect==false)
            {
                GameUtils.reduceTry();
            }
        }
        System.out.println("Remaining Tries : "+GameUtils.remainingTries());
        String words = gameService.toString();

        model.addAttribute("randomwords",words);
        model.addAttribute("remainingTries",GameUtils.remainingTries());
        return "game-home-page";
    }

    @GetMapping("/reload")
    public String reload()
    {
        gameService = gameUtils.reloadGame();
        GameUtils.MAX_TRIES = 5;
        return "redirect:/game-home-page";
    }
}
