package Multithreading.ExclusiveSynchronisation;

public class Consumer extends Thread {
	private Buffer buf;
	public Consumer(Buffer b)
	{
		buf = b;
		
	}
	
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			buf.write(i);
			System.out.println("Consumer writes :" + i);
		}
	}

}
