package uk.co.thomasc.popl.thread;

import java.util.Random;

import uk.co.thomasc.popl.buffer.Buffer;

public class Producer extends Thread {

	private Buffer buffer;
	private Random random = new Random();
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		int toInsert;
		
		while (true) {
			toInsert = random.nextInt();
			buffer.insert(toInsert);
		}
	}
	
}