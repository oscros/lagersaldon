package lagersaldo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



public class InventoryTest {

    @ParameterizedTest(name = "Should return the inventory \"{0}\"")
    @ValueSource(ints = { 0, 100, 1000000 })
    public void testGetInventory(int actualQuantity) {
        Inventory inventory = new Inventory();
        inventory.addItems(actualQuantity);

        assertEquals(actualQuantity, inventory.getInventory());
    }

    @Test
    public void testInventory() {
        Inventory inventory = new Inventory();

        assertEquals(0, inventory.getInventory());
    }

    @ParameterizedTest(name = "Should add \"{0}\" to the inventory")
    @ValueSource(ints = { 0, 100, 1000000 })
    public void testAddInventory(int actualQuantity) {
        Inventory inventory = new Inventory();
        inventory.addItems(actualQuantity);

        assertEquals(actualQuantity, inventory.getInventory());
    }

    @Test
    public void testUnsuccessfullAddInventory() {
        Inventory inventory = new Inventory();

        assertThrows(IllegalArgumentException.class, () -> {
            inventory.addItems(-100);
        });
    }

    @ParameterizedTest(name = "Should remove \"{0}\" to the inventory")
    @ValueSource(ints = { 0, 100, 10000000 })
    public void testSuccessfullRemoveInventory(int quantityToRemove) throws IllegalArgumentException {
        Inventory inventory = new Inventory();
        inventory.addItems(quantityToRemove);

        inventory.removeItems(quantityToRemove);

        assertEquals(0, inventory.getInventory());
    }

    @ParameterizedTest(name = "Should throw exception when removing  \"{0}\" from inventory containing 0")
    @ValueSource(ints = { -100, 100, 10000000 })
    public void testUnsuccessfullRemoveInventory(int quantityToRemove) {
        Inventory inventory = new Inventory();

        assertThrows(IllegalArgumentException.class, () -> {
            inventory.removeItems(quantityToRemove);
        });
    }
}
