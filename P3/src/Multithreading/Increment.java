package Multithreading;

public class Increment extends Thread {
	private Counter counter;
	public Increment(Counter c)
	{
		counter = c;
	}
	@Override
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			counter.increment();
		}
		
	}
}
