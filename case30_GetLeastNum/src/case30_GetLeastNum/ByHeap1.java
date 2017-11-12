package case30_GetLeastNum;

/**
 * ͨ��ʹ�ô󶥶���ɡ�ʱ�临�Ӷ�O(nlogk)
 * 
 * @author WangSai
 *
 */
public class ByHeap1 {

	// 1�����������������arr��ǰK��Ԫ��
	// 2������[0...K-1]���д����󶥶�
	// 3��ԭ���дӵ�K����ʼ����[0...K-1]�������Ƚϣ������ڶѶ�Ԫ��������滻
	// 4���滻��ɺ󣬶��������µ�����ɴ󶥶�
	// 3,4����ѭ������
	public static void main(String[] args) {
		int[] arr = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 100, 7 };
		int k = 7;
		getLeatK(arr, k);
		int[] arr1 = { 1 };
		k = 1;
		getLeatK(arr1, k);
	}

	// ��ȡ��С��K��Ԫ�صķ���
	private static void getLeatK(int[] arr, int k) {
		// �쳣������
		if (arr == null || arr.length <= 0 || arr.length < k || k <= 0)
			throw new IllegalArgumentException("����Ĳ����Ƿ��������¼��...");
		// ���������������arr��ǰK��Ԫ��
		int[] heap = new int[k];
		for (int i = 0; i < k; i++) {
			heap[i] = arr[i];
		}
		buildMaxTopHeap(heap);
		// arr�е�Ԫ�شӵ�K����ʼ������󶥶�heap���Ƚϣ�������ڶԶ����滻�������µĶ�������
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < heap[0]) {
				heap[0] = arr[i];
				adjustDownToUp(heap, 0);
			}
		}
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + "     ");
		}
		System.out.println();
	}

	// ������K��Ԫ�ص��������й����󶥶�
	private static void buildMaxTopHeap(int[] heap) {
		for (int i = heap.length / 2 - 1; i >= 0; i--) {
			// �Ե����ϵ�����
			adjustDownToUp(heap, i);
		}
	}

	// �Ե����ϵ�����Ϊ�󶥶�
	private static void adjustDownToUp(int[] heap, int i) {
		// �жϸýڵ������ӽڵ�Ĵ�С
		int temp = heap[i];
		for (int j = 2 * i + 1; j < heap.length - 1; j = 2 * j + 1) { // iΪ��ʼ��Ϊ�ڵ�k�����ӣ��ؽڵ�ϴ���ӽڵ����µ���
			if (j <= heap.length - 1 && heap[j] < heap[j + 1]) // ȡ�ڵ�ϴ���ӽڵ���±�
				j++; // ����ڵ���Һ���>���ӣ���ȡ�Һ��ӽڵ���±�
			if (temp >= heap[j]) // ���ڵ� >=������Ů�йؼ��ֽϴ��ߣ���������
				break;
			// ���ڵ� <������Ů�йؼ��ֽϴ���
			else {
				heap[i] = heap[j]; // �������ӽ���нϴ�ֵarray[i]������˫�׽ڵ���
				i = j; // ���ؼ����޸�kֵ���Ա�������µ���
			}
		}
		heap[i] = temp; // �������Ľ���ֵ��������λ��
	}
}
