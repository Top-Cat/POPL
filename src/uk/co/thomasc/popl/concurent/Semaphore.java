package uk.co.thomasc.popl.concurent;

public class Semaphore {

	protected int size = 1;
	protected int value = 1;
	
	public Semaphore(int size) {
		this(size, size);
	}
	
	public Semaphore(int size, int initalValue) {
		this.value = initalValue;
		this.size = size;
	}
	
	public synchronized void swait() {
		while (value == 0) {
			try {
				wait();
			} catch (InterruptedException e) {};
		}
		value--;
	}

	public synchronized void ssignal() {
		assert value < size;
		
		value++;
		notifyAll();
	}

}
