/**
 * 
 */
package case14_AdjustOddBeforeEven;

/**
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 * �Ż��棺��OddBeforeEven���ж�����ʹ�ú������н����Ż���������ɶ��������������Ϊǰ�������֣��Ƿ��ܱ�3������Ϊ�������ṩ�˿��ܡ�ֻ��Ҫ��д��������ɡ�
 * 
 * @author WangSai
 *
 */
public class OddBeforeEvenOp {

	public static void main(String[] args) {
		OddBeforeEvenOp oeo = new OddBeforeEvenOp();
		// test1
		int[] arr = { 1, 1, 1, 2, 3, 1, 1, 6, 6, 6, 1 };
		oeo.adjustOddEvenOp(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		// test2
		int[] arr2 = { 1, 1, 1, 3, 1 };
		oeo.adjustOddEvenOp(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		// test3
		int[] arr3 = { 2 };
		oeo.adjustOddEvenOp(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
	}

	private void adjustOddEvenOp(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("��������Ƿ����������...");
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			while (low < high && !isEven(arr[low])) {
				low++;
			}
			while (low < high && isEven(arr[high])) {
				high--;
			}
			if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
	}

	// �жϸ��������ǲ���ż��������ż���򷵻�true�����򣬷���false
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
