package uk.co.thomasc.popl.concurent;

public class Monitor {
	
	private BSemaphore mutex = new BSemaphore();
	
	public void a() {
		mutex.swait();
	}
	
	public void z() {
		mutex.ssignal();
	}
	
	public void swait(Condition c) {
		c.waiters++;
		
		mutex.ssignal();
			c.sem.swait();
		mutex.swait();
	}
	
	public void snotify(Condition c) {
		if (c.waiters > 0) {
			c.waiters--;
			c.sem.ssignal();
		}
	}
	
	public void snotifyAll(Condition c) {
		while (c.waiters > 0) {
			snotify(c);
		}
	}
	
}