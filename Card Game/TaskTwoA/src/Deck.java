import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public enum Suit
    {
        HEARTS, SPADES, CLUBS, DIAMONDS
    }

    public enum Rank
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.size() == 0) {
            return null;
        }
        return cards.remove(0);
    }

    public int cardsLeft() {
        return cards.size();
    }

    // Define the Card class locally inside the Deck class
    private class Card {
        private Suit suit;
        private Rank rank;

        public Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public Suit getSuit() {
            return suit;
        }

        public Rank getRank() {
            return rank;
        }

        public String toString() {
            return rank + " of " + suit;
        }
    }
}
