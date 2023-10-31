package com.glodon.num02.threadnosafe;

public class TestThread2 extends Thread {
	StringBuilder builder;
	
	public TestThread2(String name, StringBuilder builder) {
		super(name);
		this.builder = builder;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			builder.append("B" + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
