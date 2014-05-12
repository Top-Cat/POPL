package uk.co.thomasc.popl.thread;

import uk.co.thomasc.popl.buffer.Buffer;

public class Consumer extends Thread {
	
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		int value = 0;
		
		while (true) {
			value = buffer.retreive();
			System.out.println(getName() + ": " + value);
		}
	}
	
}