package com.glodon.num03.array.exercise;

import java.util.Arrays;

/**
 * 练习1
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class ArrayDemo01 {
	
	public static void main(String[] args) {
		A[] array1 = new A[4];
		array1[0] = new A(23);
		array1[1] = new A(34);
		array1[2] = new A(26);
		array1[3] = new A(12);

		A[] array2 = new A[4];
		array2[0] = new A(23);
		array2[1] = new A(34);
		array2[2] = new A(26);
		array2[3] = new A(12);
		
		System.out.println("对比数组：" + Arrays.equals(array1, array2));
	}
	
}
