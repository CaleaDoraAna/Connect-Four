package com.company;

public class Player {
    private static final char[] players = {'R','Y'};
    private char turn;
    private Board config;
    private boolean gameover = false;

    public Player(char turn, Board b){
        this.turn = turn;
        this.config = b;
    }

    public void play(int position){
        //Check if position is valid
        int row = config.validMove(position);
        if(row != -1){
            config.addChip(row,position,turn);
        }
        config.showBoard();
    }

    public boolean checkGameOver(){
        //System.out.println(config.checkForWin(turn));
        if(config.checkForWin(turn)){
            System.out.println(turn + " won!");
            gameover = true;
        }
        else if(config.checkForDraw()){
            System.out.println("It's a draw.");
            gameover = true;
        }
        else endTurn();
        return gameover;
    }

    public char getCurrentPlayer() {
        return turn;
    }

    public void endTurn(){
        if(turn == players[1])
            turn = players[0];
        else if(turn == players[0])
            this.turn = players[1];
    }
}
