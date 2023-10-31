package com.glodon.num04.myinterface;

/**
 * 苦肉计策略
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class KurouStrategy implements IStrategy {
	
	private Idea idea = new KurouIdea();

	@Override
	public void operate() {
		idea.work();
	}

}
