package uk.co.thomasc.popl;

import uk.co.thomasc.popl.buffer.Buffer;
import uk.co.thomasc.popl.buffer.MBuffer;
import uk.co.thomasc.popl.buffer.SBuffer;
import uk.co.thomasc.popl.thread.Consumer;
import uk.co.thomasc.popl.thread.Producer;

public class Main {
	
	public static void main(String[] args) {
		int bufferSize = 20;
		int producers = 2;
		int consumers = 2;
		
		/////////////////////////////////////////////
		
		Buffer b;
		
		b = new MBuffer(bufferSize);
		//b = new SBuffer(bufferSize);
		
		for (int x = 0; x < producers; x++) {
			new Producer(b).start();
		}
		for (int y = 0; y < consumers; y++) {
			new Consumer(b).start();
		}
	}
	
}