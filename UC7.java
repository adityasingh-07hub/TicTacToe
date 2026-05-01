import java.util.Random;

public class UC7 {
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };
    static char computerSymbol = 'O';

    public static void main(String[] args) {
        computerMove();
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random rand = new Random();
        int slot, row, col;
        do {
            slot = rand.nextInt(9) + 1; // 1-9
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (board[row][col] != '-');

        board[row][col] = computerSymbol;
        System.out.println("Computer placed at slot: " + slot);
    }
}