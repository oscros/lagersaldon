package lagersaldo;

public class SellInventoryAction implements IInventoryAction {

    private int quantity;

    public SellInventoryAction(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.Sell;
    }

    /**
     * Always returns null since this actions doesn't have any results
     */
    @Override
    public Void getResult() {
        return null;
    }

    @Override
    public void doAction(IInventory inventory) {
        inventory.removeItems(quantity);
    }
    
}
