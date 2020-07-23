package com.leetcode;

public class PrintOneToN {

	public static void main(String[] args) {
		System.out.println(new PrintOneToN().printNumbers(3));
	}
	StringBuilder res;
    int count = 0, n,nine = 0,start;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // �����ַ�����
        num = new char[n]; // ���峤��Ϊ n ���ַ��б�
        start = n - 1;
        dfs(0); // ����ȫ���еݹ�
        res.deleteCharAt(res.length() - 1); // ɾ��������Ķ���
        return res.toString(); // ת��Ϊ�ַ���������
    }
    /**
     * ��0
     * @param x
     */
    void dfs_0(int x) {
        if(x == n) { // ��ֹ�������ѹ̶�������λ
            res.append(String.valueOf(num) + ","); // ƴ�� num ������� res β����ʹ�ö��Ÿ���
            return;
        }
        for(char i : loop) { // ���� ��0�� - ��9��
            num[x] = i; // �̶��� x λΪ i
            dfs(x + 1); // �����̶��� x + 1 λ
        }
    } 
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res.append(s + ",");
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    } 
}
