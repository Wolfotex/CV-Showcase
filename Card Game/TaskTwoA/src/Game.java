import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private ArrayList<ArrayList<Card>> hands;
    private int numPlayers;

    public Game(int numPlayers) {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.hands = new ArrayList<ArrayList<Card>>();
        this.numPlayers = numPlayers;
        // Create Players and empty hands
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
            hands.add(new ArrayList<Card>());
        }
    }

    public void dealCards() {
        // deal cards to players
        Iterator<Player> playerIterator = players.iterator();
        while (deck.cardsLeft() > 0) {
            if (!playerIterator.hasNext()) {
                playerIterator = players.iterator();
            }
            Player player = playerIterator.next();
            Card card = deck.dealCard();
            player.addCardToHand(card);
            hands.get(players.indexOf(player)).add(card);
        }
        // Sort hands by suit and rank
        for (ArrayList<Card> hand : hands) {
            Collections.sort(hand, new CardComparator());
        }
    }

    public void displayHands() {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i+1) + " hand: " + hands.get(i));
        }
    }

    public void playGame() {
        dealCards();
        displayHands();
        // Play game logic
    }

    public static void main(String[] args) {
        Game game = new Game(4);
        game.playGame();
    }
}
