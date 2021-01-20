package src.main.java.lagersaldo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static boolean validInput(String input) {
        Pattern validPattern = Pattern.compile("^([SI]{1}\\d{1,6})$|^L$");
        Matcher matcher = validPattern.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static InventoryAction parseInput(String input) throws IllegalArgumentException {
        if (!validInput(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        if (input.equals("L")) {
            return new InventoryAction(input);
        }

        StringBuilder sb = new StringBuilder(input);
        String actionString = sb.substring(0, 1);
        String quantityString = sb.substring(1);
        int quantity = Integer.parseInt(quantityString);

        return new InventoryAction(actionString, quantity);
    }

}
