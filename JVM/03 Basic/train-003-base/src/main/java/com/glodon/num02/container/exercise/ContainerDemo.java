package com.glodon.num02.container.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 容器示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class ContainerDemo {
	
	public static void main(String[] args) {
		List<A> list = new ArrayList<>();
		
		list.add(new A("zhangsan", "25"));
		list.add(new A("lisi", "13"));
		list.add(new A("wangwu", "34"));
		list.add(new A(null, "23"));
		
		// 按照对象的compareTo排序
		Collections.sort(list);
		
		System.out.println("按照a1排序：" + list);
		
		// 自定义排序
		Collections.sort(list, new Comparator<A>() {

			@Override
			public int compare(A o1, A o2) {
				if (o1.getA1()==null && o2.getA1()==null) return 0;
				
				if (o1.getA1()==null) return 1;
				
				if (o2.getA1()==null) return -1;
				
				return o1.getA1().compareTo(o2.getA1());
			}
		});
		
		System.out.println("按照a2排序：" + list);
	}
	
}
