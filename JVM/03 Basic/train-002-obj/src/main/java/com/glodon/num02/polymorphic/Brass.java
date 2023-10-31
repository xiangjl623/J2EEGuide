package com.glodon.num02.polymorphic;

/**
 * 管乐
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class Brass extends Instrument {
	private int value = 10;

	@Override
	public void play(String n){
		// 可以正确打印吗？
		System.out.println("Brass.play():" + value);
	}
	
	public void play(String n, int m){
		System.out.println("bbb");
	}

	public static void main(String[] args) {
		Brass b = new Brass();
		System.out.println("-------------");
		b.play("音乐");
	}

}
