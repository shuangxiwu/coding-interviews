package case29_MoreThanHalfNum;

/**
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г���5�Σ��������鳤�ȵ�һ�룬һ�����2���쳣��������������ʱ���-1
 * 
 * @author WangSai
 *
 */

public class MoreThanHalfNum {
	/**
	 * @param ���������
	 *            array[]
	 * @return ��������������
	 */
	public static void main(String[] args) {
		int[] arr0 = { 1, 3, 3 };
		int[] arr1 = {};
		System.out.println(MoreThanHalf1(arr0));
		System.out.println(MoreThanHalf1(arr1));
	}

	// ����Partition������O(n)�㷨
	private static int MoreThanHalf1(int[] arr) {
		// ����쳣���
		if ((arr == null) || (arr.length < 1))
			throw new RuntimeException("�����������Ч...");
		// ���������м�����
		int middle = arr.length >> 1;
		// ͨ��partition������ֵ��������
		int low = 0;
		int high = arr.length - 1;
		int index = partition(arr, low, high);
		while (index != middle) {
			if (index < middle) {
				low = index + 1;
				index = partition(arr, low, high);
			} else {
				high = index - 1;
				index = partition(arr, low, high);
			}
		}
		int result = arr[index];
		// �������ֳ��ִ����Ƿ񳬹�һ��,���������Żظ����֣����򣬱���
		result = checkMoreThanHalf(arr, result);
		return result;
	}

	// ���ĳ�����ڶ�Ӧ�������г��ִ����Ƿ񳬹�һ��
	private static int checkMoreThanHalf(int[] arr, int result) {
		int times = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == result)
				times++;
		}
		if (times * 2 > arr.length)
			return result;
		else
			throw new RuntimeException("�����������Ч...");
	}

	// Partitionѡ��һ������ͨ��һ��������ʹ�ø������������ֶ�����С���Ҳ����ֱ���Ҫ�󡣷��ظ��������ڵ�λ�á�
	private static int partition(int[] arr, int low, int high) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= pivotKey)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] <= pivotKey)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}
}
