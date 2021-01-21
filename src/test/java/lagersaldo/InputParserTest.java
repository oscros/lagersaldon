package lagersaldo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
 

public class InputParserTest {

    @ParameterizedTest(name = "Should return SellInventoryAction when parsing valid Sell command \"{0}\"")
    @ValueSource(strings = { "S1", "S100000"})
    public void testParseSellCommand(String input) {
        IInventoryAction action = InputParser.parseInput(input);
        assertEquals(SellInventoryAction.class, action.getClass());
    }

    @ParameterizedTest(name = "Should return DeliverInventoryAction when parsing valid Deliver command \"{0}\"")
    @ValueSource(strings = { "I1", "I100000" })
    public void testParseDeliverCommand(String input) {
        IInventoryAction action = InputParser.parseInput(input);
        assertEquals(DeliverInventoryAction.class, action.getClass());
    }

    @Test
    public void testParseRetriveInventoryCommand() {
        IInventoryAction action = InputParser.parseInput("L");
        assertEquals(RetrieveInventoryAction.class, action.getClass());
    }

    @ParameterizedTest(name = "Should throw exception when parsing invalid input \"{0}\"")
    @EmptySource
    @ValueSource(strings = { "S-1", "I-1", "I", "S", "L200" })
    public void testParseBadInput(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IInventoryAction action = InputParser.parseInput(input);
        });
    }

}
