public class StartCommands extends Commands{
    public StartCommands() {
        super("Welcome", new String[]{}, "welcome");
    }

    @Override
    public void run() {
        printMessage("Welcome to Gavin's Card Game!");
        setNextCommands("home");
    }
}
