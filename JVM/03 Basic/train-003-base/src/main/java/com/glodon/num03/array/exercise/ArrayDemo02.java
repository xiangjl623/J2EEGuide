package com.glodon.num03.array.exercise;

import java.util.Arrays;
import java.util.Random;

/**
 * 练习2
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class ArrayDemo02 {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		int[] array = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		// 排序
		Arrays.sort(array);
		
		System.out.println(Arrays.toString(array));
	}
	
}
