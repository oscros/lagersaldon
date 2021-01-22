package lagersaldo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class RetrieveInventoryActionTest {
    @Test
    public void testDoAction() {
        RetrieveInventoryAction retrieveActionType = new RetrieveInventoryAction();
        Inventory mockInventory = mock(Inventory.class);

        when(mockInventory.getInventory()).thenReturn(10);

        retrieveActionType.doAction(mockInventory);
        verify(mockInventory, times(1)).getInventory();
    }

    @Test
    public void testGetActionType() {
        RetrieveInventoryAction retrieveActionType = new RetrieveInventoryAction();

        assertEquals(ActionType.Retrieve, retrieveActionType.getActionType());
    }

    @Test
    public void testGetResult() {
        RetrieveInventoryAction retrieveActionType = new RetrieveInventoryAction();

        assertEquals(Integer.class, retrieveActionType.getResult().getClass());
    }
}
