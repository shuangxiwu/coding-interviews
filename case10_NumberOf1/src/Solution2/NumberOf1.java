package Solution2;

import java.util.Scanner;

public class NumberOf1 {

	public static void main(String[] args) {
		// ��ȡ�������룬��ת��Ϊ����
		// Scanner sc = new Scanner(System.in);
		// String inputStr = sc.nextLine();
		// Integer num = Integer.valueOf(inputStr);
		int num = Integer.MAX_VALUE;
		num = Integer.MIN_VALUE;
		System.out.println(num);
		// ���Ʊ�־λ����num��λ����
		int flag = 1;
		int count = 0, times = 0;
		while (flag != 0) {
			if ((num & flag) != 0) {
				count++;
			}
			flag <<= 1;
			++times;
		}
		System.out.println(times);
		System.out.println(count);
	}

}
