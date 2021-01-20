package src.main.java.lagersaldo;

public class RetrieveInventoryAction implements IInventoryAction{

    private int actionResult;

    @Override
    public Integer getResult() {
        return actionResult;
    }

    @Override
    public void doAction(IInventory inventory) {
        actionResult = inventory.getInventory();
    }
}
