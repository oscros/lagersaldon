package lagersaldo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import src.main.java.lagersaldo.Inventory;
import src.main.java.lagersaldo.RetrieveInventoryAction;

public class RetrieveInventoryActionTest {
    @Test
    public void testDoAction() {
        RetrieveInventoryAction retrieveAction = new RetrieveInventoryAction();
        Inventory mockInventory = mock(Inventory.class);

        when(mockInventory.getInventory()).thenReturn(10);

        retrieveAction.doAction(mockInventory);
        verify(mockInventory, times(1)).getInventory();
    }

    @Test
    public void testGetResult() {
        RetrieveInventoryAction retrieveAction = new RetrieveInventoryAction();

        assertEquals(Integer.class, retrieveAction.getResult().getClass());
    }
}
