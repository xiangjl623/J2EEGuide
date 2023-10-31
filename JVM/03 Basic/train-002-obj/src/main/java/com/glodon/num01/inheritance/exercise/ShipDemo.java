package com.glodon.num01.inheritance.exercise;

/**
 * 示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class ShipDemo {
	
	public static void main(String[] args) {
		Ship ship = new SpaceShip();
		
		ship.forward();
		ship.left();
		ship.right();
		ship.back();
	}
	
}
