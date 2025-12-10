package pgdp.recursion;

import java.util.ArrayList;
import java.util.List;

public class SecondRoundPositions {
    protected int BOARD_SIZE;
    protected char[][] board; //tournament board
    protected List<Penguin> bestPenguins; // Best penguins from the first round

    public SecondRoundPositions(int boardSize) {
        this.BOARD_SIZE = boardSize;
        board = new char[BOARD_SIZE][BOARD_SIZE];
        bestPenguins = new ArrayList<>();

        // Initializing the board with empty spaces '.'
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '.';
            }
        }

        // Add queens from each family.
        for (int i = 1; i <= BOARD_SIZE; i++) {
            bestPenguins.add(new Penguin(i, true));
        }
    }

    public boolean placeQueens() {
        return placeQueens(0);
    }

    protected boolean placeQueens(int col) {
        // TODO : Place the queen penguins on the 9x9 field.
        return false;
    }


    protected boolean isSafe(int row, int col) {
        // TODO : Check if placing a queen at (row, col) is safe.
        //  Use the methods below as helpers.
        return false;
    }

    protected boolean isRowSafe(int row, int col) {
        // TODO : Implement recursively.
        return false;
    }

    protected boolean isUpperDiagonalSafe(int row, int col) {
        // TODO : Implement recursively.
        return false;
    }

    protected boolean isLowerDiagonalSafe(int row, int col) {
        // TODO : Implement recursively.
        return false;
    }

    //This method prints the board with the queens placed on it.
    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Here you can change the boardSize to see several examples.
        int boardSize = 18;
        SecondRoundPositions tournament = new SecondRoundPositions(boardSize);
        System.out.println("Starting Penguin Tournament on a " + boardSize + "x" + boardSize + " board!");

        if (tournament.placeQueens()) {
            System.out.println("Tournament final board:");
            tournament.printBoard();
        } else {
            System.out.println("No solution found for the tournament.");
        }
    }
}
