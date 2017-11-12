package case32_NumOf1Between1AndN;

/**
 * ��ĿҪ��
 * 
 * ����һ������n����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12,��1��12��Щ���� �а���1��������1,10,11,12,1 һ��������5�Ρ�
 * 
 * @author WangSai
 *
 */
public class NumOf1Between1AndN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 999000900;
		System.out.println("solution1:");
		long time1 = System.currentTimeMillis();
		int m = getNumOf1From1ToN_solution2(n);
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(m);
		System.out.println("solution2:");

		long time3 = System.currentTimeMillis();
		int p = getNumOf1From1ToN_solution1(n);
		long time4 = System.currentTimeMillis();
		System.out.println(time4 - time3);
		System.out.println(p);
	}

	/**
	 * ����1����1��n�У�ͳ��ÿ��������1���ֵĴ�����Ȼ�󣬰����еĴ����ۼ�������ʱ�临�Ӷ�O(nlogn)
	 * 
	 * @param n�����һ������n
	 * @return 1���ֵ��ܴ���
	 */
	public static int getNumOf1From1ToN_solution1(int n) {
		// �쳣ֵ���
		if (n < 1)
			return -1;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += getNumOf1Ofn(i);
		}
		return sum;
	}

	/**
	 * ͳ��i��1���ֵĴ���
	 * 
	 * @param i����ͳ�Ƶ�����
	 * @return 1��i�г��ֵĴ���
	 */
	private static int getNumOf1Ofn(int i) {
		int count = 0;
		while (i > 0) {
			if (i % 10 == 1)
				count++;
			i /= 10;
		}
		return count;
	}

	/**
	 * ����2������n��Ϊ��λ������λ��[round-weight-former]���÷�����ʱ���㷨���Ӷ�ΪO(logn)
	 * 
	 * @param n
	 * @return
	 */
	public static int getNumOf1From1ToN_solution2(int n) {
		// �쳣ֵ���
		if (n < 1)
			return 0;
		// ��n��Ϊ��λ������λ
		int round = n;
		int count = 0;
		int base = 1;
		while (round > 0) {
			// ȡ�࣬��ȡweight
			int weight = round % 10;
			// ��ȡround
			round /= 10;
			// ��weightΪ0
			count += round * base;
			// �ж�weight��ֵ��������1�������former��ֵ���ټ�1
			if (weight == 1) {
				count += n % base + 1;
			}
			// ��weight>1�������base
			else if (weight > 1) {
				count += base;
			}
			// ��������10�����λ�ƶ�һλ
			base *= 10;
		}
		return count;
	}
}
