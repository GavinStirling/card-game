import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snap extends CardGame{
    private static List snapDeck = getDeckOfCards();

    private static Card previousCard;
    private static Card currentCard;
    private static Boolean isSnap = false;

    //    private List<String> suits = Arrays.asList("U+2660", "U+2665", "U+2666", "U+2663");
    private static final List<String> suits = Arrays.asList("Spades", "Hearts", "Diamonds", "Clubs");

    static {
        shuffleCards(snapDeck);
    }

    public static void setPreviousCard (Card card) {
        previousCard = card;
    }

    public static void setCurrentCard (Card card) {
        currentCard = card;
    }

    public static Card getPreviousCard () {
        return previousCard;
    }

    public static Card getCurrentCard () {
        return currentCard;
    }

    public static boolean getIsSnap () {
        return isSnap;
    }

    public static int getDeckSize() {
        return snapDeck.size();
    }

    public static void resetDeck () {
        snapDeck = getDeckOfCards();
        isSnap = false;
    }

    public static Card getTopCard () {
        return drawCard();
    }

    public static void removeCard () {
        snapDeck.remove(0);
    }

    public static Card drawSnapCard () {
        Card temp = getTopCard();
        removeCard();
        return temp;
    }

    public static void checkForSnap () {
        if (currentCard.getCardValue() ==previousCard.getCardValue()) {
            isSnap = true;
        }
    }

}
