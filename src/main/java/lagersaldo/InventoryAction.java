package src.main.java.lagersaldo;

public class InventoryAction {

    private String type;
    private int quantity;

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
