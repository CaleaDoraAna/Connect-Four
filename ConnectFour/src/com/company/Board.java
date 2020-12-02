package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int height = 6;
    private int width = 7;
    private static int lastRow;
    private static int lastCol;

    private char[][] grid = new char[width][height];

    public Board(int width, int height){
        this.width = width; //TODO: fix index bug
        this.height = height;
        for (char[] row: grid)
            Arrays.fill(row, '.');
    }

    public Board(int width, int height, char[][] board){
        this.width = width;
        this.height = height;
        for(int i = 0; i < width; i++) {
            if (height >= 0) System.arraycopy(board[i], 0, grid[i], 0, height);
        }
    }

    public int validMove(int position){
        for(int row = 0; row < width; row++){
            if(grid[row][position] == '.')
                return row;
        }
        System.out.println("Invalid move.");
        return -1;
    }

    public void showBoard(){
        for(int i = height - 1; i >= 0; i--){
            for(int j = 0; j < width - 1; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.deepToString(grid));
        /*for (char[] x : grid)
        {
            for (char y : x)
            {
                System.out.print( y + " ");
            }
            System.out.println();
        }*/
    }

    public void addChip(int row, int col, char turn){
        grid[row][col] = turn;
        lastCol = col;
        lastRow = row;
    }

    public void clearBoard(){
        for (char[] row: grid)
            Arrays.fill(row, '.');
    }

    public boolean checkHorizontally(char turn){
        int count = 0;
        for (int i=0; i < height-1; i++){
            if (grid[lastRow][i] == turn){
                count++;}
            else
                count=0;
            if (count>=4)
                return true;
        }
        return false;
    }

    public boolean checkVertically(char turn){
        int count = 0;
        for (int i = 0; i < width; i++){
            if (grid[i][lastCol]==turn)
                count++;
            else
                count=0;
            if (count>=4)
                return true;
        }
        return false;
    }

    public boolean checkDiagonally(char turn){
        int flag = 0;
        for (int i = 3; i < width; i++){
            for (int j = 3; j < height; j++){
                if (grid[i][j] == turn && grid[i-1][j-1] == turn && grid[i-2][j-2] == turn && grid[i-3][j-3] == turn)
                    flag++;
            }
        }

        for (int i = 3; i < width; i++){
            for (int j = 0; j < height-3; j++){
                if (grid[i][j] == turn && grid[i-1][j+1] == turn && grid[i-2][j+2] == turn && grid[i-3][j+3] == turn)
                    flag++;
            }
        }

        if(flag!=0)
            return true;
        return false;
    }

    public boolean checkForWin(char turn){
        return checkHorizontally(turn) ||  checkDiagonally(turn) || checkVertically(turn);
    }

    public boolean checkForDraw(){
        for(int i = 0; i < width; i++){
            if(validMove(i) != -1)
                return false;
        }
        return true;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
