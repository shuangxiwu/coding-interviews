package case12_Print1ToMaxOfNDigits;

/**
 * ��Ŀ������n����˳���ӡ����1������nλʮ����������������3�����ӡ��1,2,3һֱ������3λ��999��
 * 
 * @author WangSai
 *
 */
public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// myPrint1ToMax1(1);
		System.out.println();
		myPrint1ToMax2(1);
	}

	/**
	 * ����1���������ֵ�ȫ���н��
	 * 
	 * @param n������������n
	 */
	// ��Ϊ���ǵ��������⣬���������ֵ�ȫ������ɣ���������ɫ�ӳ��ֵ����п��ܵĽ����
	private static void myPrint1ToMax1(int n) {
		// �쳣ֵ
		if (n <= 0)
			return;
		String str = "";
		mySeq(str, n);
	}

	/**
	 * ����1���������ֵ�ȫ���н��
	 * 
	 * @param str���ϴα����ǰ�������ֵ�һ������
	 * @param n��ʣ��δ���е���������
	 */
	private static void mySeq(String str, int n) {
		if (n <= 0) {
			myPrint(str);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			mySeq(str + "" + i, n - 1);
		}
	}

	/**
	 * ��ӡstr��ʾ�����֣���ǰ����0�򲻴�ӡ����ӡ�ӵ�һ����0�������������
	 * 
	 * @param str������ӡ���ַ���
	 */
	private static void myPrint(String str) {
		int len = str.length();
		int i = 0;
		// Ѱ�ҵ�һ����0���ֵĽǱ�
		for (i = 0; i < len; i++) {
			if (str.charAt(i) != '0')
				break;
		}
		// ��ӡ��һ����0���ּ�ʣ�µ�λ
		for (int j = i; j < len; j++) {
			System.out.print(str.charAt(j));
		}
		// ��������˵���������з���Ԫ�أ�������Ҫ����
		if (i < str.length()) {
			System.out.println();
		}
	}

	/**
	 * ����2����������ģ��ÿһ��λ�õ����֣�����ÿһ��λ�õ�������0~9֮�䣬����������ֵ
	 * 
	 * @param num,������λ��
	 */
	private static void myPrint1ToMax2(int num) {
		if (num <= 0)
			return;
		// �������������������г�ʼ��������������ʾƴ��֮������ֵ����λ���Ҳ�Ϊ���λ��
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}

		while (addOne(arr) == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}

	/**
	 * ��������ģ�����ֵļӷ�����λ
	 * 
	 * @param arr
	 */
	public static int addOne(int[] arr) {
		// ����ֵ ��λֵ
		int carry = 1;
		// ���λ��λ�õĺ�һλ
		int index = arr.length;
		do {
			// ��һλ��λ��
			index--;
			// ����λ�õ�ֵ���Ͻ�λ��ֵ
			arr[index] += carry;
			// ��λֵ
			carry = arr[index] / 10;
			// ����λ�õ�ֵ
			arr[index] %= 10;
			// �н�λ����δ�������λʱ������ѭ������һ��λ�õ�ֵ
		} while (carry != 0 && index > 0);
		// �������λ���������λ�н�λλ
		if (carry > 0 && index == 0)
			return 1;
		// û�е������λ
		return 0;
	}
}
