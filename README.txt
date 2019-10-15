
COL106 - Data Structures & Algorithms
Assignment 2 

+===============================================+

STATUS: All Working | ISSUES: Nil 
(Last Updated: 2019-08-19 11:49:46)

+-----------------------------------------------+
| README.txt									                  |
+-----------------------------------------------+

> class Item
  Contains the name of the item and its cost. Public functions tor return name and cost and a toString() function that returns "<Name> <Price>"



> class Node
  Has a constructor that initialises the class members and some public functions to return these class members



> class Queue
  A typical circular Queue implementation

  > public Queue(int capacity)
    Constructor which initialises queue, front=rear=-1, capacity to that received in the constructor and currentSize=0

  > public int size()
    Returns currentSize of Queue

  > public boolean isEmpty()
    Returns true if Queue isEmpty (currentSize<=0) and false otherwise

  > public boolean isFull()
    Returns true if Queue isFull (currentSize>=capacity) and false otherwise

  > public void enqueue(Node<V> node)
    If Queue is full, leave the function. 
    If the Queue is empty (i.e. front==-1), then set front=rear=0. If Queue isn't full but rear has already reached (capacity-1), set rear=0 (start from beginning) otherwise increment rear by 1. One can observe that this can be simplified to setting front=0 if front=-1 and then setting rear=((rear+1) mod capacity). Set queue[rear]=node and increase currentSize by 1

  > public NodeBase<V> dequeue()
    If Queue is empty, leave the function by returning null. 
    Store queue[front] first.
    If the Queue has only one element (that is going to be removed), i.e., front==rear then set front=rear=-1. If Queue isn't going to be empty but front has already reached (capacity-1), set front=0 (start dequeueing from beginning) otherwise increment front by 1. One can observe that this can be simplified to setting front=rear=-1 if front==rear or setting front=((front+1) mod capacity) otherwise. Decrease currentSize by 1 and return the stored node



> class PriorityQueue

  > public PriorityQueue(int capacity)
    Constructor which initialises queue, capacity to that received in the constructor and currentSize=0

  > public int size()
    Returns currentSize of Queue

  > public boolean isEmpty()
    Returns true if Queue isEmpty (currentSize<=0) and false otherwise

  > public boolean isFull()
    Returns true if Queue isFull (currentSize>=capacity) and false otherwise

  > public void enqueue(Node<V> node)
    If Queue is full, leave the function. 
    Find i (0<=i<currentSize) such that node.priority<queue[i].priority using a loop. You have to insert the 'node' in the i-th position by shifting nodes from (currentSize-1)-th position to (currentSize)-th,..., (i+1)-th to (i+2)-th and i-th to (i+1)-th position and then inserting the 'node' (input) at i-th position of queue. Then increase currentSize by 1.
    

  > public NodeBase<V> dequeue()
    If Queue is empty, leave the function by returning null. 
    Store queue[0] first.
    Shift all i-th elements to (i-1)-th elements for i=1 to (currentSize-1) 
    Decrease currentSize by 1 and return the stored node



> class Seller
  Using the constructor to initialise the members

  > public void sell()
  Try: Lock the function so that no other thread can use simultaneously. If catalog isFull, suspend the thread using await() (and wait for a signal that catalog is no more full). Otherwise, If inventory isn't empty, dequeue the front item and enqueue it to the catalog accordingly. Signal that catalog is no more empty
  Catch: Exceptions
  Finally: unlock the function for other threads



> class Buyer
  Using the constructor to initialise the members

  > public void buy()
  Try: Lock the function so that no other thread can use simultaneously. If catalog isEmpty, suspend the thread using await() (and wait for a signal that catalog is no more empty). Otherwise, dequeue the front (most prioritised) item from the catalog and print it for testing. Signal that catalog is no more full.
  Catch: Exceptions
  Finally: unlock the function for other threads



> class Assignment2Driver
  > public static void main(String[] args)
  ...
  For 0<=i<list.size: inventory.enqueue(list[i]) i.e., Get all the objects stored in ArrayList and enqueue it to the inventory.
  ...
  For 0<=i<numBuyers: make buyer threads and start them
  For 0<=i<numSellers: make seller threads and start them


+===============================================+