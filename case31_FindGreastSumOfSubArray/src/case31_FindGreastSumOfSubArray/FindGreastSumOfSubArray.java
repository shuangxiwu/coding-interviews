package case31_FindGreastSumOfSubArray;

import java.util.ArrayList;

/**
 * ��Ŀ������һ���������飬������������Ҳ�и�����������һ���������Ķ���������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(N)��
 * 
 * @author WangSai
 *
 */
public class FindGreastSumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println("getMyGreatSum1(arr):  " + getMyGreatSum1(arr));
		System.out.println("getMyGreatSum2(arr):  " + getMyGreatSum2(arr));
	}

	/**
	 * ����1��ͨ��������ͷ��ʼ�ۼӡ�
	 * 
	 * @param arr��Ҫ�����������
	 * @return ���������ĺ�
	 */
	private static int getMyGreatSum1(int[] arr) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ������������¼��...");
		// ��������������currentSum���浱ǰ������ĺ͡�maxSum��������������ĺ͡������������������ԣ�currentSum��maxSum��Сֵ�������0
		int currentSum = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		// �ֱ𱣴��������������Ǳ�
		int low = 0;
		int high = 0;

		for (int i = 0; i < arr.length; i++) {
			// ��arr[i]֮ǰԪ�ص�������ĺ�С�ڵ���0��˵��֮ǰ��������ĺͼ���arr[i]���� ���� ��arr[i]��ʼ�����������ĺ͡�
			// ����֮ǰ�������飬�ӵ�ǰԪ�ؿ�ʼ����
			// low�ǿ�ʼ�Ǳ�
			if (currentSum <= 0) {
				currentSum = arr[i];
				low = i;
			} else
				currentSum += arr[i];
			// ��ȡ����������ĺ͡�����������ĽǱ�
			if (currentSum > maxSum) {
				maxSum = currentSum;
				high = i;
			}
		}
		System.out.print("����������Ϊ��      ");
		for (int i = low; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return maxSum;

	}

	/**
	 * ����2����̬�滮�ķ���ʵ��
	 * 
	 * @param arr,Ҫ�����������
	 * @return ���������ĺ�
	 */
	private static int getMyGreatSum2(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ������������¼��...");
		ArrayList<Integer> list = new ArrayList<>();
		int currentSum = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				list.add(arr[i]);
			} else if (currentSum <= 0) {
				list.add(arr[i]);
				currentSum = arr[i];
			} else if (currentSum > 0) {
				currentSum += arr[i];
				list.add(Math.max(currentSum, arr[i]));
			}
		}
		maxSum = list.get(0);
		for (int i : list) {
			if (i > maxSum)
				maxSum = i;
		}
		return maxSum;
	}
}
