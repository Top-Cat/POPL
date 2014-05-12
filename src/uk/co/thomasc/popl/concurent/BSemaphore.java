package uk.co.thomasc.popl.concurent;

public class BSemaphore extends Semaphore {

	public BSemaphore() {
		super(1);
	}
	
	public BSemaphore(int initalValue) {
		super(1, initalValue);
	}

}