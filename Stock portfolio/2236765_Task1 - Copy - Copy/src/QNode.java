public class QNode {
    QNode next;
    int data;

    // Empty Node
    public QNode(){
        next = null;
        data = Integer.MIN_VALUE;
    }

    // Node storing the specific data
    public  QNode(int data){
        next = null;
        this.data = data;
    }

    // Return the node
    public QNode getNext(){
        return next;
    }

    public void setNext(QNode node){
        next = node;
    }

    // Returns the data stored in this node.
    public int getData(){
        return data;
    }

    // Sets the data stored in this node
    public void setData(int element){
        data = element;
    }

    public String toString(){
        return Integer.toString(data);
    }
}
