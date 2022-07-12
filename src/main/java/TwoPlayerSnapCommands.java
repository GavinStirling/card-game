public class TwoPlayerSnapCommands extends Commands{
    public TwoPlayerSnapCommands() {
        super("Two Player Snap", new String[]{}, "twoPlayerSnap");
    }

    @Override
    public void run() {
        printMessage("Welcome to two player snap.");
        printMessage("Welcome to snap. If a player draws a card which is a snap, \nthey have two seconds to type in snap to win otherwise they miss.");

        int count = 1;
        boolean winner = false;

        printMessage("Press enter to start!");
        getEnterInput();

        while (!winner) {
            if (Snap.checkDeckSize(0)) {
                printMessage("All cards are gone, please try again!");
                break;
            } else {
                if (count %2 != 0) {
                    printMessage("Player 1 to draw a card:");
                    getEnterInput();
                    Snap.setCurrentCard(Snap.drawSnapCard());
                    printMessage("You drew the " + Snap.getCurrentCard().shortToString());

                    if (count != 1) {
                        Snap.checkForSnap();
                    }

                    if (Snap.getIsSnap()) {
                        printMessage("Snap! Player 1 wins!");
                        winner = true;
                        break;
                    }

                    Snap.setPreviousCard(Snap.getCurrentCard());
                    printMessage("Cards remaining: " + Snap.getDeckSize());
                    count +=1;
                } else {
                    printMessage("Player 2 to draw a card:");
                    getEnterInput();
                    Snap.setCurrentCard(Snap.drawSnapCard());
                    printMessage("You drew the " + Snap.getCurrentCard().shortToString());

                    Snap.checkForSnap();

                    if (Snap.getIsSnap()) {
                        printMessage("Snap! Player 2 wins!");
                        winner = true;
                        break;
                    }

                    Snap.setPreviousCard(Snap.getCurrentCard());
                    printMessage("Cards remaining: " + Snap.getDeckSize());
                    count +=1;
                }
            }
        }

        setCommandsArray(new String[]{"Play Again?", "Back to Home"});
        printCommands();
        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                Snap.reset();
                run();
                break;
            case 2:
                Snap.reset();
                setNextCommands("home");
                break;
        }
    }
}
