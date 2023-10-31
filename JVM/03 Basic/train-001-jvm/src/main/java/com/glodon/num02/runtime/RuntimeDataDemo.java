package com.glodon.num02.runtime;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.DecimalFormat;

/**
 * 运行时数据示例
 * 
 * @author fucy
 * @date 2020年7月20日
 * @since JDK1.8
 */
public class RuntimeDataDemo {

	public static void main(String[] args) throws Exception {
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
		
		System.out.println("---------------- 堆内存 ----------------");

		System.out.println("最大堆内存：" + view(heapMemoryUsage.getMax()));
		System.out.println("初始堆内存：" + view(heapMemoryUsage.getInit()));
		System.out.println("使用堆内存：" + view(heapMemoryUsage.getUsed()));
		
		System.out.println("---------------- 非堆内存 ----------------");

		MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

		System.out.println("最大非堆内存：" + view(nonHeapMemoryUsage.getMax()));
		System.out.println("初始非堆内存：" + view(nonHeapMemoryUsage.getInit()));
		System.out.println("使用非堆内存：" + view(nonHeapMemoryUsage.getUsed()));
	}

	/**
	 * 大小显示转换
	 * 
	 * @param size
	 * @return
	 */
	public static String view(long size) {
		if (size<0) return "不限制";
		
		String[] arr = { "Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" };
		
		float srcsize = Float.valueOf(size);
		int index = (int) (Math.floor(Math.log(srcsize) / Math.log(1024)));
		double curSize = srcsize / Math.pow(1024, index);
		curSize = Double.valueOf(new DecimalFormat("#.00").format(curSize));
		
		return curSize + arr[index];
	}
}
