package Multithreading;

public class Race {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread strarted");
		Racer ra = new Racer('A');
		ra.start();
		Racer rb = new Racer('B');
		rb.start();
		ra.join();
		rb.join();
		// TODO Auto-generated method stub
		System.out.println("Main thread finished");

	}

}
