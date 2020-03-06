package com.suanfa4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AssertKMP {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		assertKmp();
		
		String  string = "大苏打撒asdsa少i大苏打撒打算安定aasasa";
		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.charAt(i));
		}
	}

	private static void assertKmp() throws FileNotFoundException {
		// 查找的字符
		String paString = "中国的撒旦";
		String searchStr = "abcdabcsabg";
		File file = new File("src/main/java/com/suanfa4/source.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		try {
			byte [] buf = new byte [fileInputStream.available()];
			fileInputStream.read(buf);
			fileInputStream.close();
			searchStr = new String(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 源文本串
		KMP kmp = new KMP(paString);
		// 返回找到的下标
		int search = kmp.search(searchStr);
		System.out.println(search);
		if (search >=0) {			
			System.out.println(searchStr.substring(search, search+paString.length()));
		}
	}
}
