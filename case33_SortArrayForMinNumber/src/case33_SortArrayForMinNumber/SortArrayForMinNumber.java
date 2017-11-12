package case33_SortArrayForMinNumber;

import java.util.Comparator;

/**
 * ��Ŀ������һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3,32,321}�����ӡ����3���������ĳɵ���С����321323��
 * 
 * @author WangSai
 *
 */
public class SortArrayForMinNumber {

	/**
	 *
	 * ˼·��
	 *
	 * ��������ƴ������������3��32��ƴ�ӳɵ���С������Ϊ323������3,32�� Ҫ ���� (32,3)������������ƴ��֮����ab<ba,
	 * ���a����b��ǰ�ߣ� �����������е������Զ����������֮�󣬿������ÿ��������㷨ʵ�֡�
	 * �Զ���������򣺴�������ȡ����������a��b��������a������bת�����ַ���֮�����ƴ�ӣ�Ȼ�������ַ��������compareTo()�������Ƚ�����
	 * ���Ĵ�С��ϵ��
	 * 
	 * ����ͬʱ����˴������⡣����a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,abƴ��֮�󣬻���ִ������⡣
	 * ת�����ַ���֮������ �ı����˴������⡣
	 */

	public static void main(String[] args) {
		int[] arr1 = { 1 };
		System.out.println(mySort(arr1));
		int[] arr2 = { 1,2,2,3 };
		System.out.println(mySort(arr2));
		int[] arr3 = { 123,3,4,21 };
		System.out.println(mySort(arr3));
	}

	/**
	 * 
	 * @param arr,�����������
	 * @return ��������֮����ɵ���С�������ַ���
	 */
	private static String mySort(int[] arr) {
		// TODO Auto-generated method stub
		// �쳣ֵ���
		if (arr == null || arr.length <= 0)
			return null;
		// ���������Զ���ȽϹ���
		myComparator myCmp = new myComparator();
		mySortCore(arr, 0, arr.length - 1, myCmp);
		// ����֮�󣬰�arrת�����ַ������
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		// return arr.toString();
		return sb.toString();

	}

	/**
	 * 
	 * @param arr,����������
	 * @param low,����������������Ǳ�
	 * @param high,��������������Ҳ�Ǳ�
	 * @param comp,�Զ���Ƚ���
	 */
	// ���������㷨
	private static void mySortCore(int[] arr, int low, int high, Comparator<Integer> comp) {
		if (low < high) {
			int pivotPos = partition(arr, low, high, comp);
			mySortCore(arr, low, pivotPos - 1, comp);
			mySortCore(arr, pivotPos + 1, high, comp);
		}
	}

	// �����㷨
	private static int partition(int[] arr, int low, int high, Comparator<Integer> comp) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && comp.compare(pivotKey, arr[high]) <= 0)
				high--;
			arr[low] = arr[high];
			while (low < high && comp.compare(pivotKey, arr[low]) >= 0)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}

	// �Զ���Ƚ�����ʵ��Comparator�ӿ�
	private static class myComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// ������ƴ�ӳ��ַ�����ͬʱ����˴�������
			String str1 = o1 + "" + o2;
			String str2 = o2 + "" + o1;
			// �����ַ����Լ���compateTo�����Ƚ�str1-str2�Ĵ�С
			return str1.compareTo(str2);
		}
	}
}
