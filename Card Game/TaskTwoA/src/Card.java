public class Card
{
    public enum Suit
    {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Rank
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
   //two private instance variable. marked final
   private final Rank rank;
   private final Suit suit;

    // a constructor for the class takes only 2 arguments.
    // When a new Card object is created, the constructor sets the rank and suit variables to the values passed in as arguments
   public Card(Rank rank, Suit suit)
   {
       this.rank = rank;
       this.suit = suit;
   }

   //the getter methods allow other classes to access the rank and suit of a card with modifying directly
   public Rank getRank()
   {
       return rank;
   }

    public Suit getSuit()
    {
        return suit;
    }

    @Override
    // converts the object to a string in order to print.
    public String toString()
    {
        return rank + "-" + suit;
    }
}
