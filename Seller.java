import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...

        setSleepTime(sleepTime);
        // this.catalogSize=catalogSize; 
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalog=catalog;
        this.inventory=inventory;
    }
    
    @SuppressWarnings("unchecked")
    public void sell() throws InterruptedException {
	try {
            //TODO Complete the try block for produce method
            // ...

            lock.lock();

            while (catalog.isFull()){
                full.await();
            }

            if (!inventory.isEmpty()){
            NodeBase<V> n=inventory.dequeue();
            catalog.enqueue(new Node(n.getPriority(),n));
        
            empty.signalAll();
            }


	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
            lock.unlock();
	}		
    }
}
