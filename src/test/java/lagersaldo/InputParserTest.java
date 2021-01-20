package src.test.java.lagersaldo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import src.main.java.lagersaldo.InputParser;
import src.main.java.lagersaldo.InventoryAction;

public class InputParserTest {

    @ParameterizedTest(name = "Should return correct InventoryAction when parsing valid input \"{0}\"")
    @ValueSource(strings = { "S1", "I2", "S100000", "I20000" })
    public void testParseInput(String input) {
        StringBuilder sb = new StringBuilder(input);
        String actionString = sb.substring(0, 1);
        String quantityString = sb.substring(1);
        int quantity = Integer.parseInt(quantityString);

        InventoryAction action = InputParser.parseInput(input);
        assertEquals(actionString, action.getType());
        assertEquals(quantity, action.getQuantity());
    }

    @Test
    public void testParsePrintAction() {
        InventoryAction action = InputParser.parseInput("L");
        assertEquals("L", action.getType());
    }

    @ParameterizedTest(name = "Should throw exception when parsing invalid input \"{0}\"")
    @EmptySource
    @ValueSource(strings = { "S-1", "I-1", "I", "S", "L200" })
    public void testParseBadInput(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InventoryAction action = InputParser.parseInput(input);
        });
    }

}
