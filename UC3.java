import java.util.Scanner;

public class UC3 {

    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    /**
     * Reads an integer slot value from the user.
     * Input: Scanner object
     * Output: Slot number (1-9)
     * Hint: Validation will be added in later use cases.
     */
    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter slot number (1-9): ");
        int slot = sc.nextInt();
        return slot;
    }
}