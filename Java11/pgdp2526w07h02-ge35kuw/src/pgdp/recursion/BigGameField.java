package pgdp.recursion;

public class BigGameField {
    protected int[][] board; // 9x9 game field (0 = empty)
    protected boolean[][] fixed; // Indicates whether a cell is fixed

    public BigGameField(int[][] initialGrid) {
        board = new int[9][9];
        fixed = new boolean[9][9];
        //TODO : Initialize the field at the beginning.
    }

    protected boolean isSafe(int row, int col, int num) {
        //TODO : Check if the position (row, col) is safe for the penguin from family number num.
        return false;
    }

    protected boolean isRowSafe(int row, int num) {
        //TODO : Check recursively if the row is safe.
        return false;
    }

    protected boolean isColSafe(int col, int num) {
        //TODO : Check recursively if the column is safe.
        return false;
    }

    protected boolean isBlockSafe(int startRow, int startCol, int num) {
        //TODO : Check recursively if the column is safe.
        return false;
    }


    public boolean isFixed(int row, int col) {
        return fixed[row][col];
    }

    protected void placePenguin(int row, int col, int num) {
        //TODO : Place a penguin with family number (num) at position (row, col).
    }


    protected void removePenguin(int row, int col) {
        //TODO : Remove a penguin from position (row, col).
    }


    //This method print the grid with the numbers of placed penguins on it.
    public void printGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
