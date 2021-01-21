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
    public void testParseSellActionType(String input) {
        IInventoryAction action = InputParser.parseInput(input);
        assertEquals(ActionType.Sell, action.getActionType());
    }

    @ParameterizedTest(name = "Should return DeliverInventoryAction when parsing valid Deliver command \"{0}\"")
    @ValueSource(strings = { "I1", "I100000" })
    public void testParseDeliverActionType(String input) {
        IInventoryAction action = InputParser.parseInput(input);
        assertEquals(ActionType.Deliver, action.getActionType());
    }

    @Test
    public void testParseRetriveInventoryActionType() {
        IInventoryAction action = InputParser.parseInput("L");
        assertEquals(ActionType.Retrieve, action.getActionType());
    }

    @ParameterizedTest(name = "Should throw exception when parsing invalid input \"{0}\"")
    @EmptySource
    @ValueSource(strings = { "S-1", "I-1", "I", "S", "L200", "Q" })
    public void testParseBadInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInput(input);
        });
    }

}
