package tictactoe;

import tictactoe.controllers.Controller;

import java.util.Scanner;

import static tictactoe.controllers.Controller.*;

class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lengthMatrix = 0;
        int number = 0;

        //Create a 3x3 array that represents our tic tac toe board
        System.out.print("Enter the length of board : ");
        lengthMatrix = scan.nextInt();
        String[][] board = new String[lengthMatrix][lengthMatrix];

        //Initialize our board with dashes (empty positions)
        int value = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = String.valueOf(value);
                value++;
            }
        }

        //Create a Scanner and ask the players for their names
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, what is your name? ");
        String p2 = in.nextLine();

        //Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
        boolean player1 = true;

        //Create a gameEnded boolean and use it as the condition in the while loop
        boolean gameEnded = false;
        while (!gameEnded) {

            //Draw the board
            drawBoard(board);

            //Print whose turn it is
            if (player1) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            String c = "";
            if (player1) {
                c = "X";
            } else {
                c = "O";
            }

            //Only break out of the while loop once the user enters a valid position
            while (true) {

                //Ask the user for what position they want to place their x or o
                System.out.print("Enter the number : ");
                number = in.nextInt();

                boolean check = Controller.containValue(board, number);
                if (!check) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                } else {
                    break;
                }

            }

            //Set the position on the board at row, col to c
            replaceValue(board, number, c);

            //Check to see if either player has won
//            if (playerHasWon(board) == "X") {
//                System.out.println(p1 + " has won!");
//                gameEnded = true;
//            } else if (playerHasWon(board) == "O") {
//                System.out.println(p2 + " has won!");
//                gameEnded = true;
//            } else {
                if (findWinner(board,lengthMatrix) == "X") {
                    System.out.println(p1 + " has won!");
                    gameEnded = true;
                } else if (findWinner(board,lengthMatrix) == "O") {
                    System.out.println(p2 + " has won!");
                    gameEnded = true;
                } else {

                    //If neither player has won, check to see if there has been a tie (if the board is full)
                    if (boardIsFull(board)) {
                        System.out.println("It's a tie!");
                        gameEnded = true;
                    } else {
                        //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                        player1 = !player1;
                    }

                }
            }

        //Draw the board at the end of the game
        drawBoard(board);

    }
}