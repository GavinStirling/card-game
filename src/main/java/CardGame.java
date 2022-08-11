import java.util.*;
import java.util.stream.Collectors;

public class CardGame {
    private static List<Card> deckOfCards = new ArrayList<>(52);
    private static final String name = "Normal Cards";

    private static final List<String> suits = Arrays.asList("\u2660", "\u2665", "\u2666", "\u2663");

    static {
        setDeck();
    }

    public static void setDeck () {
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                switch (i) {
                    case 11:
                        deckOfCards.add(new Card(suit, "Jack", i));
                        break;
                    case 12:
                        deckOfCards.add(new Card(suit, "Queen", i));
                        break;
                    case 13:
                        deckOfCards.add(new Card(suit, "King", i));
                        break;
                    case 14:
                        deckOfCards.add(new Card(suit, "Ace", i));
                        break;
                    default:
                        deckOfCards.add(new Card(suit, String.format("%s", i), i));
                        break;
                }
            }
        }
    }

    public static String getDeck() {
        return String.format("Name of Card Game: %s \nDeck: %s", name, deckOfCards);
    }

    public static void resetDeck () {
        deckOfCards.clear();
        setDeck();
    }

    public static List getDeckOfCards () {
        return deckOfCards;
    }

    public static boolean checkDeckSize() {
        return deckOfCards.size() == 52;
    }

    public static boolean checkDeckSize (int size) {
        return deckOfCards.size() == size;
    }

    public static Card drawCard (int index) {
        return deckOfCards.get(0);
    }

    public static Card drawCard () {
        return drawCard(0);
    }

    public static void removeCard (int index) {
        deckOfCards.remove(index);
    }

    public static void removeCard () {
        removeCard(0);
    }

    public static String dealCard() {
        String dealtCard = drawCard().shortToString();
        removeCard();
        return dealtCard;
    }

    public static void sortDeckInNumberOrder() {
        Collections.sort(deckOfCards);
    }

    // This is an overloaded method so that there is an option to sort without changing the current array. Uses stream.
    public static List sortDeckInNumberOrder(List<Card> deck) {
        return deckOfCards.stream().sorted().collect(Collectors.toList());
    }

    public static void sortDeckIntoSuits() {
        List<Card> spades = new ArrayList<>();
        List<Card> hearts = new ArrayList<>();
        List<Card> diamonds = new ArrayList<>();
        List<Card> clubs = new ArrayList<>();

        for (int i = 0; i < deckOfCards.size(); i++) {
            if ("Spades".equals(deckOfCards.get(i).getSuit())) {
                spades.add(deckOfCards.get(i));
            } else if ("Hearts".equals(deckOfCards.get(i).getSuit())) {
                hearts.add(deckOfCards.get(i));
            } else if ("Diamonds".equals(deckOfCards.get(i).getSuit())) {
                diamonds.add(deckOfCards.get(i));
            } else if ("Clubs".equals(deckOfCards.get(i).getSuit())) {
                clubs.add(deckOfCards.get(i));
            }
        }

        Collections.sort(spades);
        Collections.sort(hearts);
        Collections.sort(diamonds);
        Collections.sort(clubs);

        deckOfCards.clear();
        deckOfCards.addAll(spades);
        deckOfCards.addAll(hearts);
        deckOfCards.addAll(diamonds);
        deckOfCards.addAll(clubs);
    }

    // This is an overloaded method so that there is an option to sort without changing the current array. Uses stream.
    public static List sortDeckIntoSuits(List<Card> deck) {
        return deckOfCards.stream().sorted().sorted(Comparator.comparing(Card::getSuit)).collect(Collectors.toList());
    }

    public static void shuffleCards () {
        for (int i = 0; i < deckOfCards.size(); i++) {
            int randomIndex = (int) (Math.random()*deckOfCards.size());
            Card temp = deckOfCards.get(randomIndex);
            deckOfCards.set(randomIndex,deckOfCards.get(i));
            deckOfCards.set(i, temp);
        }
    }

    public static void shuffleCards (List<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = (int) (Math.random()*deck.size());
            Card temp = deck.get(randomIndex);
            deck.set(randomIndex,deck.get(i));
            deck.set(i, temp);
        }
    }
}
