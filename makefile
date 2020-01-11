compile:
	javac Bases.java
	javac Node.java
	javac Queue.java
	javac PriorityQueue.java
	javac Item.java
	javac Buyer.java
	javac Seller.java
	javac Assignment2Driver.java

run:
	java Assignment2Driver tests/input.txt > tests/output.txt

clean:
	rm *.class

