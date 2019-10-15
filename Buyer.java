import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...

        setSleepTime(sleepTime);
        // this.catalogSize=catalogSize; 
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalog=catalog;
        setIteration(iteration);
    }
    public void buy() throws InterruptedException {
	try {
            //TODO Complete the try block for consume method
            // ...

            lock.lock();

            while (catalog.isEmpty()){
                empty.await();
            }

            Node<V> n = (Node<V>) catalog.dequeue();

	        System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)

            full.signalAll();

            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
            lock.unlock();
	}
    }
}
