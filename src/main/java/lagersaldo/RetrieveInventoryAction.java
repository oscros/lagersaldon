package lagersaldo;

public class RetrieveInventoryAction implements IInventoryAction{

    private int actionResult;

    @Override
    public ActionType getActionType() {
        return ActionType.Retrieve;
    }

    @Override
    public Integer getResult() {
        return actionResult;
    }

    @Override
    public void doAction(IInventory inventory) {
        actionResult = inventory.getInventory();
    }
}
