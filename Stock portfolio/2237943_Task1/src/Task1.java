import java.util.Scanner;

class Node{
    public Node next;
    public int element;

    public Node(int element){
        next = null;
        this.element = element;
    }

    // Return the node
    public Node getNext(){
        return next;
    }

    //Sets the node that follows this node
    public void setNext(Node node) {
        next = node;
    }

    // Returns the data stored in this node
    public int getData(){
        return element;
    }

    // Sets the data stored in this node.
    public void setData (int elem){
        element = elem;
    }


    public String toString(){
        return Integer.toString(element);
    }
}

class Queue{
    private int size;
    private Node front, rear;

    // Creates a queue
    public Queue(){
        size = 0;
        front = rear = null;
    }

    // To check if queue is empty and return true or false
    public boolean isEmpty(){
        return (size == 0);
    }

    // enqueue data to the end of the queue
    public void enEnqueue(int element){
        Node node = new Node(element);
        if (isEmpty()){
            front = node;
        }else {
            rear.setNext(node);
        }
        rear = node;
        size++;
    }

    // dequeues the data at the front of the queue
    public int deQueue(){
        int result = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()){
            rear = null;
        }
        return result;
    }

    // get the most front element in the queue
    public int top(){
        if (isEmpty()){
            return 0;
        }
        return front.getData();
    }

    public void update(int elem){
        front.setData(elem);
    }

    public String toString(){
        String result = "";
        Node current = front;
        while (current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
public class Task1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String option, tempElem;
        int boughtAmount, boughtPrice, sellAmount, sellPrice, topAmount, topPrice, sharesLeft, gain;

        // create queues
        Queue shares = new Queue();
        Queue price = new Queue();

        label:
        while (true){
            // display main instructions
            System.out.print("""
                    \n
                    To buy shares type 'B'
                    To sell shares type 'S'
                    To exit type 'E'
                    Type here:\s""");
            // get user option
            option = input.nextLine();
            option = option.toUpperCase();

            // to buy shares
            switch (option) {
                case "B":
                    // Get number of shares user want to buy and convert it to int
                    System.out.print("""
                            
                            Number of shares you want to buy:\s""");
                    tempElem = input.nextLine();
                    boughtAmount = Integer.parseInt(tempElem);

                    // Get price per share when buying from user and convert it to int
                    System.out.print("""
                            Price per share:\s""");
                    tempElem = input.nextLine();
                    boughtPrice = Integer.parseInt(tempElem);

                    System.out.print("Total Value: " + (boughtAmount * boughtPrice));

                    // Enqueue the amount of shares and price to the queues
                    shares.enEnqueue(boughtAmount);
                    price.enEnqueue(boughtPrice);
                    break;

                // to sell shares
                case "S":
                    // Get the number of shares and price to sell
                    System.out.print("""
                            
                            Number of shares you want to sell:\s""");
                    tempElem = input.nextLine();
                    sellAmount = Integer.parseInt(tempElem);

                    System.out.print("""
                            Price per share:\s""");
                    tempElem = input.nextLine();
                    sellPrice = Integer.parseInt(tempElem);

                    topAmount = shares.top();
                    sharesLeft = topAmount - sellAmount;

                    // When there are no shares left to sell
                    if (topAmount == 0){
                        System.out.println("\n No shares left to sell.");
                    }

                    // If selling amount is equals to the front most element
                    if (sharesLeft == 0){
                        // Get the front most elements from shares and price queues
                        //topAmount = shares.deQueue();
                        topPrice = price.deQueue();

                        // Calculate the gain
                        gain = sellAmount * (sellPrice - topPrice);

                        // Display the gain/ Loss
                        if (gain >= 0){
                            System.out.println("Gain: " + gain);
                        }else {
                            System.out.println("Loss: " + gain);
                        }
                    }

                    // If user are selling less than front most amount of shares
                    else if (sharesLeft > 0){
                        // Get the front most values of shares and price queues
                        //topAmount = shares.top();
                        topPrice = price.top();

                        // Calculate the gain
                        gain = sellAmount * (sellPrice -  topPrice);

                        // Display the gain
                        if (gain >= 0){
                            System.out.println("Gain: " + gain);
                        }else {
                            System.out.println("Loss: " + gain);
                        }

                        // Update the remaining shares in Shares queue
                        shares.update(sharesLeft);
                    }

                    // If selling amount is more the amount of shares in the front most in the shares queue
                    else {
                        int sharesLeftToSell = sellAmount;
                        gain = 0;

                        while (true){
                            // Get the front most element from the shares queue
                            topAmount = shares.top();

                            // If there are no more shares left to sell
                            if (shares.isEmpty()){
                                if (gain >= 0){
                                    System.out.println("\n Gain: " + gain);
                                }else {
                                    System.out.println("\nLoss: " + gain);
                                }

                                System.out.println("No more shares left to sell.");
                                break;
                            }

                            // if the amount of shares left to sell is more than the front most element
                            if (sharesLeftToSell > topAmount){
                                // Dequeue from shares and price queues
                                topAmount = shares.deQueue();
                                topPrice = price.deQueue();

                                // Calculate the latest shares left to sell
                                sharesLeftToSell = sharesLeftToSell - topAmount;

                                // Calculate the gain
                                gain += (topAmount * sellPrice - topAmount * topPrice);
                            }

                            // If amount of shares to sell equals to front most element in shares queue
                            else if (sharesLeftToSell == topAmount){
                                // Get the front most elements from the two queues
                                topAmount = shares.deQueue();
                                topPrice = price.deQueue();

                                // Calculate the gain
                                gain += (topAmount * sellPrice - topAmount * topPrice);

                                // Display the gain/loss
                                if (gain >= 0){
                                    System.out.println("\nGain: " + gain);
                                }else {
                                    System.out.println("\nLoss: " + gain);
                                }
                                break;
                            }

                            // If amount of shares to sell less the front most element in the shares queue
                            else {
                                // Get the front most element from the queues
                                topAmount = shares.top();
                                topPrice = price.top();

                                // Calculate the shares left after selling
                                sharesLeft = topAmount - sharesLeftToSell;

                                // Calculate the gain
                                gain += (sharesLeftToSell * sellPrice - sharesLeftToSell * topPrice);

                                // Update the remaining shares in Shares queue
                                shares.update(sharesLeft);

                                // Display the gain/loss
                                if (gain >= 0){
                                    System.out.println("\nGain: " + gain);
                                }else {
                                    System.out.println("\nLoss: " + gain);
                                }
                                break;
                            }
                        }
                    }
                    break;

                // to exit
                case "E":
                    System.out.println("\nExiting...");
                    break label;

                // when user enters an invalid option
                default:
                    System.out.println("Not an option, please try again...");
            }
        }
    }
}
