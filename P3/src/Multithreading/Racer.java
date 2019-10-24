package Multithreading;

public class Racer extends Thread { // or implements Runnable
    private char id;

    public Racer(char id) {
      this.id = id;
    }

    public void run() {
      for (int i=0; i<1000; i++)
        System.out.println(id + ":" + i);
    }
  }
