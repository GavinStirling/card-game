public class Main {
    public static void main(String[] args) {
        CardGame deck = new CardGame("Standard Deck of Cards");

        Commands home = new Commands("Home", new String[]{"Show cards", "Deal card", "Sort by rank", "Sort by suit", "Quit"}, "home");
        home.printGreeting();
        home.printCommands();

        int userInput = home.getIntegerInput();

        boolean isActive = true;

        while (isActive) {
            switch(userInput) {
                case 1:
                    System.out.println(deck.getDeck());
                    home.setNextCommands("home");
                    break;
                case 2:
                    System.out.println(deck.dealCard());
                    home.setNextCommands("home");
                    break;
                case 3:
                    deck.sortDeckInNumberOrder();
                    System.out.println(deck.getDeck());
                    home.setNextCommands("home");
                    break;
                case 4:
                    deck.sortDeckIntoSuits();
                    System.out.println(deck.getDeck());
                    home.setNextCommands("home");
                    break;
                case 5:
                    System.out.println("Thanks for playing!");
                    isActive = false;
            }
        }
    }
}
