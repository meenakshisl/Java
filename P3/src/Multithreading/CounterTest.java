package Multithreading;

public class CounterTest {

	public static void main(String[] args) {
	
	    System.out.println("Main started");

	    Counter c = new Counter();
	    Increment i = new Increment(c);
	    Decrement d = new Decrement(c);

	    i.start();
	    d.start();

	    System.out.println("Main ended");

	}

}
