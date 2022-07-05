public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card (String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString () {
        return String.format("\nSuit: %s \nCard: %s \nValue: %s", suit, symbol, value);
    }

}
