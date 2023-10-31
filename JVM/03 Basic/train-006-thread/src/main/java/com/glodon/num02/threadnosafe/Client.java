package com.glodon.num02.threadnosafe;

public class Client {
	
	public static void main(String[] args) throws InterruptedException {
		StringBuilder builder = new StringBuilder();  

		TestThread1 t1 = new TestThread1("t1", builder);
		TestThread2 t2 = new TestThread2("t2", builder);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(builder.toString());
	}
	
}
