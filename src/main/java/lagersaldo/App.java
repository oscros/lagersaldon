package lagersaldo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        IInventory inventory = new Inventory();
        while (true) {
            String input = in.nextLine();
            try {
                IInventoryAction action = InputParser.parseInput(input);
                action.doAction(inventory);
                View.printResult(action);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
