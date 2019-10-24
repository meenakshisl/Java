package Multithreading;

public class Decrement extends Thread{
	private Counter counter;
	public Decrement(Counter c)
	{
		counter = c;
	}
	@Override
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			counter.decrement();
		}
		
	}


}
