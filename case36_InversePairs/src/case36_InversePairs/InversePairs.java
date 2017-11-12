package case36_InversePairs;

/**
 * ��Ŀ���������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬��������������е�����Ե�������
 * 
 * @author WangSai
 *
 */
public class InversePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 4, 0 };
		System.out.println("traverseArray:" + traverseArray(arr));
		int[] arr2 = { 3, 2, 1, 4, 0 };
		System.out.println("myCount:" + myCount(arr2));
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");

		}
	}

	/**
	 * ����1����������ķ�ʽ
	 * 
	 * @param arr�������ҵ�����
	 * @return �����е�����Ե�����
	 */
	private static int traverseArray(int[] arr) {
		if (arr == null || arr.length <= 0)
			return -1;
		int len = arr.length;
		if (len == 1)
			return 0;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j])
					count++;
			}
		}
		return count;
	}

	/**
	 * ���ù鲢�ķ���ͳ���������
	 * 
	 * @param arr����ͳ�Ƶ�����
	 * @return �����е��������
	 */
	private static int myCount(int[] arr) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0) {
			return -1;
		}
		return myCountCore(arr, 0, arr.length - 1);
	}

	/**
	 * �ݹ�ͳ���������
	 * 
	 * @param arr,�����ҵ�����
	 * @param low����ǰ����������Ǳ�
	 * @param high����ǰ��������Ҳ�Ǳ�
	 * @return ���������Ҳ���������������������
	 */
	private static int myCountCore(int[] arr, int low, int high) {
		if (low >= high)
			return 0;
		int middle = (low + high) / 2;
		int left = myCountCore(arr, low, middle);
		int right = myCountCore(arr, middle + 1, high);
		int merge = mergeCount(arr, low, middle, high);
		return merge + left + right;
	}

	private static int mergeCount(int[] arr, int low, int middle, int high) {
		int copy[] = new int[arr.length];
		// ����߽Ǳ꿪ʼ�ϲ�
		int index = high;
		int endL = middle;
		int endR = high;
		int count = 0;
		// ͳ�������������飬���ϲ�
		while (endL >= low && endR >= middle + 1) {
			if (arr[endL] > arr[endR]) {
				count += endR - middle;
				copy[index--] = arr[endL--];

			} else
				copy[index--] = arr[endR--];
		}
		// �ϲ�ʣ�µ�����
		while (endL >= low) {
			copy[index--] = arr[endL--];
		}
		while (endR >= middle + 1) {
			copy[index--] = arr[endR--];
		}
		for (int i = low; i <= high; i++) {
			arr[i] = copy[i];
		}
		return count;
	}

}
