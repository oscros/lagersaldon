package lagersaldo;

public interface IInventoryAction {
    <T> T getResult();
    void doAction(IInventory inventory);
}
