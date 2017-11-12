package case08_MinNumInRotatedArray;

/**
 * ��Ŀ����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������������һ����ת���������ת�������СԪ�ء�
 * ��������Ϊ{1,2,3,4,5}������һ����תΪ{3,4,5,1,2},���������СֵΪ1.
 * 
 * ˼·�����ö��ֲ��ҵİ취��
 * 
 * @author WangSai
 *
 */
public class MinNum {
	/**
	 * 
	 * @param ��ת����
	 * @return ��ת�������С����
	 */
	public static void main(String[] args) {
		MinNum mn = new MinNum();

		int[] arr = { 3, 4, 5, 6, 1, 2 };
		System.out.println(mn.getMin(arr));

		int[] arr1 = { 1, 2, 1, 1, 1 };
		System.out.println(mn.getMin(arr1));

		int[] arr2 = { 2, 2, 2, 2, 2, 2 };
		System.out.println(mn.getMin(arr2));
	}

	// ��ת����arr����Сֵ��
	private int getMin(int[] arr) {
		// ����쳣���
		// ���ö��ֲ��Ҵ���ͷ��ʼ���м���ҡ�
		// ��arr[mid]���ڵ���arr[low]����˵��arr[mid]λ������ǰ���������{3,4,5}�С������ң���С������֮�󣩣�
		// ��arr[mid]С�ڵ���arr[low]��ͬʱ��ҲС��arr[high]��˵��arr[mid]λ������ĺ����������С������ң���С�����������������֮ǰ����
		// ��low��highֵ���Ϊ1ʱ����arr[high]��������Сֵ��

		// �������1����ת�����в�δ��ת���֣�����ԭ�������顣
		// �������2��[1,1,1,1,1,1,1,1,1,0,1,1],�������ʱarr[low]��arr[mid],arr[high]������ͬ��ֻ���ñ����ķ�ʽ��ɡ�

		// �쳣������
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ�����������������...");
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (arr[low] >= arr[high]) {
			// ��������
			if (high - low <= 1) {
				return arr[high];
			}
			// ���ֲ���
			mid = (low + high) / 2;
			// ͬʱ�����������2
			if (arr[low] == arr[mid] && arr[mid] == arr[high])
				return minInOrder(arr, low, high);
			if (arr[mid] >= arr[low])
				low = mid;
			else if (arr[mid] <= arr[high]) {
				high = mid;
			}
		}
		return arr[high]; // ����������1���ӵ�һ�����ֱȽ�
	}

	// ˳����ң�����[low��high]
	private int minInOrder(int[] arr, int low, int high) {
		int result = arr[low];
		for (int i = low; i <= high; i++) {
			if (arr[i] < result)
				result = arr[i];
		}
		return result;
	}
}
