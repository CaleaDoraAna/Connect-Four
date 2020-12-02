package com.company;



import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        // Method Tests - (will be deleted)
        /*Board b =  new Board(7,6);
        b.showBoard();
        System.out.println();
        b.addChip(0,0,'Y');
        b.showBoard();
        System.out.println();
        b.addChip(1,0,'Y');
        b.showBoard();
        System.out.println();
        b.addChip(2,0,'Y');
        b.showBoard();
        System.out.println();
        b.addChip(3,0,'Y');
        b.showBoard();
        System.out.println();
        if(b.checkVertically('Y')) System.out.println("yes");*/

        Board b =  new Board(7,6);

        System.out.println("      CONNECT FOUR        ");
        System.out.println("-------------------------\n");
        System.out.println("1 - Player vs Player");
        System.out.println("2 - Player vs AI"); // TODO: Implement this
        System.out.println("3 - Quit");
        Scanner scan = new Scanner(System.in);
        int choice =  scan.nextInt();
        switch (choice){
            case 1: {
                Player p = new Player('R',b);
                b.showBoard();
                while(!p.checkGameOver()){
                    System.out.println(p.getCurrentPlayer() + "'s TURN: ");
                    int position = scan.nextInt();
                    p.play(position);
                }
                break;
            }
            case 2: break;
            case 3: System.exit(0);
            default: throw new IllegalArgumentException(choice  + " is not an option.");
        }



        scan.close();

    }
    //TODO: minmax, alphaBeta, gui, transposition table for optimization and trap awareness (optional)
}
