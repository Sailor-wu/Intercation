package com.suanfa4;

import java.util.Scanner;

import org.apache.commons.lang3.builder.StandardToStringStyle;

/**
 * log
 * 
 * @author W.hy
 */
public class Practice1_1_21 {
	
	public static void main(String[] args) {
		runApp();
	}

	private static void runApp() {
		System.out.println("请按照格式输入科目(语数英)期中和期末考试成绩 (科目-82-92)：");
		Scanner inScanner = new Scanner(System.in);
		String [] strArr = new String [3];
		int i =0;
		while (i < 3) {
			System.out.print("请输入第"+(i+1)+"科目和分数：");
			strArr[i] = inScanner.nextLine();
			i++;
		}
		System.out.println("科目：    \t器中：    \t期末：    \t平均分：    \t");
		for (int j = 0; j < strArr.length; j++) {
			String[] split = strArr[j].split("-");
//			System.out.println(split[0]+"\t"+split[1]+"\t"+split[2]+"\t"+
//			(Integer.valueOf(split[1])+Integer.valueOf(split[2]))/2.0);
			System.out.printf("%s\t %d\t  %d \t %.3f \n",split[0],Integer.valueOf(split[1]),Integer.valueOf(split[2]),(Integer.valueOf(split[1])+Integer.valueOf(split[2]))/2.0);
		}
	}
}
