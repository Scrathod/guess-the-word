package com.aja.guesstheword.guess_the_word.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService
{

    private String randomelyChoosenWord;


    private String[] randomWord = {"father","mother","light","java","gold","cricket","light"};

    private char[] charArray;
    Random random = new Random();

    public GameService() {
        randomelyChoosenWord = randomWord[random.nextInt(randomWord.length)];
        System.out.println("randomely choosen word : "+randomelyChoosenWord);
        charArray = new char[randomelyChoosenWord.length()];
    }

    @Override
    public String toString()
    {
        String ret = "";
        for(char ch : charArray)
        {

                if(ch=='\u0000') {
                    ret = ret + "_";
                }
                else {
                    ret = ret+ch;
                }
                ret = ret+" ";

        }
        return ret;
    }

    public boolean addGuess(char c)
    {
        boolean isGessCorrect = false;
        for (int i = 0; i <randomelyChoosenWord.length() ; i++)
        {
            if(c==randomelyChoosenWord.charAt(i))
            {
                charArray[i] = c;
                isGessCorrect = true;
            }

        }
        return isGessCorrect;
    }
}
