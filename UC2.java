import java.util.Random;

public class UC2 {
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    static void tossAndAssignSymbols() {
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1
        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    static void displayTossResult() {
        if (isHumanTurn)
            System.out.println("Human goes first! Human = " + humanSymbol + ", Computer = " + computerSymbol);
        else
            System.out.println("Computer goes first! Computer = " + computerSymbol + ", Human = " + humanSymbol);
    }
}