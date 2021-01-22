package lagersaldo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;



public class SellInventoryActionTest {
    @Test
    public void testDoAction() {
        SellInventoryAction sellActionType = new SellInventoryAction(10);
        Inventory mockInventory = mock(Inventory.class);

        doAnswer(invocation -> {
            return null;
        }).when(mockInventory).removeItems(anyInt());

        sellActionType.doAction(mockInventory);
        verify(mockInventory, times(1)).removeItems(anyInt());;
    }

    @Test
    public void testGetActionType() {
        SellInventoryAction sellActionType = new SellInventoryAction(10);

        assertEquals(ActionType.Sell, sellActionType.getActionType());
    }

    @Test
    public void testGetResult() {
        SellInventoryAction sellActionType = new SellInventoryAction(10);

        assertEquals(null, sellActionType.getResult());
    }
}
