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

    @Override
    public Void getResult() {
        return null;
    }

    @Override
    public void doAction(IInventory inventory) throws IllegalArgumentException {
        inventory.addItems(quantity);
    }

}
