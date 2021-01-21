package lagersaldo;

public class View {

    public static void printResult(IInventoryAction action) {
        if (action.getActionType() == ActionType.Retrieve) {
            System.out.println("Current inventory: " + action.getResult());
        } else {
            System.out.println("done");
        }
    }
}
