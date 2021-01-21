package lagersaldo;

public interface IInventory {
    public void addInventory(int quantity);
    public void removeInventory(int quantity);
    public int getInventory();
}
