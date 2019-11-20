package com.pub;
/**
 * 实现动态数组
 * ArrayList的底层实现就是数组，这么实现动态的--查看源码
 * @author JOINT
 */
public class AsyncList<E> {
	//数组元素个数
	private int size;
	// 数组默认长度
	private static final int DEFAULT_INIT_CAPACITY = 10;
	
	//元素数组
	private Object [] elementData;
	// 新建数组，不指定数组容量
	public AsyncList() {
		elementData = new Object[DEFAULT_INIT_CAPACITY];
	}
	// 创建并指定数组容量
	public AsyncList(int size) {
		elementData = new Object[size];
	}
	
	// 添加元素
	// 如果数组的容量已满，需要扩容。未满直接添加
	public void  add(E e) {
		if (size == elementData.length) {
			Object [] resetObjects = new Object [elementData.length * 3 / 2];
			// 复制填充数组
			/**
			 * 	第一个参数是要被复制的数组
				第二个参数是被复制的数组开始复制的下标
				第三个参数是目标数组，也就是要把数据放进来的数组
				第四个参数是从目标数据第几个下标开始放入数据
				第五个参数表示从被复制的数组中拿几个数值放到目标数组中
			 */
			System.arraycopy(elementData, 0, resetObjects,0,elementData.length);
			// 替换
			elementData = resetObjects;
		}
		// 添加元素
		elementData[size++] = e;
	}
	
	// 删除元素，直接移除指定下标的元素，对应的下标设为null
	public void remove(int  index) {
		int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,numMoved);
        elementData[--size] = null;
	}
	
	public  E  get(int index) {
		rangeCheck(index);
		return (E) elementData[index];
	}
	/**
	 * 检查下标
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(size <= index) {
			throw new IndexOutOfBoundsException("下标越界了，index:"+index);
		}
	}
	
	//修改元素
    public void modify(int index, E e) {
        //检查下标是否超出范围
        rangeCheck(index);
        elementData[index] = e;
    }
    
    
	public static void main(String[] args) {
		AsyncList<String> list = new AsyncList<>(5);
		for (int j = 0; j < 20; j++) {			
			list.add(j+"");
		}
		
		for (int i = 0; i < list.size; i++) {
			System.out.print("  "+list.get(i));
		}
		System.out.println();
		list.remove(21);
		for (int i = 0; i < list.size; i++) {
			System.out.print("  "+list.get(i));
		}
		
	}
}
