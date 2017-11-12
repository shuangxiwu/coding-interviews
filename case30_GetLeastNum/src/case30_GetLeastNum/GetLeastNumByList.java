package case30_GetLeastNum;

import java.util.ArrayList;

public class GetLeastNumByList {

	public static void main(String[] args) {
		// ����
		int[] arr = { 4, 5, 1, 4, 4, 7, 3, 8 };
		int k = 4;
		ArrayList<Integer> alist = getNum(arr, k);
		for (Integer num : alist)
			System.out.print(num + " ");

	}

	// ��ȡ������������С��k������
	private static ArrayList<Integer> getNum(int[] arr, int k) {
		// �ж��쳣���
		if (arr == null || arr.length <= 0 || arr.length < k || k <= 0)
			throw new IllegalArgumentException("�Ƿ����������...");
		// �½��������������е���С��k��ʱ��ֱ����ӡ�
		ArrayList<Integer> alist = new ArrayList<>();
		for (int i = 0; i < k; i++)
			alist.add(arr[i]);

		// ����������֮�󣬼�����ʣ�µ�arr[]�����ȡ��������ȡ��������С��alist������������ֱ���滻����
		for (int j = k; j < arr.length; j++) {
			// ��ȡalist��������ֵ
			int indexOfMaxValue = getMaxIndex(alist);
			int max = alist.get(indexOfMaxValue);
			// ��arr�е�ǰ��ֵС��alist�е����ֵ�����滻��alist�е����ֵ
			if (arr[j] < max) {
				alist.set(indexOfMaxValue, arr[j]);
			}
		}
		return alist;
	}

	// ��ȡarraylist�е������ֵ�Ľ�����
	private static int getMaxIndex(ArrayList<Integer> alist) {
		int max = alist.get(0);
		int i = 0;
		for (int j = 1; j < alist.size(); j++) {
			if (alist.get(j) > max) {
				max = alist.get(j);
				i = j;
			}
		}
		return i;
	}
}
