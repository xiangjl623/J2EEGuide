package com.glodon.num03.threadsafe;

public class TestThread1 extends Thread {
	StringBuffer buffer;
	
	public TestThread1(String name, StringBuffer buffer) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			buffer.append("A" + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
