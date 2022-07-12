public class SnapCommands extends Commands{
    public SnapCommands() {
        super("Welcome to snap", new String[]{}, "playSnap");
    }

    @Override
    public void run() {
        printMessage("Welcome to snap. Once you draw two cards of the same value, a winner is chosen");
        printMessage("Press enter to draw the first card!");
        getEnterInput();
        Snap.setPreviousCard(Snap.drawSnapCard());
        printMessage("You drew the " + Snap.getPreviousCard().shortToString());

        while (!Snap.getIsSnap()) {

            if (Snap.checkDeckSize(0)) {
                printMessage("All cards are gone, please try again!");
                break;
            } else {
                printMessage("Press enter to draw the next card!");

                getEnterInput();
                Snap.setCurrentCard(Snap.drawSnapCard());
                printMessage("You drew the " + Snap.getCurrentCard().shortToString());

                Snap.checkForSnap();

                if (Snap.getIsSnap()) {
                    printMessage("Snap! Game Over...");
                    break;
                }
                Snap.setPreviousCard(Snap.getCurrentCard());
                printMessage("Cards remaining: " + Snap.getDeckSize());
            }
        }
        setCommandsArray(new String[]{"Play Again?", "Back to Home"});
        printCommands();
        int userInput = getIntegerInput();

        switch (userInput) {
            case 1 :
                Snap.resetDeck();
                Snap.setPreviousCard(null);
                Snap.setCurrentCard(null);
                run();
                break;
            case 2:
                Snap.resetDeck();
                Snap.setPreviousCard(null);
                Snap.setCurrentCard(null);
                setNextCommands("home");
                break;
        }

    }
}
