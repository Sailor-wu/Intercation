package com;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ViewTest {

	
	public static void main(String[] args) {
//		float a = (float) 3.4;
//		System.out.println(a);
		int a = 10;
		float b = 11;
		HashMap hashMap;
		Hashtable hashtable;
		a+=b;
		
		int num  = new ViewTest().tryCase();
		System.out.println(num);
	}
	
	
	private int tryCase() {
		try {
			System.out.println("执行try.");
			int a  = 2/0;
			return 1;
		} catch (Exception e) {
			System.out.println("执行catch。");
			return 2;
		}finally {
			System.out.println("执行finally.");
		}
	}


	public static void main1(String[] args) {
//		System.out.println(Math.round(-1.5));
		
		// 使用异或位移法
//		String string ="hello";
//		System.out.println( extracted(string));
//		String [] aaStrings = {"abcs","asdsad","saddd"};
//		List<String> asList = Arrays.asList(aaStrings);
//		for (int i = 0; i < aaStrings.length; i++) {
//			System.out.println(aaStrings[i]);
//		}
//		System.out.println("---------------");
//		String [] array = (String[]) asList.toArray();
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}
//		char [] value = {'h','e','l','l','o',',','w','o','r','d','!'}; 
		char [] value = {'a','b','c','d'};
		 for (int i = 0; i < value.length; i++) {
				System.out.print(value[i]);
			}
		 System.out.println("\n----");
        int n = value.length - 1;
        System.out.println("--"+( (n-1) >> 1));
//        for (int j = (n-1) >> 1; j >= 0; j--) {
//            int k = n - j;
//            char cj = value[j];
//            char ck = value[k];
//            value[j] = ck;
//            value[k] = cj;
//        }
        char name = '名';
        for (int j = (n-1) >> 1; j >= 0; j--) {
			int k = n - j;
			char cj = value[j];
			char ck = value[k];
			value[j] = ck;
			value[k] = cj;
		}
        for (int i = 0; i < value.length; i++) {
			System.out.print(value[i]);
		}
	}

	/**
	 * 字符串反转，使用位移方式
	 * @param string
	 * @return
	 */
	private static String extracted(String string) {
		if(string==null||string.length()==0)return string;
        char [] array =string.toCharArray();
        int length = string.length()-1;
        for(int i =0;i<length;i++,length--){
            array[i]^=array[length];
            array[length]^=array[i];
            array[i]^=array[length];
        }
        return new String(array);
        
	}
}
