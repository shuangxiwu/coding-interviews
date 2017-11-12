package case41_2ContinuesSquenceWithSum;

/**
 * ��Ŀ2������һ������s,��ӡ�����к�Ϊs�������������У����ٺ����������֣�����������15������1+2+3+4+5=4+5+6=7+8=15��
 * ���Դ�ӡ��3����������1~5,4~6,7~8��
 * 
 * @author WangSai
 *
 */
public class ContinuesSquenceWithSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 15;
		findMySquence(sum);
	}

	/**
	 * 
	 * @param sum������sum
	 */
	private static void findMySquence(int sum) {
		// �쳣ֵ���
		if (sum < 3)
			return;
		int small = 1;
		int big = 2;
		int currentSum = small + big;
		int middle = (1 + sum) / 2;
		// ��ȡ���ں�����Ϊ�����ܳ���7+7=14���������
		while (small < middle) {
			while (currentSum < sum) {
				big++;
				currentSum += big;
			}
			while (currentSum > sum) {
				currentSum -= small;
				small++;
			}
			if (currentSum == sum) {
				myprint(small, big);
				currentSum -= small;
				small++;
			}
		}
	}

	private static void myprint(int small, int big) {
		for (int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
