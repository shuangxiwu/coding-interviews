package case65_maxInWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ��Ŀ������һ������ͻ������ڵĴ�С�����ҳ����л�������������ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
 * ���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * 
 * @author WangSai
 *
 */
public class maxInWindow {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int k = 3;
		int[] temp = getMax(arr, k);
		System.out.println("���л����������ֵ����ɵ����飬���������Ԫ��Ϊ��");
		for (int i : temp) {
			System.out.print(i + " ");
		}

		System.out.println();
		int[] arr2 = { 2 };
		int k2 = 1;
		int[] temp2 = getMax(arr2, k2);
		System.out.println("���л����������ֵ����ɵ����飬���������Ԫ��Ϊ��");
		for (int i : temp2) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 
	 * @param arr,����������
	 * @param k�����ڴ�С
	 * @return ÿ���������ڵ����ֵ��ɵ�����
	 */
	private static int[] getMax(int[] arr, int k) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0 || k <= 0 || arr.length < k)
			throw new IllegalArgumentException("�Ƿ��������...");
		// �������У����浱ǰ���ڵ����ֵ�ĽǱ�ʹδ�ֵ�ĽǱ�
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// �����ռ䣬���浱ǰ���ڵ����ֵ
		ArrayList<Integer> list = new ArrayList<>();
		// ��arr��һ��Ԫ�ؽǱ�ѹ���������������ﱣ��Ǳ���Ϊ���ж����ֵ�Ƿ��Ѿ����������ڡ���i-queue.peek()>=k
		queue.add(0);
		// �ѵ�һ���������������Ұ����ֵ�ĽǱ�浽�����
		for (int i = 1; i < k; i++) {
			// ����ǰԪ�ش��ڶ���������Ԫ��ʱ����ն��У����Ұѵ�ǰԪ����ӡ�
			if (arr[i] > arr[queue.peek()]) {
				if (!queue.isEmpty())
					queue.clear();
				// �����ֵ�Ǳ������
				queue.add(i);
			}
			// ����ǰԪ��С�ڵ��ڶ���β��Ԫ�أ���ѵ�ǰԪ�ط��ڶ���β����Ϊ��Ԫ�ؿ�������һ���������ڵ����ֵ������Ҫ�Ѷ�Ӧ�ĽǱ���뵽���������
			else if (arr[i] <= arr[queue.peekLast()]) {
				queue.add(i);
			}
			// ����ǰԪ�ش��ڶ�βԪ�أ����βԪ��һֱ��ջ��ֱ�����ڲ�С����������Ȼ��Ѹ�Ԫ�ؽǱ������С�
			else {
				while (arr[i] > arr[queue.peek()]) {
					queue.pollLast();
				}
				queue.add(i);
			}
		}
		// ���渨�����е�һ�����ڵ����ֵ
		list.add(arr[queue.peek()]);
		// ��ʼ���ڻ���
		for (int i = k; i < arr.length; i++) {
			// �жϸ��������е����ֵ�Ƿ��Ѿ��ڴ����л�����ȥ��
			if (i - queue.peek() >= k)
				queue.pollFirst();
			// �жϵ�ǰ��ֵ�Ͷ���ͷ����ֵ��С,����ǰֵ���ڶ����ײ������ȸ����������ֵ����
			if (arr[i] > arr[queue.peek()]) {
				queue.clear();
				queue.add(i);
			}
			// ����ǰԪ��С�ڵ��ڶ���β��Ԫ�أ���ѵ�ǰԪ�ط��ڶ���β��
			else if (arr[i] <= arr[queue.peekLast()]) {
				queue.add(i);
			}
			// ����ǰԪ�ش��ڶ�βԪ�أ����βԪ��һֱ��ջ��ֱ�����ڲ�С��������
			else {
				while (arr[i] > arr[queue.peekLast()]) {
					queue.pollLast();
				}
				queue.add(i);
			}
			// ���渨�����е�һ�����ڵ����ֵ
			list.add(arr[queue.peek()]);
		}
		// �ѽǱ�ֵת��������Ԫ�ء�
		int[] temp = new int[list.size()];
		for (int i = list.size() - 1; i >= 0; i--) {
			temp[i] = list.get(i);
		}
		// �������ֵ��ɵ�����
		return temp;
	}
}
