package lagersaldo;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeliverInventoryTest {
    @Test
    public void testDoAction() {
        DeliverInventoryAction deliverActionType = new DeliverInventoryAction(10);
        Inventory mockInventory = mock(Inventory.class);

        doAnswer(invocation -> {
            return null;
        }).when(mockInventory).removeItems(anyInt());

        deliverActionType.doAction(mockInventory);
        verify(mockInventory, times(1)).addItems(anyInt());
    }

    @Test
    public void testGetActionType() {
        DeliverInventoryAction deliverActionType = new DeliverInventoryAction(10);

        assertEquals(ActionType.Deliver, deliverActionType.getActionType());
    }

    @Test
    public void testGetResult() {
        DeliverInventoryAction deliverActionType = new DeliverInventoryAction(10);

        assertEquals(null, deliverActionType.getResult());
    }
}
