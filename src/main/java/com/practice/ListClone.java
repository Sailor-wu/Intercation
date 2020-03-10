package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListClone {

	public static void main(String[] args) {
//		cloneArray();
		int a = 1;
		System.out.println(a/2.0);
		System.out.println(a/20.00);
//		System.out.println(a/2);
//		System.out.println(a>>1);
//		
//		System.out.println(-2>>1);
//		System.out.println(-2>>>1);
//		Integer aInteger = 0;
//		aInteger.toString();
		
		
	}

	private static void cloneArray() {
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		for (int i = 0; i < 3000; i++) {
			list.add(ThreadLocalRandom.current().nextInt(1000)+"");
		}
		for (int i = 0; i < 1000; i++) {
			list1.add(ThreadLocalRandom.current().nextInt(10)+"");
		}
//		System.out.println("List之前：");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print("\t"+list.get(i));
//		}
//		System.out.println("\nList1之前：");
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.print("\t"+list1.get(i));
//		}
		long startTime = System.currentTimeMillis()/1000;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				System.out.print("a");
			}
			System.out.print("a");
		}
		System.out.println();
		System.out.println("\n外大内小："+((System.currentTimeMillis()/1000)-startTime));
		ArrayList<String> tempList = new ArrayList<String>();
		
		changeList(list, list1, tempList);
		
//		System.out.println("List之前：");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print("\t"+list.get(i));
//		}
//		System.out.println("\nList1之前：");
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.print("\t"+list1.get(i));
//		}
		startTime = System.currentTimeMillis()/1000;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				System.out.print("b");
			}
			System.out.print("b");
		}
		System.out.println();
		System.out.println("\n外小内大："+((System.currentTimeMillis()/1000)-startTime));
	}

	private static void changeList(List<String> list, List<String> list1, ArrayList<String> tempList) {
		tempList.addAll(list1);
		list1.clear();
		list1.addAll(list);
		list.clear();
		list.addAll(tempList);
	}
}
