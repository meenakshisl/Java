package Multithreading.SimpleExample;

public class Main {

	public static void main(String[] args) {
		NewThread nt = new NewThread();
		nt.start();
		
		for(int i=0;i<100;i++)
		{
			System.out.println("main" + i);
		}
		// TODO Auto-generated method stub

	}

}
