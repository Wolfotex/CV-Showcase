
import java.util.Random;
import java.util.Scanner;

public class Main {
    Random rand = new Random();
    static MyArrayList<Card> cards = new MyArrayList<>();
    static MyArrayList<Card> player1 = new MyArrayList<>();
    static MyArrayList<Card> player2 = new MyArrayList<>();
    static MyArrayList<Card> player3 = new MyArrayList<>();
    static MyArrayList<Card> player4 = new MyArrayList<>();

    MyArrayList<Card> temp = new MyArrayList<>();
    
    Card tempCard;
    
    static String suitToPlay;

    static int player;

    private void initialize(){
        // create sorted cards of cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String s : suits){
            for (int r = 2; r <= 14; r++){
                cards.add(new Card(s, r));
            }
        }

        // shuffling the cards of cards
        int len = cards.size();
        for (int i = 0; i < len; i++){
            int j = i + rand.nextInt(len - i);
            Card tempCard = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, tempCard);
        }
    }

    private void sortHand(MyArrayList<Card> hand) {
        int handSize = hand.size();
        for (int i = 0; i < handSize - 1; i++) {
            for (int j = i + 1; j < handSize; j++) {
                Card card1 = hand.get(i);
                Card card2 = hand.get(j);
                if (card1.getSuit().compareTo(card2.getSuit()) < 0 ||
                        (card1.getSuit().equals(card2.getSuit()) && card1.getRank() < card2.getRank())) {
                    // Swap the cards if they are in the wrong order based on suit or rank
                    hand.set(i, card2);
                    hand.set(j, card1);
                }
            }
        }
    }

    private void addCard() {
        MyArrayList<Card> playerHand = getPlayerHand();

        if (playerHand.isEmpty()) {
            // Add the top card from the cards to the player's hand
            playerHand.add(cards.remove(0));
        } else {
            // Add a card to the player's hand and sort it
            playerHand.add(cards.remove(0));
            sortHand(playerHand);
        }

        displayPlayerHand(playerHand);
    }

    private MyArrayList<Card> getPlayerHand() {
        switch (player) {
            case 1: return player1;
            case 2: return player2;
            case 3: return player3;
            case 4: return player4;
            default: throw new IllegalStateException("Invalid player number: " + player);
        }
    }

    private void displayPlayerHand(MyArrayList<Card> playerHand) {
        System.out.print("\nYour hand: ");
        System.out.print(playerHand.toString());
        System.out.println("\n");
    }


    private String view() {
        String result = "";
        switch (player) {
            case 1:
                result = "\nplayer 1: " + player1.toString() + "\n";
                break;
            case 2:
                result = "\nplayer 2: " + player2.toString() + "\n";
                break;
            case 3:
                result = "\nplayer 3: " + player3.toString() + "\n";
                break;
            case 4:
                result = "\nplayer 4: " + player4.toString() + "\n";
                break;
            default:
                break;
        }
        return result;
    }

    // play a card from a player's hand
    public String playCard(MyArrayList<Card> playerHand, int player, String suitToPlay) {
        int size = playerHand.size();

        // check if player's hand is empty
        if (size == 0) {
            return "\nHand is empty";
        }

        // check if player has a card of the same suit as the suit currently in play
        for (int i = 0; i < size; i++) {
            if (playerHand.get(i).suit.equals(suitToPlay)) {
                // return the highest valued card of that suit
                return "\nYou played " + playerHand.remove(i).toString();
            }
        }

        // if player doesn't have a card of that suit, select an arbitrary card
        int randomCardIndex = new Random().nextInt(size);
        String arbitrarySuit = playerHand.get(randomCardIndex).suit;

        // update the suit in play
        suitToPlay = arbitrarySuit;

        // return the selected card
        for (int i = 0; i < size; i++) {
            if (playerHand.get(i).suit.equals(arbitrarySuit)) {
                return "\nYou played " + playerHand.remove(i).toString();
            }
        }

        return null;
    }

    private void viewCardsOfSuit(){
        // checking for cards of suit s in player 1 hand
        if (player == 1){
            // add cards of suit s to temp array list
            for (int i = 0; i < player1.size(); i++){
                if (player1.get(i).suit.equals(suitToPlay)){
                    temp.add(player1.get(i));
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
        else if (player == 2) {
            // add cards of suit s to temp array list
            for (int i = 0; i < player2.size(); i++){
                if (player2.get(i).suit.equals(suitToPlay)){
                    temp.add(player2.get(i));
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
        else if (player == 3) {
            // add cards of suit s to temp array list
            for (int i = 0; i < player3.size(); i++){
                if (player3.get(i).suit.equals(suitToPlay)){
                    temp.add(player3.get(i));
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
        else if (player == 4) {
            // add cards of suit s to temp array list
            for (int i = 0; i < player4.size(); i++){
                if (player4.get(i).suit.equals(suitToPlay)){
                    temp.add(player4.get(i));
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

    public String capitalize(String str) {
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
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

                // create the cards and shuffle the cards
                main.initialize();

                while (true){
                    // checking whether the cards is empty
                    if (cards.isEmpty()){
                        System.out.println("Game over. cards is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + player1.toString());
                        System.out.println("Player 2: " + player2.toString());
                        System.out.println("Player 3: " + player3.toString());
                        System.out.println("Player 4: " + player4.toString());
                        player1.clear();
                        player2.clear();
                        player3.clear();
                        player4.clear();
                        cards.clear();
                        break;
                    }


                    // player 1's turn
                    player = 1;
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
                                System.out.println(main.playCard(player1, 1, suitToPlay));
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

                    // checking whether the cards is empty
                    if (cards.isEmpty()){
                        System.out.println("Game over. cards is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + player1.toString());
                        System.out.println("Player 2: " + player2.toString());
                        System.out.println("Player 3: " + player3.toString());
                        System.out.println("Player 4: " + player4.toString());
                        player1.clear();
                        player2.clear();
                        player3.clear();
                        player4.clear();
                        cards.clear();
                        break;
                    }

                    //player 2
                    player = 2;
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
                                System.out.println("player 2 played " + main.playCard(player2, 2, suitToPlay));
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

                    // checking whether the cards is empty
                    if (cards.isEmpty()){
                        System.out.println("Game over. cards is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + player1.toString());
                        System.out.println("Player 2: " + player2.toString());
                        System.out.println("Player 3: " + player3.toString());
                        System.out.println("Player 4: " + player4.toString());
                        player1.clear();
                        player2.clear();
                        player3.clear();
                        player4.clear();
                        cards.clear();
                        break;
                    }

                    //player3
                    player = 3;
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
                                System.out.println("player 2 played " + main.playCard(player3, 3 , suitToPlay));
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

                    // checking whether the cards is empty
                    if (cards.isEmpty()){
                        System.out.println("Game over. cards is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + player1.toString());
                        System.out.println("Player 2: " + player2.toString());
                        System.out.println("Player 3: " + player3.toString());
                        System.out.println("Player 4: " + player4.toString());
                        player1.clear();
                        player2.clear();
                        player3.clear();
                        player4.clear();
                        cards.clear();
                        break;
                    }

                    //player 4
                    player = 4;
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
                                System.out.println("player 2 played " + main.playCard(player4, 4, suitToPlay));
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
                    // checking whether the cards is empty
                    if (cards.isEmpty()){
                        System.out.println("Game over. cards is empty");
                        System.out.println("Player cards,");
                        System.out.println("Player 1: " + player1.toString());
                        System.out.println("Player 2: " + player2.toString());
                        System.out.println("Player 3: " + player3.toString());
                        System.out.println("Player 4: " + player4.toString());
                        player1.clear();
                        player2.clear();
                        player3.clear();
                        player4.clear();
                        cards.clear();
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