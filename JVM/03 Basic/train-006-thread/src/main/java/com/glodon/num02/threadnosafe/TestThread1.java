package com.glodon.num02.threadnosafe;

public class TestThread1 extends Thread {
	StringBuilder builder;
	
	public TestThread1(String name, StringBuilder builder) {
		super(name);
		this.builder = builder;
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			builder.append("A" + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
