public class HomeCommands extends Commands{

    public HomeCommands() {
        super("Home", new String[]{"Play with cards", "Play Snap", "Two Player Snap", "Quit"}, "home");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        switch (userInput) {
            case 1 :
                setNextCommands("playCards");
                break;
            case 2 :
                setNextCommands("playSnap");
                break;
            case 3 :
                setNextCommands("twoPlayerSnap");
                break;
            default :
                setNextCommands("");
                break;
        }

    }
}
