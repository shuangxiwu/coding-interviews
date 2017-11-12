package case30_GetLeastNum;

/**
 * ��Ŀ������n���������ҳ�������С��k��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4
 * ����������partition�������,��������˼·�������Ƶġ�������Ҫ�޸���������飬��Ϊ����Partition��������������ֵ�˳��
 * 
 * 
 * @author WangSai
 *
 */
public class GetLeastNum1 {
	/**
	 * 
	 * @param arr[]
	 *            ��Ҫ��Ѱ�ҵ�����
	 * @return Ѱ�ҳ�������������k������
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 4, 4, 7, 3, 8 };
		int k = 4;
		getNumbers(arr, k);
	}

	// ͨ��partition��������ȡarrOut����
	private static void getNumbers(int[] arr, int k) {
		// �쳣ֵ�ж�
		if (arr == null || arr.length < k || arr.length <= 0 || k <= 0)
			throw new IllegalArgumentException("���������Ƿ�...");
		// ���õݹ�ķ�ʽ���
		int low = 0;
		int high = arr.length - 1;
		int index = partition(arr, low, high);
		while (index != k - 1) {
			if (index < k - 1) {
				low = index + 1;
				index = partition(arr, low, high);
			} else {
				high = index - 1;
				index = partition(arr, low, high);
			}
		}
		// ���������������
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
	}

	// �������õ���partition����
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
