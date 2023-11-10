public class Queue {
    private  int length;
    private  QNode front, rear;

    // Makes an empty queue
    public Queue(){
        length = 0;
        front = rear = null;
    }

    // Check if queue is empty
    public boolean isEmpty(){
        return (length == 0);
    }

    // Add data to the rear of the queue
    public void enQueue(int data){
        QNode node = new QNode(data);

        if (isEmpty()){
            front = node;
        } else {
            rear.setNext (node);
        }

        rear = node;
        length++;
    }

    // Removes the data at the front of the queue
    public int deQueue() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue");
        }

        int result = front.getData();
        front = front.getNext();
        length--;
        if (isEmpty()){
            rear = null;
        }
        return result;
    }

    // get the data at the front of the queue
    public int first() throws Exception{
        if (isEmpty()){
            return 0;
        }
        return front.getData();
    }

    //  Returns the number of elements in this queue.
    public int size(){
        return length;
    }

    //  Returns a string representation of this queue.
    public String toString(){
        String result = "";
        QNode current = front;
        while (current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

    // Replace the front most element
    public void changeTop(int newTop){
        front.setData(newTop);
    }

}