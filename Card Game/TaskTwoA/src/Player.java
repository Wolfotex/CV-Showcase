//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player
{
    private String name; // stores the name of the player
    private ArrayList<Card> hand; // stores the player's hand as a list of 'Card' objects

    public Player(String name) // constructor for the 'Player' class
    {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public Player()
    {
        this.hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card)
    {
        hand.add(card);
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    /*
    * takes a 'name' parameter and initialize the 'name' instance variable to the value of the parameter.
    * initialize the 'hand' instance variable as a new empty 'ArrayList'
     */

    // getter method for he 'name' instance variable
    public String getName()
    {
        return this.name;
    }
    //method takes a 'Card' object as a parameter and adds it to the player's hand
    public void addACard(Card card)
    {
        this.hand.add(card);
    }

    // method takes a 'suit' parameter and removes and returns a card of that suit from the player's hand
    // if there is no card of that suit in the hand, an arbitrary card is removed and returned
    public Card playACard(String suit)
    {
        Iterator<Card> iterator = this.hand.iterator();
        while (iterator.hasNext())
        {
            Card card = iterator.next();
            if (card.getSuit().equals(suit))
            {
                iterator.remove();
                return card;
            }
        }
        // if no cards of suits, remove and return an arbitrary card
        return this.hand.remove(0);
    }
    // returns an iterator for all cards currently in the player's hand.
    public Iterator<Card> iterator()
    {
        return this.hand.iterator();
    }

    // take a 'suit' parameter and returns an iterator for all cards of that suit that are currently in the player's hand
    public Iterator<Card> suitIterator(String suit)
    {
        List<Card> suitCards = new ArrayList<>();
        for (Card card : this.hand)
        {
            if (card.getSuit().equals(suit))
            {
                suitCards.add(card);
            }
        }
        return suitCards.iterator();
    }

    // overrides the default 'toString' method for the 'Player' class.
    // returns a string representation of the player's name and hand.
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(": ");
        for (Card card : this.hand)
        {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // removes trailing ", "
        return sb.toString();
    }
}
