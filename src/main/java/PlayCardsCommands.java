public class PlayCardsCommands extends Commands{
    public PlayCardsCommands() {
        super("Play with the Cards", new String[]{"Show cards", "Shuffle cards", "Deal card", "Sort by rank", "Sort by suit", "Back"}, "playCards");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        switch(userInput) {
            case 1:
                System.out.println(CardGame.getDeck());
                break;
            case 2:
                CardGame.shuffleCards();
                printMessage("Deck has been shuffled!");
                break;
            case 3:
                System.out.println(CardGame.dealCard());
                break;
            case 4:
                CardGame.sortDeckInNumberOrder();
                printMessage("Deck has been sorted by rank!");
                break;
            case 5:
                CardGame.sortDeckIntoSuits();
                printMessage("Deck has been sorted by suit!");
                break;
            case 6:
                System.out.println("Thanks for playing!");
                setNextCommands("home");
                break;
        }

    }
}
