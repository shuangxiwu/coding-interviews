package case43_DicesProbability;

import java.util.HashMap;

/**
 * @author WangSai
 *
 */
public class DicesProbability {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 2;
		System.out.println("-------printSumProbability1(" + num + ")--------------:");
		printSumProbability1(num);
		System.out.println("-------printSumProbability2(" + num + ")--------------:");
		printSumProbability2(num);
	}

	/**
	 * ����1�� �ݹ���ã���ǰɫ�Ӽ���֮ǰ����ɫ�ӵ�sum�ĺ͡������һ��ɫ�ӵ�ֵ��Ȼ���ٵݹ���һ����ֵ������͡�һֱ�����һ��ɫ��
	 * 
	 * @param num��ɫ������
	 */
	private static void printSumProbability1(int num) {
		if (num <= 0)
			return;
		int theSum = 0;
		// ���󵽵ĺͱ��浽HashMap���棬���ǵ�����ֵ�ǳ��ֵĴ�����
		HashMap<Integer, Integer> hs = new HashMap<>();
		// �ݹ������һ�����ܳ��ֵ����
		myProbability2(theSum, num, hs);
		// ������п��ܳ��ֵ����������
		double allKinds = 1.0;
		for (int i = 1; i <= num; i++) {
			allKinds = allKinds * 6;
		}
		// ������ֿ���ֵ�ø���
		for (Integer sum : hs.keySet()) {
			// System.out.println(sum);
			int times = hs.get(sum);
			double ratio = times / allKinds;
			System.out.println("sum=" + sum + '\t' + ",times: " + times + '\t' + ratio);
		}
	}

	/**
	 * 
	 * @param theSum,��1������ǰɫ�ӵ�ǰ1��ɫ�ӵĺͣ�δ������ǰɫ��
	 * @param num,ʣ��δ���ɫ�ӵĸ���
	 * @param hs,���󵽵ĺͱ��浽HashMap���棬���ǵ�����ֵ�ǳ��ֵĴ�����
	 */
	private static void myProbability2(int theSum, int num, HashMap<Integer, Integer> hs) {
		// �ݹ���ֹ����,�����󵽵ĺͼ��뵽
		if (num <= 0) {
			// ͳ�Ƶ�ǰ�ͳ��ֵ����
			if (!hs.containsKey(theSum)) {
				hs.put(theSum, 1);
			} else {
				hs.put(theSum, hs.get(theSum) + 1);
			}
			return;
		}
		// ��ǰɫ�ӵĿ��ܳ��ֵ����֣�����֮ǰ��ɫ�ӵĺ����
		// ���ﵹ���ڶ���ɫ��
		else if (num >= 1) {
			for (int i = 1; i <= 6; i++) {
				// ���
				// theSum += i;
				// �ݹ������һ�����ܳ��ֵ����
				myProbability2(theSum + i, num - 1, hs);

			}
		}
	}

	/**
	 * ����2���õ����ķ���ʵ�֡�����������ʵ�֣������СΪnum*6+1,����Ǳ�Ϊ�Ѿ����ֹ���ɫ�ӵĺͣ����������Ϊ����Ǳ�
	 * ��Ӧ�����ֳ��ֵĴ�������һ��ѭ���У� ��һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ���������һѭ���У����Ǽ���һ���µ����ӣ���ʱ��Ϊn
	 * �����ӳ��ֵĴ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1 ��n-2 ��n-3 ��n-4, n-5 ��n-6
	 * �Ĵ������ܺͣ��������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧ�ĵ�n-1 ��n-2 ��n-3 ��n-4��n-5��n-6֮�͡�
	 * 
	 * @param num��ɫ������
	 */
	private static void printSumProbability2(int num) {
		// �쳣ֵ���
		if (num <= 0)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// ������������,����ʼ����
		int[][] arr = new int[2][num * 6 + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
			}
		}
		// �����־λ��������������һ������
		int flag = 0;
		// ֻ����һ��ɫ�ӵ�ʱ��
		for (int i = 1; i <= 6; i++) {
			// ������a
			arr[flag][i] = 1;
		}
		// ���ֵ���k��ɫ�ӵ����,����һ�����鱣��b
		for (int k = 2; k <= num; k++) {
			// С��k��ֵ, ���ִ���Ϊ0
			for (int j = 0; j <= k - 1; j++)
				arr[1 - flag][j] = 0;
			// ��k��ɫ���к�Ϊsum���ֵĴ���Ϊ��
			// ��ǰk-1��ɫ���к�ֵΪsun-1,sum-2,sum-2,sum-3,sum-4,sum-5,sum-6���ִ����ĺ�
			for (int sum = k; sum <= 6 * k; sum++) {
				for (int y = 1; y <= 6; y++) {
					if (sum - y >= 0)
						arr[1 - flag][sum] += arr[flag][sum - y];
				}
			}
			// ��־λȡ������ʼʹ����һ�����顣
			flag = 1 - flag;
		}
		// �������к͵����
		double totalKinds = 1;
		for (int i = 1; i <= num; i++) {
			totalKinds *= 6;
		}
		System.out.println(totalKinds);
		// ��������������е����
		for (int i = 0; i < arr[flag].length; i++) {
			if (arr[flag][i] > 0) {
				double ratio = arr[flag][i] / totalKinds;
				System.out.println("sum=" + i + '\t' + ",times: " + arr[flag][i] + '\t' + ratio);
			}
		}
	}

}