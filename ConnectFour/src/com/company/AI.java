package com.company;

import java.util.Random;

public class AI extends Player{
    private Board config;
    private String moveBuffer;
    private String difficulty;

    public AI(char turn, Board b){
        super(turn,b);
    }

    //Random
    public void randomPlay(){
        Random rand = new Random();
        int r = rand.nextInt(config.getWidth()+1);
        while(config.validMove(r) == -1){
            r = rand.nextInt(config.getWidth()+1);
        }
        play(r);
    }

    public void minMaxPlay(){
        return;
    }

    public void alphaBetaPlay(){
        return;
    }


}
