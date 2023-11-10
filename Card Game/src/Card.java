public class Card implements Comparable<Card>{
    String suit;
    int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Implement the compareTo method to compare cards based on their suits and ranks

    public int compareTo(Card otherCard) {
        int suitComparison = this.suit.compareTo(otherCard.suit);
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return Integer.compare(otherCard.rank, this.rank); // compare ranks in reverse order
        }
    }

    // Override the toString method to print the card's rank and suit
    @Override
    public String toString() {
        if (rank == 14){
            String rankString = "Ace";
            return rankString + " of " + suit;
        } else if (rank == 13) {
            String rankString = "King";
            return rankString + " of " + suit;
        }else if (rank == 12) {
            String rankString = "Queen";
            return rankString + " of " + suit;
        }else if (rank == 11) {
            String rankString = "Jack";
            return rankString + " of " + suit;
        }

        return rank + " of " + suit;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }
}
