public class Main {
    public static void main(String[] args) {
        StartCommands startCommands = new StartCommands();
        startCommands.run();
        Commands currentCommands = startCommands;

        boolean isActive = true;

        while (isActive) {
            switch(currentCommands.getNextCommands()) {
                case "home" :
                    currentCommands = new HomeCommands();
                    currentCommands.run();
                    break;
                case "playCards" :
                    currentCommands = new PlayCardsCommands();
                    currentCommands.run();
                    break;
                case "playSnap" :
                    currentCommands = new SnapCommands();
                    currentCommands.run();
                    break;
                case "twoPlayerSnap" :
                    currentCommands = new TwoPlayerSnapCommands();
                    currentCommands.run();
                    break;
                default :
                    isActive = false;
                    break;
           }
        }
    }
}
