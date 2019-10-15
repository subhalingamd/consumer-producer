// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;

	@SuppressWarnings("unchecked")
    public Queue(int capacity) {
        queue=new NodeBase[capacity];
        front=rear=-1;
        currentSize=0;
        this.capacity=capacity;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize<=0;
    }
	
    public boolean isFull() {
        return currentSize>=capacity;
    }

    public void enqueue(Node<V> node) {
        if (isFull())
            return;

        if(front==-1) 
            front=0;
        rear=(rear+1)%capacity;
        queue[rear]=node;
        currentSize++;  
    }

    public NodeBase<V> dequeue() {
        if (isEmpty())
            return null;
        
        NodeBase<V> R = queue[front];
        if (front==rear)
              front=rear=-1;
        else
            front=(front+1)%capacity;
        currentSize--;
        return R;
    }

}

