package lagersaldo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        IInventory inventory = new Inventory();
        while (true) {
            String input = in.nextLine();
            if (InputParser.isValidInput(input)) {
                IInventoryAction action = InputParser.parseInput(input);
                action.doAction(inventory);
                View.printResult(action);
            } else {
                System.err.println("Invalid input: " + input);
            }
        }
    }
}
