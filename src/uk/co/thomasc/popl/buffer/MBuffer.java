package uk.co.thomasc.popl.buffer;

import uk.co.thomasc.popl.concurent.Condition;
import uk.co.thomasc.popl.concurent.Monitor;

public class MBuffer extends Monitor implements Buffer {
	
	private int[] buffer;
	private Condition full = new Condition();
	private Condition empty = new Condition();
	
	private int size = 0;
	private int count = 0;
	
	private int next = 0;
	private int first = 0;
	
	public MBuffer(int size) {
		this.size = size;
		buffer = new int[size];
	}
	
	public void insert(int value) {
		a();
			while (count == size) {
				swait(full);
			}
			
				buffer[next++ % size] = value;
				count++;
			
			if (count == 1) {
				snotify(empty);
			}
		z();
	}
	
	public int retreive() {
		a();
			while (count == 0) {
				swait(empty);
			}
			
				int value = buffer[first++ % size];
				count--;
			
			if (count == size - 1) {
				snotify(full);
			}
		z();
		return value;
	}
	
}