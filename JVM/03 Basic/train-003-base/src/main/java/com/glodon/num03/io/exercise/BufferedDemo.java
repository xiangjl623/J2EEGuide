package com.glodon.num03.io.exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 缓冲示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class BufferedDemo {
	private static String outputFile = "D:\\logs\\gz_aus\\aus_engine\\aus-engine-2020-06-22-0.log.bak";
	private static String inputFile = "D:\\logs\\gz_aus\\aus_engine\\aus-engine-2020-06-22-0.log";
	
	public static void main(String[] args) throws Exception {
		copyByByte(new File(inputFile), new File(outputFile));
		
		copyByBuffer(new File(inputFile), new File(outputFile));
	}
	
	/**
	 * 字节拷贝
	 * 
	 * @param souceFile
	 * @param distFile
	 * @throws IOException
	 */
	private static void copyByByte(File souceFile, File distFile) throws IOException {
		File file = new File(outputFile);
		byte[] bytes = new byte[1024];
		
		if (file.exists()) {
			file.delete();
		}
		
		FileInputStream fis = new FileInputStream(souceFile);
		FileOutputStream fos = new FileOutputStream(distFile);
		
		Date begin = new Date();
		
		try {
			while((fis.read(bytes)) != -1) {
				fos.write(bytes);
			}
			
			fos.flush();
		} finally {
			if (fis!=null) {
				fis.close();
			}
			if (fos!=null) {
				fos.close();
			}
		}
		
		System.out.println("普通拷贝耗时：" + ((new Date().getTime()) - begin.getTime()) + "ms");
	}
	
	/**
	 * 缓存拷贝
	 * 
	 * @param souceFile
	 * @param distFile
	 * @throws IOException
	 */
	private static void copyByBuffer(File souceFile, File distFile) throws IOException {
		File file = new File(outputFile);
		byte[] bytes = new byte[1024];
		
		if (file.exists()) {
			file.delete();
		}
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(souceFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(distFile));
		
		Date begin = new Date();
		
		try {
			while((bis.read(bytes)) != -1) {
				bos.write(bytes);
			}
			
			bos.flush();
		} finally {
			if (bis!=null) {
				bis.close();
			}
			if (bos!=null) {
				bos.close();
			}
		}
		
		System.out.println("普通拷贝耗时：" + ((new Date().getTime()) - begin.getTime()) + "ms");
	}
}
