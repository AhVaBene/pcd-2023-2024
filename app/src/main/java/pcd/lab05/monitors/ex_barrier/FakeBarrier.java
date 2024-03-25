package pcd.lab05.monitors.ex_barrier;

/*
 * Barrier - to be implemented
 */
public class FakeBarrier implements Barrier {
	private final int nPartecipants;
	private int acc;
	public FakeBarrier(int nParticipants) {
		this.acc = 0;
		this.nPartecipants = nParticipants;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		this.acc++;
		while(this.acc < this.nPartecipants) {
			wait();
		}
		notify();
	}

	
}
