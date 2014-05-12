package uk.co.thomasc.popl.buffer;

import uk.co.thomasc.popl.concurent.BSemaphore;
import uk.co.thomasc.popl.concurent.Semaphore;

public class SBuffer implements Buffer {
	
	private int[] buffer;
	private Semaphore lock = new BSemaphore();
	private Semaphore freeSpace;
	private Semaphore usedSpace;
	
	private int size = 0;
	private int next = 0;
	private int first = 0;
	
	public SBuffer(int size) {
		this.size = size;
		buffer = new int[size];
		freeSpace = new Semaphore(size);
		usedSpace = new Semaphore(size, 0);
	}
	
	public void insert(int value) {
		freeSpace.swait();
			lock.swait();
				buffer[next++ % size] = value;
			lock.ssignal();
		usedSpace.ssignal();
	}
	
	public int retreive() {
		usedSpace.swait();
			lock.swait();
				int value = buffer[first++ % size];
			lock.ssignal();
		freeSpace.ssignal();
		return value;
	}
	
}