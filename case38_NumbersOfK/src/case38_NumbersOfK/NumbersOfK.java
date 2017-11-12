package case38_NumbersOfK;

/**
 * ��Ŀ��ͳ��һ�����������������г��ֵĴ���������������������{1,2,3,3,3,3,4,5}������3������3����������г�����4�Σ�������4��
 * 
 * @author WangSai
 *
 */
public class NumbersOfK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 5, 16, 16, 20 };
		int num1 = 16;
		System.out.println("1��:" + getMyTimes(arr1, num1));
		int[] arr2 = { 1, 1, 1, 1, 1, 1, 1 };
		int num2 = 1;
		System.out.println("7��:" + getMyTimes(arr2, num2));
		int[] arr3 = { 1 };
		int num3 = 1;
		System.out.println("1��:" + getMyTimes(arr3, num3));
		int[] arr4 = { 2, 2, 2, 2, 2, 2 };
		int num4 = 1;
		System.out.println("0��:" + getMyTimes(arr4, num4));
	}

	/**
	 * ��ȡnum��arr�����г��ֵĴ���
	 * 
	 * @param arr�������ҵ�����
	 * @param num�������ҵ�����
	 * @return �������в����ڸ����֣�����-1���������򷵻س��ֵĴ�����
	 */
	private static int getMyTimes(int[] arr, int num) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0) {
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		}
		// ���ֲ��ң���ȡnum��arr�е�λ��
		int index = binarySearch(arr, 0, arr.length - 1, num);
		// ��index-1��˵��������δ���֡�
		if (index == -1)
			return 0;
		// ���������ĵ�һ��num�������ؽǱ�
		int firstIndex = getFirstIndexOfNum(arr, index, num);
		// �������Ҳ�����һ��num�������ؽǱ�
		int lastIndex = getLastIndexOfNum(arr, index, num);
		// ����num�������г��ֵĴ���
		return lastIndex - firstIndex + 1;
	}

	/**
	 * ��ȡnum���һ�γ���ʱ��arr�����ж�Ӧ�ĽǱ�
	 * 
	 * @param arr�������ҵ�����
	 * @param index��num��arr�еĽǱ�
	 * @param num�������ҵ�����
	 * @return ����num���һ�γ���ʱ��arr�����ж�Ӧ�ĽǱ�
	 */
	private static int getLastIndexOfNum(int[] arr, int index, int num) {
		// ��indexΪarr[]�����һ���Ǳ꣬��ֱ�ӷ���index
		if (index == arr.length - 1)
			return index;
		// ��arr[index]�������һ��Ԫ�أ�������һ��Ԫ�ز���num����ֱ�ӷ��ص�ǰ��index
		else if (arr[index + 1] != num)
			return index;
		// ��������μ�������
		int pos = binarySearch(arr, index + 1, arr.length - 1, num);
		return getLastIndexOfNum(arr, pos, num);
	}

	/**
	 * ��ȡ ����arr�е�һ�γ���numʱ�ĽǱ꣬ʱ�临�Ӷ�O(logn)
	 * 
	 * @param arr�������ҵ�����
	 * @param index��num��arr�еĽǱ�
	 * @param num�������ҵ�����
	 * @return ����arr�е�һ�γ���numʱ�ĽǱ�
	 */
	private static int getFirstIndexOfNum(int[] arr, int index, int num) {
		// ��indexΪarr[]��0�Ǳ꣬��ֱ�ӷ���index
		if (index == 0)
			return 0;
		// ��arr[index]���ǵ�һ��Ԫ�أ�����ǰһ��Ԫ�ز���num����ֱ�ӷ��ص�ǰ��index
		else if (arr[index - 1] != num) {
			return index;
		}
		// ��ǰ��μ������ң��ݹ�
		int pos = binarySearch(arr, 0, index - 1, num);
		return getFirstIndexOfNum(arr, pos, num);

	}

	/**
	 * ���ֲ��ң�ʱ�临�Ӷ�O(logn)
	 * 
	 * @param arr,�����ҵ�����
	 * @param low
	 * @param high
	 * @param num�������ҵ�����
	 * @return ���ҵ��������ڵĽǱ꣬���� ���������򷵻�-1
	 */
	private static int binarySearch(int[] arr, int low, int high, int num) {
		while (low <= high) {
			int middle = (low + high) / 2;
			if (arr[middle] < num) {
				low = middle + 1;
			} else if (arr[middle] > num) {
				high = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
