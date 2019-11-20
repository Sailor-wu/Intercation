package com.pub.link;

import java.util.Iterator;
/**
 * 实现自定义栈 和迭代接口
 * 迭代接口在内部类实现
 * @author JOINT
 *
 * @param <Item>
 */
public class LinkListStatck<Item> implements Stack<Item>,Iterable<Item>{

	// 栈顶元素
	private Node first;
	// 栈数量
	private int size;
	
	
	/**向栈顶增加元素，即在链表的头插入节点*
	 */
	@Override
	public void push(Item item) {
		Node oldFirst=first;

        first=new Node();
        first.item=item;
        first.next=oldFirst;
        // 数量增加
        size++;
	}

	/**
	 * 从栈顶移除元素，即在链表的头移除节点
	 */
	@Override
	public Item pop() {
		// 拿到头节点
		Item item = first.item;
		first = first.next;
		// 减少元素数量
		size --;
		return item;
	}
	
	/**
	 * 判断栈元素数量 是否等于 0
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	/**定义链表节点*/ 
	public class Node{
		Item item;
		Node next;
	}

	// 使用内部类迭代
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkListIterator();
	}
	
	/**
     * 支持迭代方法，实现在内部类里
     */
    private class LinkListIterator implements Iterator<Item> {

    	private Node currentNode = first;
    	
		@Override
		public boolean hasNext() {
			// 当前迭代对象是否是空
			return currentNode != null;
		}

		// 迭代 获取当前元素
		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
    	
    }
    
    public static void main(String[] args) {
    	// 测试先进后出
		Stack<String> stacks = new LinkListStatck<String>();
		stacks.push("abcd");
		stacks.push("fhhd");
		stacks.push("gjjd");
		
		for (String string : (LinkListStatck<String>)stacks) {
			System.out.println(string);
		}
		System.out.println(stacks.size());
		// 出
		String pop = stacks.pop();
		System.out.println(pop);
		System.out.println(stacks.size());
		for (String string : (LinkListStatck<String>)stacks) {
			System.out.println(string);
		}
	}
}
