package Multithreading.ExclusiveSynchronisation;

public class Buffer {
	private int val;
	private boolean flag;
	
	public Buffer()
	{
		val = 0;
	}

	public synchronized void write(int i) {
		while(flag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = true;
		val = i;
		notify();
		// TODO Auto-generated method stub
		
	}
	public synchronized int read()
	{
		while(!flag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;
		System.out.println(val);
		notify();
		return val;
		
		
	}

}
