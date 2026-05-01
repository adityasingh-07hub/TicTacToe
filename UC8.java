import java.util.Random;
import java.util.Scanner;

public class UC8 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        // Toss
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }

        System.out.println("Human = " + humanSymbol + " | Computer = " + computerSymbol);
        printBoard();

        // Game Loop
        while (!gameOver) {

            if (isHumanTurn) {
                System.out.println("Your turn! Enter slot (1-9):");
                int slot = getUserSlot();
                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (!isValidMove(row, col)) {
                    System.out.println("Invalid move! Try again.");
                    continue; // don't switch turn
                }

                placeMove(row, col, humanSymbol);
                printBoard();

                if (hasWon(humanSymbol)) {
                    System.out.println("You win!");
                    gameOver = true;
                } else if (isDraw()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                }

            } else {
                System.out.println("Computer's turn...");
                computerMove();
                printBoard();

                if (hasWon(computerSymbol)) {
                    System.out.println("Computer wins!");
                    gameOver = true;
                } else if (isDraw()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                }
            }

            if (!gameOver)
                isHumanTurn = !isHumanTurn; // switch turn
        }
    }

    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2)
            return false;
        return board[row][col] == '-';
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    static void computerMove() {
        Random rand = new Random();
        int slot, row, col;
        do {
            slot = rand.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (board[row][col] != '-');
        board[row][col] = computerSymbol;
        System.out.println("Computer placed at slot: " + slot);
    }

    static boolean hasWon(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;
        return false;
    }

    static boolean isDraw() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == '-')
                    return false;
        return true;
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
                System.out.print(board[row][col] + " | ");
            System.out.println();
            System.out.println("-------------");
        }
    }
}