public class TwoPlayerSnapCommands extends Commands{
    public TwoPlayerSnapCommands() {
        super("Two Player Snap", new String[]{}, "twoPlayerSnap");
    }

    @Override
    public void run() {
        printMessage("Welcome to two player snap.");

        int playerTurnCounter = 1;
        boolean isWinner = false;

        printMessage("Press enter to start!");
        getEnterInput();

        while (!isWinner) {
            if (Snap.checkDeckSize(0)) {
                printMessage("All cards are gone, please try again!");
                break;
            } else {
                if (playerTurnCounter % 2 != 0) {
                    printMessage("Player 1 to draw a card:");
                    getEnterInput();
                    Snap.setCurrentCard(Snap.drawSnapCard());
                    printMessage("You drew the " + Snap.getCurrentCard().shortToString());

                    if (playerTurnCounter != 1) {
                        Snap.checkForSnap();
                    }

                    if (Snap.getIsSnap()) {
                        printMessage("Snap! Player 1 wins!");
                        isWinner = true;
                        break;
                    }

                    Snap.setPreviousCard(Snap.getCurrentCard());
                    printMessage("Cards remaining: " + Snap.getDeckSize());
                    playerTurnCounter +=1;
                } else {
                    printMessage("Player 2 to draw a card:");
                    getEnterInput();
                    Snap.setCurrentCard(Snap.drawSnapCard());
                    printMessage("You drew the " + Snap.getCurrentCard().shortToString());

                    Snap.checkForSnap();

                    if (Snap.getIsSnap()) {
                        printMessage("Snap! Player 2 wins!");
                        isWinner = true;
                        break;
                    }

                    Snap.setPreviousCard(Snap.getCurrentCard());
                    printMessage("Cards remaining: " + Snap.getDeckSize());
                    playerTurnCounter +=1;
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
