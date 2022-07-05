import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardGame {
    private List<Card> deckOfCards = new ArrayList<>(52);
    private String name;

    //    private List<String> suits = Arrays.asList("U+2660", "U+2665", "U+2666", "U+2663");
    private final List<String> suits = Arrays.asList("Spades", "Hearts", "Diamonds", "Clubs");

    public CardGame(String name) {
        this.name = name;

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

    public List getDeck() {
        return deckOfCards;
    }

    public boolean checkDeckSize() {
        return deckOfCards.size() == 52;
    }

    public String dealCard() {
        return deckOfCards.get(0).toString();
    }

    public void sortDeckInNumberOrder() {
        Collections.sort(deckOfCards);
    }

    public void sortDeckIntoSuits() {
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

    public void shuffleCards () {
        for (int i = 0; i < deckOfCards.size(); i++) {
            int randomIndex = (int) (Math.random()*deckOfCards.size());
            Card temp = deckOfCards.get(randomIndex);
            deckOfCards.set(randomIndex,deckOfCards.get(i));
            deckOfCards.set(i, temp);
        }
    }
}
