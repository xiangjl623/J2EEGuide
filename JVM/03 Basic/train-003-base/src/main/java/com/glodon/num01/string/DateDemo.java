package com.glodon.num01.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则 示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class DateDemo {
	
	public static void main(String[] args) {
		getDate("Jan 01, 2020");
		getDate("2020-06-01");
	}
	
	public static void getDate(String str) {
		String regEx = "([a-zA-Z]+)\\s+([0-9]{1,2}),\\s*[0-9]{4}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);

		if (!matcher.find()) {
			System.out.println("日期格式错误!");
			return;
		}

		System.out.println(matcher.group(0));
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
	}

}
