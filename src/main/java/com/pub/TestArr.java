package com.pub;

import java.lang.reflect.Field;

public class TestArr {


	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//		try {			
//			// 创建一个arrayList集合 ,初始长度给5个
//			ArrayList<Integer> list = new ArrayList<Integer>(5);
//			@SuppressWarnings("rawtypes")
//			Class<? extends List> clazz = list.getClass();
//			Field f = clazz.getDeclaredField("elementData");
//			f.setAccessible(true);
//			
//			//循环增加添加元素，同时通过反射得到elementData成员，
//			//并将每一次遍历的所得到的elementData数组长度添加到Set集合中（利用Set去重）
//			Set<Integer> addSet = new HashSet<>();
//			for (int i = 0; i < 100; i++) {
//				list.add(i);
//				Object[] objects = (Object[]) f.get(list);
//				addSet.add(objects.length);
//			}
//			//循环遍历Set，将Set元素转动到一个List中（因Set存储的元素无序，不方便查看）
//			List<Integer> addList = new ArrayList<>();
//			for (Integer i : addSet) {
//				addList.add(i);
//			}
//			
//			 //List排序并打印
//	        Collections.sort(addList);
//	        for (Integer i : addList) {
//	            System.out.print(i + " ");
//	        }
//	        System.out.println();
//	        //移除元素，查看elementData长度变化，思路同上
//	        Set<Integer> removeSet = new HashSet<>();
//	        for (int i = list.size() - 1; i >= 0; i--) {
//	            list.remove(i);
//	            Object[] objects = (Object[]) f.get(list);
//	            removeSet.add(objects.length);
//	        }
//	        List<Integer> removeList = new ArrayList<>();
//	        for (Integer i : removeSet) {
//	            removeList.add(i);
//	        }
//	        Collections.sort(removeList);
//	        for (Integer i : removeList) {
//	            System.out.print(i + " ");
//	        }
//	        System.out.println();
//	        
//	        int [] ar= {1,1,2,2,22};
//	        for (int i = 0; i < ar.length; i++) {
//				System.out.println(ar[i]);
//			}
//			
//		} catch (Exception e) {
			// TODO: handle exception
//		}
		
//		int  i = 1000;
//		int low = -128;
////		System.out.println(Math.max(i, 127));
//		System.out.println(Integer.MAX_VALUE - (-low) -1);
//		int h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
//		System.out.println(h);
		
//		Integer a = 100,b = 100, c = 120 , d = 120 , e = 130 ,f = 130;
//		System.out.println(a== b);
//		System.out.println(c == d);
//		
//		System.out.println(e == f);
		
		
		 Class cache = Integer.class.getDeclaredClasses()[0]; //1
	      Field myCache = cache.getDeclaredField("cache"); //2
	      myCache.setAccessible(true);//3
	      Integer[] newCache = (Integer[]) myCache.get(cache); //4
	      newCache[132] = newCache[133]; //5
//	      
	      int a = 2;
	      int b = a + a;
	      System.out.printf("%d + %d = %d", a, a, b); //
		
	}

}
