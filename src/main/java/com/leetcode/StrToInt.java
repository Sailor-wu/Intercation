package com.leetcode;

/**
 * 字符串转为整数
 * 
 * @author W.hy 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *         首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *         当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 *         假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *         该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *         注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *         在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
public class StrToInt {

	public static void main(String[] args) {
		String str = " ";
		int num = new StrToInt().strToInt(str);
		System.out.println("整数：" + num);
		str = " -342432432441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("整数：" + num);
		str = " 3-42sdf441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("整数：" + num);
		str = " -s342432432441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("整数：" + num);
	}

	/**
	 * 1.过滤掉前面若干个空格(如果有的话) 
	 * 2.判断正号、负号位，如果题则记录下状态,表示输入的负数。
	 * 3.循环判断后面的字符串是否是0到9，如果是则累加这个值 
	 * 4.当前的值跟最大、最小32位整数比较看 是否溢出
	 * ●如果是正数，肽于214748364，直接返回最大值 
	 * ●如果是正数，盯于214748364，再判断最后一位是否大于7
	 * ●如果是负数，且小于-214748364 |，直接返回最小值 
	 * ●如果是负数，簿于-214748364. 再判断最后-位是否大于8
	 * 5.循环结束后,根据负号的标志位返回对应的正数或负数
	 * @param str
	 * @return
	 */
	private int strToInt1(String str) {
		// 过滤字符串前面的空格
		char[] array = str.toCharArray();			
		int i = 0, n = array.length,result = 0;
		
		boolean is_negative = false;// 正负数
		// i下标小于数组的长度并且是空格
		while ( i < n&& array[i] == ' ') {
			++i;
		}
		// 是否都是空格
		if (n == i) {
			return 0;
		}
		if (array[i]=='-') {
			is_negative=true;
		}
		// 是否是正负，数字从下一个下标开始
		if (array[i]=='-' || array[i]=='+') {
			++i;
		}
		
		// 循环判断是否 0 到 9 数字
		while (i< n && array[i] >='0' && array[i] <= '9') {
			//'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
			int tmp = str.charAt(i)-48;
			
			//判断是否大于 最大32位整数
			if(!is_negative &&(result>214748364 ||(result==214748364 && tmp>=7))) {
				return 2147483647;
			}
			//判断是否小于 最小32位整数
			if(is_negative &&(-result<-214748364 || (-result==-214748364 && tmp>=8))) {
				return -2147483648;
			} 
			
			result = result*10+tmp;
			++i;
		}
		// 判断是否负数
		if (is_negative) {
			return -result;
		}
		return result;
	}
	
	
	public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        // 长度为0 返回0
        if(c.length == 0) {
        	return 0;
        }
        // 返回结果      最大 细小
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        // 是否负数
        if(c[0] == '-') {
        	sign = -1;
        }else if(c[0] != '+') {
        	i = 0;// 非负数
        }
        for(int j = i; j < c.length; j++) {
        	// 非 0 到 9 退出，返回结果
            if(c[j] < '0' || c[j] > '9') {
            	break;
            }
            // 0到9 封装。判断是否是integer在（-2^31 ，2^31 -1）
            if(res > bndry || res == bndry && c[j] > '7') {
            	return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 乘以10 加个位数
            res = res * 10 + (c[j] - '0');
        }
        // 返回
        return sign * res;
    } 
}
