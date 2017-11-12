package case41_1TwoNumbersWithSum;

/**
 * ��Ŀ1:����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s,��� ����һ�Լ��ɡ�
 * ������������{1,2,4,7,11,15}������15.����4+11=15��һ�����4+11��
 * 
 * @author WangSai
 *
 */
public class TwoNumbersWithSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 7, 11, 15 };
		int s = 14;
		int[] result = new int[2];
		System.out.println(findMyNumbers(arr, s, result));
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	/**
	 * 
	 * @param arr,�������������
	 * @param s�������д��������ֵĺ�
	 * @param result�����������������������ֵ�����
	 * @return arr���Ƿ����������������������
	 */
	private static boolean findMyNumbers(int[] arr, int s, int[] result) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// �����������������Ǳ���Ҳ�Ǳ�
		int left = 0;
		int right = arr.length - 1;
		boolean Found = false;
		// �ݴ��ҵ�����������
		while (left < right) {
			int temp = arr[left] + arr[right];
			// ��arr[left]+arr[right]��ֵ����s����ȡarr[right-1]
			if (temp > s)
				right--;
			// ��arr[left]+arr[right]��ֵ����s����ȡarr[right-1]
			else if (temp < s)
				left++;
			// ��arr[left]+arr[right]��ֵ����s������arr[left]��arr[right]
			else {
				result[0] = arr[left];
				result[1] = arr[right];
				Found = true;
				left++;
			}
		}
		return Found;
	}
}
