public class Card implements Comparable<Card>{
    private String suit;
    private String symbol;
    private int value;

    public Card (String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public int getCardValue () {
        return this.value;
    }

    public String getSuit () {
        return this.suit;
    }

    @Override
    public String toString () {
        return String.format("\nSuit: %s \nCard: %s \nValue: %s", suit, symbol, value);
    }

    public String shortToString () {
        return String.format("\n%s of %s", symbol, suit);
    }

    @Override
    public int compareTo(Card card) {
        return value - card.getCardValue();
    }
}
