import java.util.Scanner;

public class Task1 {
    public static Queue sharesBought = new Queue();
    public static Queue priceBought = new Queue();

    public static Scanner input = new Scanner(System.in);

    public static String choice, tempData;
    public int numberOfSharesBought, pricePerShareBought, numberOfSharesSell, pricePerShareSell, topSharesBought, topPriceBought, sharesLeft, gain;

    public static void main(String[] args) throws  Exception{

        Task1 main = new Task1();

        label:
        while (true){
            System.out.print("""

                    Type,
                    S - Sell shares
                    B - Buy Shares
                    E - Exit the program
                    Choice:\s""");
            choice = input.nextLine();
            choice = choice.toUpperCase();

            switch (choice) {
                // Buy shares
                case "B":
                    main.buy();
                    break;

                // Sell shares
                case "S":
                    main.sell();
                    break;

                // Exit the program
                case "E":
                    System.out.println("Exiting...");
                    break label;

                // View remaining shares
                case "V":
                    main.view();

                // When user gives a wrong input
                default:
                    System.out.println("Not an option, Please try again.");
                    break;
            }
        }
    }

    // Buy shares
    public void buy(){
        // Get number of shares buying from user
        System.out.print("\n" +
                "Number of shares: ");
        tempData = input.nextLine();
        // Covert the string to integer
        numberOfSharesBought = Integer.parseInt(tempData);

        // Add the number of shares to the sharesBought queue
        sharesBought.enQueue(numberOfSharesBought);

        // Get price per share when buying from user
        System.out.print("Price: ");
        tempData = input.nextLine();
        // Covert the string to integer
        pricePerShareBought = Integer.parseInt(tempData);

        // Add the price per share to the priceBought queue
        priceBought.enQueue(pricePerShareBought);

        // Display the total value of the bought shares
        System.out.println("You have bought " + numberOfSharesBought + " shares for " + (numberOfSharesBought * pricePerShareBought));
    }

    // sell shares
    public void sell() throws Exception {
        // Get number of shares selling from user
        System.out.print("\n" +
                "Number of shares: ");
        tempData = input.nextLine();
        numberOfSharesSell = Integer.parseInt(tempData);

        // Get price per share when buying from user
        System.out.print("Price: ");
        tempData = input.nextLine();
        pricePerShareSell = Integer.parseInt(tempData);

        // Get the top elements from the two queues
        topSharesBought = sharesBought.first();
        topPriceBought = priceBought.first();
        sharesLeft = topSharesBought - numberOfSharesSell;

        // No shares left
        if (topSharesBought == 0 || topPriceBought == 0){
            System.out.println("""

                    No shares to sell!
                    """);
        }
        // If you have more shares left after selling
        else if (sharesLeft > 0) {
            // Calculate the capital gain/loss
            gain = sharesLeft * (pricePerShareSell - topPriceBought);

            // Display the capital gain/loss
            if (gain > 0){
                System.out.println("\nCapital gain: " + gain);
            }else {
                System.out.println("\nCapital loss: " + gain);
            }

            // Update the remaining shares after selling
            sharesBought.changeTop(sharesLeft);
        }

        // Selling the exact amount of shares left at the top
        else if (sharesLeft == 0) {
            // Dequeue from sharesBough
            topSharesBought = sharesBought.deQueue();
            topPriceBought = priceBought.deQueue();

            // Calculate the capital loss/gain
            gain = numberOfSharesSell * pricePerShareSell - topSharesBought * topPriceBought;

            // Display capital gain/loss
            if (gain > 0){
                System.out.println("\nCapital gain: " + gain);
            }else {
                System.out.println("\nCapital loss: " + gain);
            }

        }

        // Selling more than the amount of shares left at the top
        else {
            int leftSharesToSell = numberOfSharesSell;
            gain = 0;
            while (true){
                // get the front most element from sharesBought Queue
                topSharesBought = sharesBought.first();

                // When the shares queue is empty
                if (sharesBought.isEmpty()){
                    // Display capital gain/loss
                    if (gain > 0){
                        System.out.println("\nCapital gain: " + gain);
                    }else {
                        System.out.println("\nCapital loss: " + gain);
                    }
                    System.out.println("You have sold all of your shares!");
                }

                // When the amount of shares left to sell is more than the front most element
                if (leftSharesToSell > topSharesBought){
                    // Dequeue from sharesBought and priceBought queues
                    topSharesBought = sharesBought.deQueue();
                    topPriceBought = priceBought.deQueue();

                    // calculate the remaining shares needed to be sold
                    leftSharesToSell = leftSharesToSell - topSharesBought;

                    // Calculate gain/loss
                    gain += (topSharesBought * (pricePerShareSell - topPriceBought));


                }
                // When the amount of shares left to sell is equal the front most element
                else if (leftSharesToSell == topSharesBought) {
                    // Dequeue from sharesBought and priceBought queues
                    topSharesBought = sharesBought.deQueue();
                    topPriceBought = priceBought.deQueue();

                    // Calculate gain/loss
                    gain += (topSharesBought * (pricePerShareSell - topPriceBought));

                    // Display capital gain/loss
                    if (gain > 0){
                        System.out.println("\nCapital gain: " + gain);
                    }else {
                        System.out.println("\nCapital loss: " + gain);
                    }
                    break;
                } else {
                    // Get the fromnt most elements from sharesBought and priceBought queues
                    topSharesBought = sharesBought.first();
                    topPriceBought = priceBought.first();

                    // Calculate the shares left after selling
                    sharesLeft = topSharesBought - leftSharesToSell;

                    // Calculate gain/loss
                    gain += leftSharesToSell * (pricePerShareSell - topPriceBought);

                    // Update the remaining shares in Shares queue
                    sharesBought.changeTop(sharesLeft);

                    // Display capital gain/loss
                    if (gain > 0){
                        System.out.println("\nCapital gain: " + gain);
                    }else {
                        System.out.println("\nCapital loss: " + gain);
                    }
                    break;
                }
            }

        }
    }

    // Display the remaining shares
    public void view(){
        System.out.print(sharesBought.toString());
    }
}
