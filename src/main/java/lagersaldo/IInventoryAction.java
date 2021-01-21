package lagersaldo;

public interface IInventoryAction {
    ActionType getActionType();
    <T> T getResult();
    void doAction(IInventory inventory);
}
