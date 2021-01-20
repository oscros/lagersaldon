package src.main.java.lagersaldo;

public class Inventory {

    private int inventory;

    public Inventory() {
        inventory = 0;
    }

    private boolean isWithdrawalValid(int amountToWithdraw) {
        if (inventory >= amountToWithdraw && amountToWithdraw > -1) {
            return true;
        }
        return false;
    }

    private boolean isDepositValid(int amountToDeposit) {
        if (amountToDeposit > -1) {
            return true;
        }
        return false;
    }

    public void addInventory(int quantity) throws IllegalArgumentException {
        if (isDepositValid(quantity)) {
            inventory += quantity;
        } else {
            throw new IllegalArgumentException("Cannot add " + quantity + " goods to inventory");
        }
    }

    public void removeInventory(int quantity) throws IllegalArgumentException {
        if (isWithdrawalValid(quantity)) {
            inventory -= quantity;
        } else {
            throw new IllegalArgumentException("Cannot remove " + quantity + " goods from inventory");
        }
    }

    public int getInventory() {
        return inventory;
    }

}
