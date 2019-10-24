package Multithreading;

public class Counter {
	private int val;
	public Counter()
	{
		val = 0;
	}
	
	public synchronized void increment()
	{
		++val;print();
	}
	public synchronized void decrement()
	{
		--val;print();
	}

	private void print() {
		System.out.println(val);
		
	}

}
