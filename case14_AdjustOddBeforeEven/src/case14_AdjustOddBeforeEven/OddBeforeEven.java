package case14_AdjustOddBeforeEven;

/**
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 * ˼·��ʹ������ָ�룬��һ��ָ��plowָ�������һ��Ԫ�أ������������벿���ƶ����ڶ���ָ��phighָ���������һ��Ԫ�أ�����������ǰ�벿���ƶ���
 * ����plowָ����һ��Ϊż����Ԫ�أ�����phighָ��ǰһ��Ϊ������Ԫ�أ���������ָ��ָ���Ԫ�ء�
 * 
 * @author WangSai
 *
 */
public class OddBeforeEven {

	// ��������Ԫ��
	private void adjustOddEven(int[] arr) {
		// �쳣����
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("��������Ƿ��������¼��...");
		// plow�Ǳ�ָ��ǰ�벿�ֵ�ż������ʼ����ʱ��ָ�������һ��Ԫ��
		int plow = 0;
		// phigh�Ǳ�ָ���벿�ֵ�����,��ʼ����ʱ��ָ���������һ��Ԫ��
		int phigh = arr.length - 1;
		while (plow < phigh) {
			// plow�Ǳ�ָ��ǰ�벿�ֵ�ż��
			while (plow < phigh && ((arr[plow] & 1) == 1)) {
				plow++;
			}
			// phigh�Ǳ�ָ���벿�ֵ�����
			while (plow < phigh && ((arr[phigh] & 1) == 0)) {
				phigh--;
			}
			if (plow < phigh) {
				int temp = arr[plow];
				arr[plow] = arr[phigh];
				arr[phigh] = temp;
			}
		}
	}

	public static void main(String[] args) {
		OddBeforeEven oe = new OddBeforeEven();
		// test1
		int[] arr = { 1, 1, 1, 2, 3, 1, 1, 6, 6, 6, 1 };
		oe.adjustOddEven(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		// test2
		int[] arr2 = { 1, 1, 1, 3, 1 };
		oe.adjustOddEven(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		System.out.println();

		// test3
		int[] arr3 = { 2 };
		oe.adjustOddEven(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]);
		}
		System.out.println();
	}

}
