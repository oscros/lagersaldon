package lagersaldo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static boolean isValidInput(String input) {
        String validActionTypePattern = "^([SI]{1}\\d{1,6})$|^L$";
        Pattern validPattern = Pattern.compile(validActionTypePattern);
        Matcher matcher = validPattern.matcher(input);
        boolean foundValidPattern = matcher.find();
        return foundValidPattern;
    }

    private static ActionType parseActionTypeString(String input) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder(input);
        String actionString = sb.substring(0, 1);
        switch (actionString) {
            case "S":
                return ActionType.Sell;
            case "L":
                return ActionType.Retrieve;
            case "I":
                return ActionType.Deliver;
            default:
                throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    private static int parseQuantityString(String input) {
        StringBuilder sb = new StringBuilder(input);
        String quantityString = sb.substring(1);
        int quantity = Integer.parseInt(quantityString);
        return quantity;
    }

    public static IInventoryAction parseInput(String input) throws IllegalArgumentException {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        ActionType actionType = parseActionTypeString(input);
        int quantity;
        switch (actionType) { 
            case Sell:
                quantity = parseQuantityString(input);
                return new SellInventoryAction(quantity);
            case Deliver:
                quantity = parseQuantityString(input);
                return new DeliverInventoryAction(quantity);
            case Retrieve:
                return new RetrieveInventoryAction();
            default:
                throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

}
