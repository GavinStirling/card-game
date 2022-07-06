public class TwoPlayerSnapCommands extends Commands{
    public TwoPlayerSnapCommands(String name, String[] commands, String nextCommand) {
        super("Two Player Snap", commands, nextCommand);
    }

    @Override
    public void run() {
        printMessage("Welcome to two player snap.");

    }
}
