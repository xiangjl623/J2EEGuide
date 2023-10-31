package com.glodon.num04.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 练习
 * 
 * @author fucy
 * @date 2020年7月27日
 * @since JDK1.8
 */
public class RunDemo implements Runnable {
	private String startMsg;
	private String endMsg;
	
	public RunDemo(String startMsg, String endMsg) {
		this.startMsg = startMsg;
		this.endMsg = endMsg;
	}

	@Override
	public void run() {
		System.out.println(this + " " + startMsg + " start");
		
		for (int i = 0; i < 3; i++) {
			System.out.println(this + " run " + i);
			Thread.yield();
		}
		
		System.out.println(this + " " + endMsg + " end");
	}
	
	@Override
	public String toString() {
		return Thread.currentThread().getName();
	}
	
	public static void main(String[] args) {
		RunDemo demo = new RunDemo("a", "b");
		
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		threadPool.execute(demo);
		threadPool.execute(demo);
		threadPool.execute(demo);
		
		threadPool.shutdown();
	}
	
}
