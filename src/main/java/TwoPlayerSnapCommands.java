public class TwoPlayerSnapCommands extends Commands{
    public TwoPlayerSnapCommands(String name, String[] commands, String nextCommand) {
        super("Two Player Snap", new String[]{}, "twoPlayerSnap");
    }

    @Override
    public void run() {
        printMessage("Welcome to two player snap.");
        printMessage("Welcome to snap. If a player draws a card which is a snap, they have two seconds to type in snap to win otherwise they miss.");

        int count = 1;
        boolean winner = false;

        printMessage("Press enter to draw the first card!");
        getEnterInput();
        Snap.setPreviousCard(Snap.drawSnapCard());
        printMessage("You drew the " + Snap.getPreviousCard().shortToString());

        while (!winner) {
            if (count %2 != 0) {
                printMessage("Player 1 to draw a card:");
                getEnterInput();
            }
        }
    }
}
