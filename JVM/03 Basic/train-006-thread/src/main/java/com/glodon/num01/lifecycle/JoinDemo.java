package com.glodon.num01.lifecycle;

import java.util.concurrent.TimeUnit;

/**
 * Join示例
 * 
 * @author fucy
 * @date 2020年7月27日
 * @since JDK1.8
 */
public class JoinDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Begin");
		
		MyThread t = new MyThread();
		
		t.start();
		
		// 等待t线程结束，在继续执行
		t.join();
		
		System.out.println("Main Finish");
	}
}

class MyThread extends Thread {
	
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
				
				System.out.println("Current: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("My Thread Finish");
	}
}