package lagersaldo;

import com.google.common.annotations.VisibleForTesting;

public class Inventory implements IInventory {

    private int inventory;

    @VisibleForTesting
    protected void setInventoryForTest(int quantity) {
        inventory = quantity;
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

    public void addItems(int quantity) throws IllegalArgumentException {
        if (isDepositValid(quantity)) {
            inventory += quantity;
        } else {
            throw new IllegalArgumentException("Cannot add " + quantity + " goods to inventory");
        }
    }

    public void removeItems(int quantity) throws IllegalArgumentException {
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
