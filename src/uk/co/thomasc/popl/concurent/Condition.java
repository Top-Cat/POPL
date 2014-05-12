package uk.co.thomasc.popl.concurent;

public class Condition {
	
	int waiters = 0;
	BSemaphore sem = new BSemaphore(0);
	
}