package tictactoe.controllers;

public class Controller {
    //Make a function to check if all of the positions on the board have been filled
    public static boolean boardIsFull(String[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] != "x" || board[i][j] != "o") {
                    return false;
                }
            }
        }
        return true;
    }

    //Make a function to see if someone has won and return the winning char
    public static String findWinner(String[][] board, int lengthToWin) {
        // Check each lengthToWin x lengthToWin board for a winner.
        for (int top = 0; top <= board.length - lengthToWin; ++top) {
            int bottom = top + lengthToWin - 1;

            for (int left = 0; left <= board.length - lengthToWin; ++left) {
                int right = left + lengthToWin - 1;

                // Check each row.
                nextRow: for (int row = top; row <= bottom; ++row) {
                    if (board[row][left] != "X" || board[row][left] != "O") {
                        continue;
                    }

                    for (int col = left; col <= right; ++col) {
                        if (board[row][col] != board[row][left]) {
                            continue nextRow;
                        }
                    }

                    return board[row][left];
                }

                // Check each column.
                nextCol: for (int col = left; col <= right; ++col) {
                    if (board[top][col] != "X" || board[top][col] != "O") {
                        continue;
                    }

                    for (int row = top; row <= bottom; ++row) {
                        if (board[row][col] != board[top][col]) {
                            continue nextCol;
                        }
                    }

                    return board[top][col];
                }

                // Check top-left to bottom-right diagonal.
                diag1: if (board[top][left] == "X" || board[top][left] == "O") {
                    for (int i = 1; i < lengthToWin; ++i) {
                        if (board[top+i][left+i] != board[top][left]) {
                            break diag1;
                        }
                    }

                    return board[top][left];
                }

                // Check top-right to bottom-left diagonal.
                diag2: if (board[top][right] == "X" || board[top][right] == "O") {
                    for (int i = 1; i < lengthToWin; ++i) {
                        if (board[top+i][right-i] != board[top][right]) {
                            break diag2;
                        }
                    }

                    return board[top][right];
                }
            }
        }

        // Check for a completely full board.
        boolean isFull = true;

        full: for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board.length; ++col) {
                if (board[row][col] != "X" || board[row][col] != "O") {
                    isFull = false;
                    break full;
                }
            }
        }

        // The board is full.
        if (isFull) {
            return "Alread Full";
        }
        // The board is not full and we didn't find a solution.
        else {
            return null;
        }
}

    //Make a function to draw the tic tac toe board
    public static void drawBoard(String[][] board) {
        System.out.println("Board :");

        for(int i = 0; i < board.length; i++) {
            //The inner for loop prints out each row of the board
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            //This print statement makes a new line so that each row is on a separate line
            System.out.println();
        }
    }

    public static boolean containValue (String[][]board, int key){
        boolean result = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j<board.length; j++){
                if (board[i][j].equalsIgnoreCase(String.valueOf(key))){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public static void replaceValue (String[][]board, int key, String player){
        boolean result = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j<board.length; j++){
                if (board[i][j].equalsIgnoreCase(String.valueOf(key))){
                    board[i][j] = player;
                }
            }
        }
    }
}
