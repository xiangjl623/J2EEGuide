package com.glodon.num02.polymorphic;

/**
 * 奏乐仪器
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class Instrument {
	
	public Instrument() {
		// 构造器中调用了运行时绑定的方法
		play(null);
	}

	public void play(String n) {
		System.out.println("Instrument.play()");
	}

}
