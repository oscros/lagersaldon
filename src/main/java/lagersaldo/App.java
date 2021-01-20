package src.main.java.lagersaldo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        IInventory inventory = new Inventory();
        InventoryController controller = new InventoryController(inventory);
        while (true) {
            String input = in.nextLine();
            try {
                String result = controller.performAction(input);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
