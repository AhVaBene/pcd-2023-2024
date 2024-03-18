package pcd.lab04.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {
	Semaphore mutexPing;
	Semaphore mutexPong;
	public Pinger(Semaphore mutexPing, Semaphore mutexPong) {
		this.mutexPing = mutexPing;
		this.mutexPong = mutexPong;
	}	
	
	public void run() {
		while (true) {
			try {
				mutexPong.acquire();
				System.out.println("ping!");
				mutexPing.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}