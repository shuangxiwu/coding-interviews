package case24_VarifyArrIsPostBT;

public class VarifyArrIsPostBT {
	/**
	 * ��Ŀ��
	 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ��������Ľ��������Ƿ���true�����򷵻�false���������������������������ֶ�����ͬ��
	 * 
	 * @param args
	 */

	// ���õݹ�ķ�ʽ
	public static boolean VarifyPBT(int[] arr) {
		if (arr == null || arr.length < 1)
			return false;
		int low = 0;
		int high = arr.length - 1;
		return isPostBinaryTree(arr, low, high);
	}

	public static boolean isPostBinaryTree(int[] arr, int low, int high) {
		if (low >= high)
			return true;

		// arr���е����һ�������Ǻ��������������ĸ��ڵ�
		int root = arr[high];
		int i = low;

		// �ж� ���������� [low,i-1]��������
		for (; i < high; i++) {
			if (arr[i] > root)
				break;
		}

		// �ж� ���������� [i,high-1]��������
		int j = i;
		for (; j < high; j++) {
			if (arr[j] < root)
				return false;
		}

		// �ݹ�������
		boolean left = isPostBinaryTree(arr, low, i - 1);

		// �ݹ�������
		boolean right = isPostBinaryTree(arr, i, high - 1);

		return left && right;
	}

	// ****test case start*****//
	public static void main(String[] args) {
		// 10
		// / \
		// 6 14
		// /\ /\
		// 4 8 12 16
		int[] data = { 4, 8, 6, 12, 16, 14, 10 };
		System.out.println("true: " + VarifyPBT(data));

		// 5
		// / \
		// 4 7
		// /
		// 6
		int[] data2 = { 4, 6, 7, 5 };
		System.out.println("true: " + VarifyPBT(data2));

		// 5
		// /
		// 4
		// /
		// 3
		// /
		// 2
		// /
		// 1
		int[] data3 = { 1, 2, 3, 4, 5 };
		System.out.println("true: " + VarifyPBT(data3));

		// 1
		// \
		// 2
		// \
		// 3
		// \
		// 4
		// \
		// 5
		int[] data4 = { 5, 4, 3, 2, 1 };
		System.out.println("true: " + VarifyPBT(data4));

		// ����ֻ��1�����
		int[] data5 = { 5 };
		System.out.println("true: " + VarifyPBT(data5));

		int[] data6 = { 7, 4, 6, 5 };
		System.out.println("false: " + VarifyPBT(data6));

		int[] data7 = { 4, 6, 12, 8, 16, 14, 10 };
		System.out.println("false: " + VarifyPBT(data7));
	}
	// ****test case end*****//

}
