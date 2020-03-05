package com.suanfa4;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 双栈实现简单计算器
 * @author W.hy
 *
 */
public class CalcStack {

	public static void main(String[] args) {		
		// 操作符
		Stack<String> options = new Stack<String>();
		

		// 操作值
		Stack<Double> values = new Stack<Double>();
		String s = "";
		while (!StdIn.isEmpty()) {
			s = StdIn.readString();
			if (s.equals("(")) {
				
			}else if (s.equals("+")) {
				options.push(s);
			}else if (s.equals("-")) {
				options.push(s);
			}else if (s.equals("*")) {
				options.push(s);
			}else if (s.equals("/")) {
				options.push(s);
			}else if (s.equals("sqrt")) {
				options.push(s);
			}else if (s.equals(")")) {
				String op = options . pop();
				double v = values . pop();
				if (op . equals("+"))
				v = values.pop() + v;
				else if (op. equals("-"))
				v = values.pop() - v;
				else if (op. equals("*"))
				v = values.pop() * v;
				else if (op. equals("/")) v = values.pop() / v;
				else if (op.equals("sqrt")) v = Math. sqrt(v);
				values. push(v);

			}else {
				values.push(Double.parseDouble(s));
			}
			
		}
		StdOut.print(values.pop());
	}
}
