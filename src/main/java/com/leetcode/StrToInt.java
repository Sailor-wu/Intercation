package com.leetcode;

/**
 * �ַ���תΪ����
 * 
 * @author W.hy дһ������ StrToInt��ʵ�ְ��ַ���ת��������������ܡ�����ʹ�� atoi �����������ƵĿ⺯����
 *         ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ��
 *         ������Ѱ�ҵ��ĵ�һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ���������������������Ϊ�������������ţ�
 *         �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�������
 *         ���ַ���������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����Щ�ַ����Ա����ԣ����Ƕ��ں�����Ӧ�����Ӱ�졣
 *         ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת����
 *         ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0��
 */
public class StrToInt {

	public static void main(String[] args) {
		String str = " ";
		int num = new StrToInt().strToInt(str);
		System.out.println("������" + num);
		str = " -342432432441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("������" + num);
		str = " 3-42sdf441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("������" + num);
		str = " -s342432432441232ddf";
		num = new StrToInt().strToInt(str);
		System.out.println("������" + num);
	}

	/**
	 * 1.���˵�ǰ�����ɸ��ո�(����еĻ�) 
	 * 2.�ж����š�����λ����������¼��״̬,��ʾ����ĸ�����
	 * 3.ѭ���жϺ�����ַ����Ƿ���0��9����������ۼ����ֵ 
	 * 4.��ǰ��ֵ�������С32λ�����ȽϿ� �Ƿ����
	 * �����������������214748364��ֱ�ӷ������ֵ 
	 * �����������������214748364�����ж����һλ�Ƿ����7
	 * ������Ǹ�������С��-214748364 |��ֱ�ӷ�����Сֵ 
	 * ������Ǹ���������-214748364. ���ж����-λ�Ƿ����8
	 * 5.ѭ��������,���ݸ��ŵı�־λ���ض�Ӧ����������
	 * @param str
	 * @return
	 */
	private int strToInt1(String str) {
		// �����ַ���ǰ��Ŀո�
		char[] array = str.toCharArray();			
		int i = 0, n = array.length,result = 0;
		
		boolean is_negative = false;// ������
		// i�±�С������ĳ��Ȳ����ǿո�
		while ( i < n&& array[i] == ' ') {
			++i;
		}
		// �Ƿ��ǿո�
		if (n == i) {
			return 0;
		}
		if (array[i]=='-') {
			is_negative=true;
		}
		// �Ƿ������������ִ���һ���±꿪ʼ
		if (array[i]=='-' || array[i]=='+') {
			++i;
		}
		
		// ѭ���ж��Ƿ� 0 �� 9 ����
		while (i< n && array[i] >='0' && array[i] <= '9') {
			//'0'��ASCII����48��'1'����49����ôһ���ʹӾͿ��Եõ�����������ֵ
			int tmp = str.charAt(i)-48;
			
			//�ж��Ƿ���� ���32λ����
			if(!is_negative &&(result>214748364 ||(result==214748364 && tmp>=7))) {
				return 2147483647;
			}
			//�ж��Ƿ�С�� ��С32λ����
			if(is_negative &&(-result<-214748364 || (-result==-214748364 && tmp>=8))) {
				return -2147483648;
			} 
			
			result = result*10+tmp;
			++i;
		}
		// �ж��Ƿ���
		if (is_negative) {
			return -result;
		}
		return result;
	}
	
	
	public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        // ����Ϊ0 ����0
        if(c.length == 0) {
        	return 0;
        }
        // ���ؽ��      ��� ϸС
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        // �Ƿ���
        if(c[0] == '-') {
        	sign = -1;
        }else if(c[0] != '+') {
        	i = 0;// �Ǹ���
        }
        for(int j = i; j < c.length; j++) {
        	// �� 0 �� 9 �˳������ؽ��
            if(c[j] < '0' || c[j] > '9') {
            	break;
            }
            // 0��9 ��װ���ж��Ƿ���integer�ڣ�-2^31 ��2^31 -1��
            if(res > bndry || res == bndry && c[j] > '7') {
            	return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // ����10 �Ӹ�λ��
            res = res * 10 + (c[j] - '0');
        }
        // ����
        return sign * res;
    } 
}
