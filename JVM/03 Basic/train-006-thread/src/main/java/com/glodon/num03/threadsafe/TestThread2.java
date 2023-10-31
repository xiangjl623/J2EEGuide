package com.glodon.num03.threadsafe;

public class TestThread2 extends Thread {
	StringBuffer buffer;
	
	public TestThread2(String name, StringBuffer buffer) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			buffer.append("B" + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
