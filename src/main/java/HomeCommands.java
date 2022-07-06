public class HomeCommands extends Commands{

    public HomeCommands() {
        super("Home", new String[]{"Play with cards", "Play Snap", "Quit"}, "home");
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
            default :
                setNextCommands("");
                break;
        }

    }
}
