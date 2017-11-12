package case34_UglyNumbers;

/**
 * ��Ŀ�����ǰ�ֻ��������2��3 ��5 ��������������Ugly Number�������С�����˳��ĵ�1500��������
 * ˼·���������鱣���Ѿ��ҵ��ĳ������ÿռ任ʱ��Ľⷨ
 * 
 * @author WangSai
 *
 */
public class UglyNumOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumOp myTest = new UglyNumOp();
		System.out.println(myTest.getUglyNumbers(11));
	}

	// ��ȡ��index������
	private int getUglyNumbers(int index) {
		if (index <= 0)
			return -1;
		// ���鱣��index������������arr[index-1]������Ҫ��ĵĳ���
		int[] arr = new int[index];
		arr[0] = 1;
		int nextIndex = 1;
		// T2λ�õ����ֳ���2֮��õ����ݴ��ڵ�ǰ�������У�����T2��λ�á�
		int T2 = 0;
		int T3 = 0;
		int T5 = 0;
		while (nextIndex < index) { // arr�����г�����������index����
			int min = minOf3(arr[T2] * 2, arr[T3] * 3, arr[T5] * 5);
			arr[nextIndex] = min;
			while (arr[T2] * 2 <= arr[nextIndex])
				T2++;
			while (arr[T3] * 3 <= arr[nextIndex])
				T3++;
			while (arr[T5] * 5 <= arr[nextIndex])
				T5++;
			// ��һ�����������λ��
			nextIndex++;
		}
		return arr[index - 1];
	}

	// ��ȡi��j,k�������е���С��
	private int minOf3(int i, int j, int k) {
		int min = i < j ? i : j;
		min = min < k ? min : k;
		return min;
	}

}
