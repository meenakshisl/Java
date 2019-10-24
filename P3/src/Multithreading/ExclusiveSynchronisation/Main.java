package Multithreading.ExclusiveSynchronisation;

public class Main {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		Consumer c = new Consumer(b);
		Producer p = new Producer(b);
		
		c.start();
		p.start();
		

	}

}
