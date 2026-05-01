public class UC10 {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        System.out.println(isDraw());
    }

    /**
     * Traverses the board to check for any remaining empty cells.
     * Output: true if draw, false otherwise.
     */
    static boolean isDraw() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == '-')
                    return false;
        return true;
    }
}