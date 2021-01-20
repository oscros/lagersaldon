package src.main.java.lagersaldo;

public class InventoryController {

    private IInventory inventory = new Inventory();

    public InventoryController(IInventory inventory) {
        this.inventory = inventory;
    }

    public String performAction(String input) throws IllegalArgumentException {
        InventoryAction action = InputParser.parseInput(input);
        switch (action.getType()) {
            case "S":
                inventory.removeInventory(action.getQuantity());
                return "OK";
            case "I":
                inventory.addInventory(action.getQuantity());
                return "OK";
            case "L":
                return "Current inventory: " + inventory.getInventory();
            default:
                throw new IllegalArgumentException("Invalid action type");
        }
    }
}
