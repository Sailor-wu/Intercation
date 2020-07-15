package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 找旅行终点
 * @author W.hy
 *
 */
public class FindFinalyNode {

	static List<List<String>> paths = new LinkedList<List<String>>();
	static String arr1 [] = new String []{"London","New York"};
	static String arr2 [] = new String []{"New York","Lima"};
	static String arr3 [] = new String []{"Lima","Sao Paulo"};
	static String arr4 [] = new String []{"Sao Paulo","beiJing"};
	static String arr5 [] = new String []{"beiJing","guangzhou"};
	 
	
	public static void main(String[] args) {
		paths.add(Arrays.asList(arr1));
		paths.add(Arrays.asList(arr2));
		paths.add(Arrays.asList(arr3));
		paths.add(Arrays.asList(arr4));
		paths.add(Arrays.asList(arr5));
		String find = new FindFinalyNode().find1();
		System.out.println( find);
	}

	private String find1() {
		StringBuilder midWay = new StringBuilder("途经：");
		Set<String> set= new HashSet<>();
        for (List<String> l: paths) {
        	set.add(l.get(1));
        	midWay.append(l.get(1)+"-->");
        }
        
        for (List<String> l: paths) set.remove(l.get(0));
        String str = midWay.toString();
		if (str.endsWith("-->")) {
			str=str.substring(0, str.lastIndexOf("-->"));
		}
        return str+"\t 终点："+set.iterator().next();
	}

	private String find() {
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		for (List<String> string : paths) {
			map.put(string.get(0), string.get(1));
		} 
		String startString = paths.get(0).get(0);
		StringBuilder midWay = new StringBuilder("途经：");
 		while (startString!=null) {
 			midWay.append(startString+"-->");
			if (!map.containsKey(startString)) {
				String str = midWay.toString();
				if (str.endsWith("-->")) {
					str=str.substring(0, str.lastIndexOf("-->"));
				}
				return str+"\t终点："+startString;
			}
			startString = map.get(startString);
		}
		return "";
		
	}
}
