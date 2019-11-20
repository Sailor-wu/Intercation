package com.pub.link;

public interface Stack<Item> {
	/**
	 * 入栈
	 * @param item
	 */
	void push(Item item);
	/**
	 * remove 
	 * @return
	 */
	Item pop();
	
	boolean  isEmpty();
	
	int size();
}
