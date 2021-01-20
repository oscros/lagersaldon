package src.main.java.lagersaldo;

public class View {

    public static void printResult(IInventoryAction action) {
        if (action.getClass() == RetrieveInventoryAction.class) {
            System.out.println("Current inventory: " + action.getResult());
        } else {
            System.out.println("done");
        }
    }
}
