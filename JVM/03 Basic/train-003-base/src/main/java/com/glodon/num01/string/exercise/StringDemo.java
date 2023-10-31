package com.glodon.num01.string.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class StringDemo {
	
	private static final String log = "2020-07-09 00:43:05.885 - [INFO] [/cache/delete] [gly] [127.0.0.1] [2] [\"AUS:MEETING:40283e81732f3d8101732f4b2cdb0012:ENTER_MAIN\",null] --- {\"success\":true,\"code\":0,\"message\":\"成功\",\"data\":null}";
	private static Pattern logPatter = Pattern.compile("([0-9- :.]*) - \\[([A-Z]*)\\] \\[([\\w/]*)\\] \\[([a-z]*)\\] \\[([0-9.]*)\\].*");
	
	public static void main(String[] args) {
		Matcher matcher = logPatter.matcher(log);
		
		System.out.println("匹配结果：" + matcher.find());
		System.out.println("字符串：" + matcher.group(0));
		System.out.println("日期：" + matcher.group(1));
		System.out.println("访问地址：" + matcher.group(3));
		System.out.println("客户IP：" + matcher.group(5));
		
		Object obj = new Object();
		
		System.out.println(obj);
		
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("d");
		list.add("c");
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
		
		System.out.println(list);
	}
	
}
