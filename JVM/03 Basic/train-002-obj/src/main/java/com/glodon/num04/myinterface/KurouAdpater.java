package com.glodon.num04.myinterface;

/**
 * 适配器（方法二）
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class KurouAdpater extends KurouIdea implements IStrategy {

	@Override
	public void operate() {
		work();
	}

}
