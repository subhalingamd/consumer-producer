
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
        queue=new NodeBase[capacity];
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
        
        int i;
        for (i=0;i<currentSize;i++)
            if (node.getPriority()<queue[i].getPriority())
                break;
        for (int j=currentSize;j>i;j--)
            queue[j]=queue[j-1];
        queue[i]=node;
        currentSize++;
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if (isEmpty())
            return null;

        NodeBase<V> R=queue[0];
        for (int i=1;i<currentSize;i++)
            queue[i-1]=queue[i];
        currentSize--;
        return R;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i+1].show();
	}
    }
}

