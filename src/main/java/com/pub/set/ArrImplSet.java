package com.pub.set;

/**
 * 数组实现set集合
 * @author JOINT
 *
 */
public class ArrImplSet<E>{

	private E arrElementE[];
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrImplSet() {
		arrElementE = (E[]) new Object[0];
	}
	
	public ArrImplSet(E [] arr) {
		arrElementE = arr;
		size = arrElementE.length;
	}
	/**
	 * 添加元素
	 * @param element
	 */
	public  void addElement(E element) {
		// 判断元素是否存在
		if (!contains(element)) {
			// 数组是否满了,需要扩容
			if (size == arrElementE.length) {
				incrementArray();
			}
			arrElementE[size ++] = element;
		}
	}
	/**
	 * 返回 集合长度
	 * @return
	 */
	public int size() {
		if (arrElementE != null) {
			return arrElementE.length;
		}else {
			return 0;
		}
	}
	/**
	 * 清空集合
	 */
	public void  clear() {
		arrElementE = null;
	}
	
	public  String toString() {
		if(arrElementE == null  || arrElementE.length == 0) {
			return "empty";
		}else {
			StringBuilder str = new StringBuilder("[");
			for (int i = 0; i < arrElementE.length; i++) {
				str.append(arrElementE[i]+ ",");
			}
			str.append("]");
			return str.toString();
		}
	}
	
	/**
	 * 数组扩容
	 */
	@SuppressWarnings("unchecked")
	private void incrementArray() {
		E [] tempArrEs = arrElementE;
		arrElementE = (E[]) new Object[size + 10 ];
		System.arraycopy(tempArrEs, 0, arrElementE, 0, size);
	}

	/**
	 * 判断元素是否存在，注意。Set 是可以保存null。
	 * @param el
	 * @return
	 */
	public boolean contains(E el) {
		if (null == el) {
			// 是否已存在null
			for (int i = 0; i < size; i++)			
				if (arrElementE[i] == null) 
					return true;
		}else {
			for (int i = 0; i < size; i++)
				if (arrElementE[i] == el) 
					return true;
		}
		// 都不存在，返回false
		return false;
	}
	/**
	 * 返回
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(size <= index) {
			throw new IndexOutOfBoundsException("下标越界了，index:"+index);
		}
		return arrElementE[index];
	}
	
	public static void main(String[] args) {
//		ArrImplSet<String> set = new ArrImplSet<String>();
//		set.addElement("abcdefg");
//		set.addElement("abcdefg");
//		set.addElement("abc5efg");
//		set.addElement("null");
//		System.out.println(set.toString());
		
		ArrImplSet<Integer> set = new ArrImplSet<Integer>();
		set.addElement(1);
		set.addElement(2);
		set.addElement(1);
		set.addElement(null);
//		System.out.println(set.toString());
		for (int i = 0; i < set.size; i++) {
			System.out.println(set.get(i));	
		}
		
	
	}

}
