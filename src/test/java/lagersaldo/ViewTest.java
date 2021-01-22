package lagersaldo;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    private RetrieveInventoryAction givenPerformedRetrieveAction() {
        RetrieveInventoryAction retrieveAction = new RetrieveInventoryAction();
        Inventory mockInventory = mock(Inventory.class);
        when(mockInventory.getInventory()).thenReturn(10);
        retrieveAction.doAction(mockInventory);
        return retrieveAction;
    }

    private void assertRetrieveActionWasPrinted() {
        String actual = outContent.toString();
        outContent.reset();
        System.out.println("Current inventory: " + 10);
        String expected = outContent.toString();

        assertEquals(expected, actual);
    }

    private DeliverInventoryAction givenPerformedDeliverAction() {
        DeliverInventoryAction deliverAction = new DeliverInventoryAction(10);
        Inventory mockInventory = mock(Inventory.class);
        doAnswer(invocation -> {
            return null;
        }).when(mockInventory).removeItems(anyInt());

        deliverAction.doAction(mockInventory);
        return deliverAction;
    }

    private SellInventoryAction givenPerformedSellAction() {
        SellInventoryAction sellAction = new SellInventoryAction(10);
        Inventory mockInventory = mock(Inventory.class);
        doAnswer(invocation -> {
            return null;
        }).when(mockInventory).removeItems(anyInt());

        sellAction.doAction(mockInventory);
        return sellAction;
    }

    private void assertDoneWasPrinted() {
        String actual = outContent.toString();
        outContent.reset();
        System.out.println("done");
        String expected = outContent.toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testPrintRetrieveResult() {
        RetrieveInventoryAction performedRetrieveAction = givenPerformedRetrieveAction();

        View.printResult(performedRetrieveAction);

        assertRetrieveActionWasPrinted();
    }

    @Test
    public void testPrintDeliverResult() {
        DeliverInventoryAction deliverAction = givenPerformedDeliverAction();

        View.printResult(deliverAction);

        assertDoneWasPrinted();
    }

    @Test
    public void testPrintSellResult() {
        SellInventoryAction sellAction = givenPerformedSellAction();

        View.printResult(sellAction);
        
        assertDoneWasPrinted();
    }
}
