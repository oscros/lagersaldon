package lagersaldo;

public class DeliverInventoryAction implements IInventoryAction {

    private int quantity;

    public DeliverInventoryAction(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.Deliver;
    }

    /**
     * Always returns null since this actions doesn't have any results
     */
    @Override
    public Void getResult() {
        return null;
    }

    @Override
    public void doAction(IInventory inventory) throws IllegalArgumentException {
        inventory.addItems(quantity);
    }

}
