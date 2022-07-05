import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardGame {
    private List<Card> deckOfCards = new ArrayList<>(52);
    private String name;

    public CardGame (String name) {
        this.name = name;

//        List<String> suits = Arrays.asList("U+2660", "U+2665", "U+2666", "U+2663");
        List<String> suits = Arrays.asList("Spades", "Hearts", "Diamonds", "Clubs");

        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                switch(i) {
                    case 11 :
                        deckOfCards.add(new Card(suit, "Jack", i));
                        break;
                    case 12 :
                        deckOfCards.add(new Card(suit, "Queen", i));
                        break;
                    case 13 :
                        deckOfCards.add(new Card(suit, "King", i));
                        break;
                    case 14 :
                        deckOfCards.add(new Card(suit, "Ace", i));
                        break;
                    default :
                        deckOfCards.add(new Card(suit, String.format("%s",i), i));
                        break;
                }
            }
        }
    }

    public List getDeck () {
        return deckOfCards;
    }

    public boolean checkDeckSize() {
        return deckOfCards.size() == 52;
    }
}
