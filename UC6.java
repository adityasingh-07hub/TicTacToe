public class UC6 {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        placeMove(0, 0, 'X');
        System.out.println(board[0][0]);
    }

    /**
     * Updates the board by placing the given symbol at
     * the specified row and column.
     * Input: Row, Column, Symbol
     * Hint: Assume the move is already validated.
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}