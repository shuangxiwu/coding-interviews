package case09_Fibonacci;

/**
 * ��Ŀ��дһ������������n����쳲��������еĵ�n�
 * 
 * @author WangSai
 *
 */

public class Fibonacci {

	// 쳲��������ж���
	// f(n)= |- =0��n=0
	//       |- =1��n=1
	//       |- =f(n-1)+f(n-2),n>=2
	public static void main(String[] args) {
		long temp = Fib1(10);
		System.out.println(temp);
		long temp2 = Fib2(10);
		System.out.println(temp2);

	}

	// ���õݹ�ķ�ʽ���쳲��������еļ���,�����n��
	private static long Fib1(int n) {
		int[] results = { 0, 1 };
		if (n < 2)
			return results[n];
		return Fib1(n - 1) + Fib1(n - 2);
	}

	// ���õ�����ʽ���쳲��������еļ��㣬�����n��
	private static long Fib2(int n) {
		int[] results = { 0, 1 };
		if (n < 2)
			return results[n];
		int FIB1 = 0;
		int FIB2 = 1;
		int FIBN = 0;
		for (int i = 2; i <= n; i++) {
			FIBN = FIB1 + FIB2;
			FIB1 = FIB2;
			FIB2 = FIBN;
		}
		return FIBN;
	}

	// ���õ����ķ�ʽ�������n���Fib2�����Ż���ʡȥFIBN����
	private long Fib3(int n) {
		if (n < 0)
			return 0;
		long num1 = 0;
		long num2 = 1;
		for (int j = 1; j <= n; j++) {	//	��1��ʼ
			num1 = num1 + num2;
			num2 = num1 - num2;
		}
		return num1;
	}
}
