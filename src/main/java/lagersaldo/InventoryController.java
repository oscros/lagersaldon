package src.main.java.lagersaldo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOException;
import java.util.ArrayList;

public class InventoryController {

    private Inventory inventory = new Inventory();

    class InventoryAction {
        private String type;
        private int quantity;

        public InventoryAction() {
        }

        public InventoryAction(String type) {
            this.type = type;
        }

        public InventoryAction(String type, int quantity) {
            this.type = type;
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getType() {
            return type;
        }
    }


    public boolean validInput(String input) {
        Pattern validPattern = Pattern.compile("^([SIH]{1}\\d{1,6})$|^L$");
        Matcher matcher = validPattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Found matching pattern:");
            return true;
        }
        return false;
    }

    private InventoryAction parseInput(String input) throws IllegalArgumentException {
        if (!validInput(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        if (input.equals("L")) {
            return new InventoryAction(input);
        }

        StringBuilder sb = new StringBuilder(input);
        String actionString = sb.substring(0, 1);
        String quantityString = sb.substring(1);
        int quantity = Integer.parseInt(quantityString);

        return new InventoryAction(actionString, quantity);
    }

    public String performAction(String input) throws IllegalArgumentException {
        InventoryAction action = parseInput(input);
        return updateInventory(action);
    }

    private String updateInventory(InventoryAction action) throws IllegalArgumentException {
        switch (action.getType()) {
            case "S":
                inventory.removeInventory(action.getQuantity());
                return "OK";
            case "I":
                inventory.addInventory(action.getQuantity());
                return "OK";
            case "L":
                return "Current inventory: " + inventory.getInventory();
            case "H":
                inventory.addInventory(10);
                return "OK";
            default:
                throw new IllegalArgumentException("Invalid action type");
        }
    }
}
