public class Main {
    public static void main(String[] args) {
        CardGame deck = new CardGame("Standard Deck of Cards");
        deck.sortDeckInNumberOrder();
        deck.sortDeckIntoSuits();
        deck.shuffleCards();
        System.out.println(deck.getDeck());
        System.out.println(deck.checkDeckSize());
    }
}
