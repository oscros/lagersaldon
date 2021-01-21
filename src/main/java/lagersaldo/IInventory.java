package lagersaldo;

public interface IInventory {
    public void addItems(int quantity);
    public void removeItems(int quantity);
    public int getInventory();
}
