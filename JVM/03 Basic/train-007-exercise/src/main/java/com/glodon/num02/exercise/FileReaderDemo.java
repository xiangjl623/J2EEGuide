package com.glodon.num02.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 文件读取示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class FileReaderDemo {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("other/test1"));
		BufferedReader br = new BufferedReader(fr);
		List<String> list = new LinkedList<>();
		
		// 文件流中读取信息
		try {
			String line = null;
			
			while ((line=br.readLine()) != null) {
				list.add(line);
			}
		} finally {
			if (fr!=null) {
				fr.close();
			}
		}
		
		// 反向打印List
		ListIterator<String> listIterator = list.listIterator(list.size());
		
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}
	
}
