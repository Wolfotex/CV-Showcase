import java.util.Random;
import java.util.Scanner;

public class Main {
    Random rand = new Random();
    static MyArrayList<Card> deck = new MyArrayList<Card>();
    static MyArrayList<Card> p1 = new MyArrayList<>();
    static MyArrayList<Card> p2 = new MyArrayList<>();
    static MyArrayList<Card> p3 = new MyArrayList<>();
    static MyArrayList<Card> p4 = new MyArrayList<>();
    static MyArrayList<Card> temp = new MyArrayList<>();


    private static String suitToPlay;
    private static int playerNumber;
    private Card newCard;

    public String capitalize(String str) {
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    public void start(){
        // Create the card deck
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new Card(suit, rank));
            }
        }

        int size = deck.size();
        for (int i = 0; i < size; i++) {
            int j = i + rand.nextInt(size - i);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    private void sortHand(MyArrayList<Card> hand) {
        int size = hand.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Card card1 = hand.get(i);
                Card card2 = hand.get(j);
                if (card1.getSuit().compareTo(card2.getSuit()) < 0) {
                    // Swap the cards if they are in the wrong order based on suit
                    hand.set(i, card2);
                    hand.set(j, card1);
                } else if (card1.getSuit().equals(card2.getSuit()) && card1.getRank() < card2.getRank()) {
                    // Swap the cards if they have the same suit but are in the wrong order based on rank
                    hand.set(i, card2);
                    hand.set(j, card1);
                }
            }
        }
    }

    private void addCard() {





        // adding a card to player 1's hand
        if (playerNumber == 1) {
            // when player is getting his first card
            if (p1.size() == 0) {
                // get the top card from the deck
                p1.add(deck.remove(0));

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p1.toString());
                System.out.println("\n");
            }

            // when player is adding card when he has 1 or more cards in his hand
            else {
                // get the top card from the deck
                p1.add(deck.remove(0));

                // sorting the hand after adding the card to the hand
                sortHand(p1);

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p1.toString());
                System.out.println("\n");
            }
        }
        // adding a card to player 2's hand
        else if (playerNumber == 2) {
            // when player is getting his first card
            if (p2.size() == 0) {
                // get the top card from the deck
                p2.add(deck.remove(0));

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p2.toString());
                System.out.println("\n");
            }

            // when player is adding card when he has 1 or more cards in his hand
            else {
                // get the top card from the deck
                p2.add(deck.remove(0));

                // sorting the hand after adding the card to the hand
                sortHand(p2);

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p2.toString());
                System.out.println("\n");
            }
        }
        // adding a card to player 3's hand
        else if (playerNumber == 3) {
            // when player is getting his first card
            if (p3.size() == 0) {
                // get the top card from the deck
                p3.add(deck.remove(0));

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p3.toString());
                System.out.println("\n");
            }

            // when player is adding card when he has 1 or more cards in his hand
            else {
                // get the top card from the deck
                p3.add(deck.remove(0));

                // sorting the hand after adding the card to the hand
                sortHand(p3);

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p3.toString());
                System.out.println("\n");
            }
        }
        // adding a card to player 4's hand
        else if (playerNumber == 4) {
            // when player is getting his first card
            if (p4.size() == 0) {
                // get the top card from the deck
                p4.add(deck.remove(0));

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p4.toString());
                System.out.println("\n");
            }

            // when player is adding card when he has 1 or more cards in his hand
            else {
                // get the top card from the deck
                p4.add(deck.remove(0));

                // sorting the hand after adding the card to the hand
                sortHand(p4);

                // display the player's hand
                System.out.print("\nYour hand: ");
                System.out.print(p4.toString());
                System.out.println("\n");
            }
        }
    }

    private String view() {
        if (playerNumber == 1){
            // return each card in the hand of player 1
            return "\nplayer 1: " + p1.toString() + "\n";

        }else if (playerNumber == 2){
            // return each card in the hand of player 2
            return "\nplayer 2: " + p2.toString() + "\n";

        } else if (playerNumber == 3) {
            // return each card in the hand player 3
            return "\nplayer 3: " + p3.toString() + "\n";

        } else if (playerNumber == 4) {
            // return each card in the hand of player 4
            return "\nplayer 4: " + p4.toString() + "\n";
        }
        return null;
    }

    private String playCard(){
        // play a card from player 1's hand
        String arbitrarySuit;
        if (playerNumber == 1){
            // get player hand's size
            int size = p1.size();

            // if player hand is empty
            if (p1.isEmpty()){
                return "\nHand is empty";
            }

            // checking whether player has a card of suit s
            for (int i = 0; i < size; i++){
                // if player has a card of suit s
                if (p1.get(i).suit.equals(suitToPlay)){
                    // return the highest valued card of suit s
                    return "\nYou played " + p1.remove(i).toString();
                }
            }

            // getting the suit of an arbitrary card
            int randomCardIndex = rand.nextInt(size);
            arbitrarySuit = p1.get(randomCardIndex).suit;

            // updating the suit in play
            suitToPlay = arbitrarySuit;

            // return the arbitrary card
            for (int i = 0; i < size; i++){
                if (p1.get(i).suit.equals(arbitrarySuit)){
                    return "\nYou played " + p1.remove(i).toString();
                }
            }
        }
        // play a card from player 2's hand
        else if (playerNumber == 2) {
            // get player hand's size
            int size = p2.size();

            // if player hand is empty
            if (p2.isEmpty()){
                return "\nHand is empty";
            }

            // checking whether player has a card of suit s
            for (int i = 0; i < size; i++){
                // if player has a card of suit s
                if (p2.get(i).suit.equals(suitToPlay)){
                    // return the highest valued card of suit s
                    return "\nYou played " + p2.remove(i).toString();
                }
            }

            // getting the suit of an arbitrary card
            int randomCardIndex = rand.nextInt(size);
            arbitrarySuit = p2.get(randomCardIndex).suit;

            // updating the suit in play
            suitToPlay = arbitrarySuit;

            // return the arbitrary card
            for (int i = 0; i < size; i++){
                if (p2.get(i).suit.equals(arbitrarySuit)){
                    return "\nYou played " + p2.remove(i).toString();
                }
            }
        }

        // play a card from player 3's hand
        else if (playerNumber == 3) {
            // get player hand's size
            int size = p3.size();

            // if player hand is empty
            if (p3.isEmpty()){
                return "\nHand is empty";
            }

            // checking whether player has a card of suit s
            for (int i = 0; i < size; i++){
                // if player has a card of suit s
                if (p3.get(i).suit.equals(suitToPlay)){
                    // return the highest valued card of suit s
                    return "\nYou played " + p3.remove(i).toString();
                }
            }

            // getting the suit of an arbitrary card
            int randomCardIndex = rand.nextInt(size - 1);
            arbitrarySuit = p3.get(randomCardIndex).suit;
            // updating the suit in play
            suitToPlay = arbitrarySuit;

            // return the arbitrary card
            for (int i = 0; i < size; i++){
                if (p3.get(i).suit.equals(arbitrarySuit)){
                    return "\nYou played " + p3.remove(i).toString();
                }
            }
        }

        // play a card from player 4's hand
        else if (playerNumber == 4) {
            // get player hand's size
            int size = p4.size();

            // if player hand is empty
            if (p4.isEmpty()){
                return "\nHand is empty";
            }

            // checking whether player has a card of suit s
            for (int i = 0; i < size; i++){
                // if player has a card of suit s
                if (p4.get(i).suit.equals(suitToPlay)){
                    // return the highest valued card of suit s
                    return "\nYou played " + p4.remove(i).toString();
                }
            }

            // getting the suit of an arbitrary card
            int randomCardIndex = rand.nextInt(size - 1);
            arbitrarySuit = p4.get(randomCardIndex).suit;

            // updating the suit in play
            suitToPlay = arbitrarySuit;

            // return the arbitrary card
            for (int i = 0; i < size; i++){
                if (p4.get(i).suit.equals(arbitrarySuit)){
                    return "\nYou played " + p4.remove(i).toString();
                }
            }
        }
        return null;
    }

    private void viewCardsOfSuit(){
        // checking for cards of suit s in player 1 hand
        if (playerNumber == 1){
            // add cards of suit s to temp array list
            for (int i = 0; i < p1.size(); i++){
                if (p1.get(i).suit.equals(suitToPlay)){
                    temp.add(p1.get(i));
                }
            }

            // if player doesn't have cards of suit s
            if (temp.isEmpty()){
                System.out.println("\nPlayer 1 doesn't have cards of suit " + suitToPlay);;
            }

            // display the cards of suit s
            System.out.println();
            System.out.println("Player 1(" + suitToPlay + "): " + temp.toString());
            System.out.println();

            // clear the temp arraylist
            temp.clear();
        }

        // checking for cards of suit s in player 2 hand
        else if (playerNumber == 2) {
            // add cards of suit s to temp array list
            for (int i = 0; i < p2.size(); i++){
                if (p2.get(i).suit.equals(suitToPlay)){
                    temp.add(p2.get(i));
                }
            }

            // if player doesn't have cards of suit s
            if (temp.isEmpty()){
                System.out.println("\nPlayer 2 doesn't have cards of suit " + suitToPlay);
            }

            // display the cards of suit s
            System.out.println();
            System.out.println("Player 2(" + suitToPlay + "): " + temp.toString());
            System.out.println();

            // clear the temp arraylist
            temp.clear();
        }

        // checking for cards of suit s in player 3 hand
        else if (playerNumber == 3) {
            // add cards of suit s to temp array list
            for (int i = 0; i < p3.size(); i++){
                if (p3.get(i).suit.equals(suitToPlay)){
                    temp.add(p3.get(i));
                }
            }

            // if player doesn't have cards of suit s
            if (temp.isEmpty()){
                System.out.println("\nPlayer 3 doesn't have cards of suit " + suitToPlay);
            }

            // display the cards of suit s
            System.out.println();
            System.out.println("Player 3(" + suitToPlay + "): " + temp.toString());
            System.out.println();

            // clear the temp arraylist
            temp.clear();
        }

        // checking for cards of suit s in player 4 hand
        else if (playerNumber == 4) {
            // add cards of suit s to temp array list
            for (int i = 0; i < p4.size(); i++){
                if (p4.get(i).suit.equals(suitToPlay)){
                    temp.add(p4.get(i));
                }
            }

            // if player doesn't have cards of suit s
            if (temp.isEmpty()){
                System.out.println("\nPlayer 4 doesn't have cards of suit " + suitToPlay);
            }

            // display the cards of suit s
            System.out.println();
            System.out.println("Player 4(" + suitToPlay + "): " + temp.toString());
            System.out.println();

            // clear the temp arraylist
            temp.clear();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner input = new Scanner(System.in);
        String option;

        while (true){
            //Display instructions to the user
            System.out.println("Type 's' to start or continue the game." +
                    "Type 'e' to exit.");
            System.out.print("Type here: ");
            // Get input from user
            option = input.nextLine();

            // Starts the game
            if (option.equals("s")){
                // choose a suit s
                while (true){
                    System.out.println("\nSelect a suit to begin. (Hearts, Diamonds, Clubs, Spades)");
                    System.out.print("Type here: ");
                    // Get input from user
                    suitToPlay = input.nextLine();
                    suitToPlay = main.capitalize(suitToPlay);
                    if (suitToPlay.equals("Hearts") || suitToPlay.equals("Diamonds") || suitToPlay.equals("Clubs") || suitToPlay.equals("Spades")){
                        break;
                    }
                    System.out.println("Incorrect suit choice");
                }

                // create the deck and shuffle the cards
                main.start();

                while (true){
                    // checking whether the deck is empty
                    if (deck.isEmpty()){
                        System.out.println("Game over. Deck is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + p1.toString());
                        System.out.println("Player 2: " + p2.toString());
                        System.out.println("Player 3: " + p3.toString());
                        System.out.println("Player 4: " + p4.toString());
                        p1.clear();
                        p2.clear();
                        p3.clear();
                        p4.clear();
                        deck.clear();
                        break;
                    }


                    // player 1's turn
                    playerNumber = 1;
                    System.out.println("\nSuit in play: " + suitToPlay);
                    System.out.println("Player 1:");
                    player1:
                    while (true){
                        System.out.print("""
                           a - Add card
                           p - Play card
                           v - view hand
                           vs - view cards of a suit s.
                           e - end turn
                           """);
                        System.out.print("Type here: ");
                        option = input.nextLine();
                        switch (option) {
                            // add a card to player  hand
                            case "a":
                                main.addCard();
                                System.out.println("\nNext player..");
                                break player1;

                            // play a card
                            case "p":
                                System.out.println(main.playCard());
                                System.out.println("\nNext player..");
                                break player1;

                            // view player hand
                            case "v":
                                System.out.println(main.view());
                                break;

                            // View cards of suit s in hand
                            case "vs":
                                main.viewCardsOfSuit();
                                break;

                            // end player turn
                            case "e":
                                System.out.println("\nNext player..");
                                break player1;

                            default:
                                System.out.println("\nNot an option.\n");
                        }
                    }

                    // checking whether the deck is empty
                    if (deck.isEmpty()){
                        System.out.println("Game over. Deck is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + p1.toString());
                        System.out.println("Player 2: " + p2.toString());
                        System.out.println("Player 3: " + p3.toString());
                        System.out.println("Player 4: " + p4.toString());
                        p1.clear();
                        p2.clear();
                        p3.clear();
                        p4.clear();
                        deck.clear();
                        break;
                    }

                    //player 2
                    playerNumber = 2;
                    System.out.println("\nSuit in play: " + suitToPlay);
                    System.out.println("Player 2:");
                    player2:
                    while (true){
                        System.out.print("""
                           a - Add card
                           p - Play card
                           v - view hand
                           vs - view cards of a suit s.
                           e - end turn
                           """);
                        System.out.print("Type here: ");
                        option = input.nextLine();

                        switch (option) {
                            // add a card to player  hand
                            case "a":
                                main.addCard();
                                System.out.println("\nNext player..");
                                break player2;

                            // play a card
                            case "p":
                                System.out.println("player 2 played " + main.playCard());
                                System.out.println("\nNext player..");
                                break player2;

                            // view player hand
                            case "v":
                                System.out.println(main.view());
                                break;

                            // View cards of suit s in hand
                            case "vs":
                                main.viewCardsOfSuit();
                                break;

                            // end player turn
                            case "e":
                                System.out.println("\nNext player..");
                                break player2;

                            default:
                                System.out.println("\nNot an option.\n");
                        }
                    }

                    // checking whether the deck is empty
                    if (deck.isEmpty()){
                        System.out.println("Game over. Deck is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + p1.toString());
                        System.out.println("Player 2: " + p2.toString());
                        System.out.println("Player 3: " + p3.toString());
                        System.out.println("Player 4: " + p4.toString());
                        p1.clear();
                        p2.clear();
                        p3.clear();
                        p4.clear();
                        deck.clear();
                        break;
                    }

                    //player3
                    playerNumber = 3;
                    System.out.println("\nSuit in play: " + suitToPlay);
                    System.out.println("Player: 3");
                    player3:
                    while (true){
                        System.out.print("""
                           a - Add card
                           p - Play card
                           v - view hand
                           vs - view cards of a suit s.
                           e - end turn
                           """);
                        System.out.print("Type here: ");
                        option = input.nextLine();
                        switch (option) {
                            // add a card to player  hand
                            case "a":
                                main.addCard();
                                System.out.println("\nNext player..");
                                break player3;

                            // play a card
                            case "p":
                                System.out.println("player 2 played " + main.playCard());
                                System.out.println("\nNext player..");
                                break player3;

                            // view player hand
                            case "v":
                                System.out.println(main.view());
                                break;

                            // View cards of suit s in hand
                            case "vs":
                                main.viewCardsOfSuit();
                                break;

                            // end player turn
                            case "e":
                                System.out.println("\nNext player..");
                                break player3;

                            default:
                                System.out.println("\nNot an option.\n");
                        }
                    }

                    // checking whether the deck is empty
                    if (deck.isEmpty()){
                        System.out.println("Game over. Deck is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + p1.toString());
                        System.out.println("Player 2: " + p2.toString());
                        System.out.println("Player 3: " + p3.toString());
                        System.out.println("Player 4: " + p4.toString());
                        p1.clear();
                        p2.clear();
                        p3.clear();
                        p4.clear();
                        deck.clear();
                        break;
                    }

                    //player 4
                    playerNumber = 4;
                    System.out.println("\nSuit in play: " + suitToPlay);
                    System.out.println("player: 4");
                    player4:
                    while (true){
                        System.out.print("""
                            a - Add card
                            p - Play card
                            v - view hand
                            vs - view cards of a suit s.
                            e - end turn
                            """);
                        System.out.print("Type here: ");
                        option = input.nextLine();
                        switch (option) {
                            // add a card to player  hand
                            case "a":
                                main.addCard();
                                System.out.println("\nNext player..");
                                break player4;

                            // play a card
                            case "p":
                                System.out.println("player 2 played " + main.playCard());
                                System.out.println("\nNext player..");
                                break player4;

                            // view player hand
                            case "v":
                                System.out.println(main.view());
                                break;

                            // View cards of suit s in hand
                            case "vs":
                                main.viewCardsOfSuit();
                                break;

                            // end player turn
                            case "e":
                                System.out.println("\nNext player..");
                                break player4;

                            default:
                                System.out.println("\nNot an option.\n");
                        }
                    }
                    // checking whether the deck is empty
                    if (deck.isEmpty()){
                        System.out.println("Game over. Deck is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + p1.toString());
                        System.out.println("Player 2: " + p2.toString());
                        System.out.println("Player 3: " + p3.toString());
                        System.out.println("Player 4: " + p4.toString());
                        p1.clear();
                        p2.clear();
                        p3.clear();
                        p4.clear();
                        deck.clear();
                        break;
                    }

                }

            } else if (option.equals("e")) {
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("\nNot an option, Please try again\n");
            }
        }
    }
}