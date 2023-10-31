package com.glodon.num01.inheritance.exercise;

/**
 * 宇宙飞船（继承Ship）
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class SpaceShip extends Ship {
	
	@Override
	public void left() {
		System.out.println("宇宙飞船向左运行...");
	}
	
	@Override
	public void right() {
		System.out.println("宇宙飞船向右运行...");
	}
	
	@Override
	public void forward() {
		System.out.println("宇宙飞船向前运行...");
	}
	
	@Override
	public void back() {
		System.out.println("宇宙飞船向后运行...");
	}
	
}
