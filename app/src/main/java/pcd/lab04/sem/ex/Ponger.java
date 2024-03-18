package pcd.lab04.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {
	Semaphore mutexPing;
	Semaphore mutexPong;
	public Ponger(Semaphore mutexPing, Semaphore mutexPong) {
		this.mutexPing = mutexPing;
		this.mutexPong = mutexPong;
	}	
	
	public void run() {
		while (true) {
			try {
				mutexPing.acquire();
				System.out.println("pong!");
				mutexPong.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}