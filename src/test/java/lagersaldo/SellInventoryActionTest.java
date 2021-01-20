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

import src.main.java.lagersaldo.Inventory;
import src.main.java.lagersaldo.SellInventoryAction;

public class SellInventoryActionTest {
    @Test
    public void testDoAction() {
        SellInventoryAction sellAction = new SellInventoryAction(10);
        Inventory mockInventory = mock(Inventory.class);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                return null;
            }
        }).when(mockInventory).removeInventory(anyInt());

        sellAction.doAction(mockInventory);
        verify(mockInventory, times(1)).removeInventory(anyInt());;
    }

    @Test
    public void testGetResult() {
        SellInventoryAction sellAction = new SellInventoryAction(10);

        assertEquals(null, sellAction.getResult());
    }
}
