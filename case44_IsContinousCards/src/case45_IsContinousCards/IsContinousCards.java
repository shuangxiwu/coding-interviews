package case45_IsContinousCards;

/**
 * ��Ŀ�����˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2~10Ϊ���ֱ���AΪ1�� JΪ11��
 * QΪ12��KΪ13������С�����Կ����������֡�
 * 
 * ˼·��1��������������Ϊ0��2��Ȼ�����5����������3��ͳ�����������е�0�ĸ����������ĸ�����4����0�������ֵĲ�ֵ�����Ƿ�������
 * ����������Ӧ���뼸�����֡�5����ͬ���ֳ��֣��������˿����ж��ӵĳ��֣�����������
 * 
 * @author WangSai
 *
 */
public class IsContinousCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// û��������������������
		int[] arr1 = { 2, 3, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr1));
		// û�������������ǲ�������
		int[] arr2 = { 1, 2, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr2));
		// �������ҷ�0������������
		int[] arr3 = { 0, 3, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr3));
		// �������ҷ�0�����ǲ������ģ����ǲ�����֮����Ա�֤����
		int[] arr4 = { 0, 2, 4, 5, 6 };
		System.out.println("true:" + myIsContinous(arr4));
		// �������ҷ�0�����ǲ������ģ����ǲ�����֮���ܱ�֤����
		int[] arr5 = { 0, 1, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr5));
		// ���ַ�0�ظ�����
		int[] arr6 = { 1, 1, 4, 5, 6 };
		System.out.println("false:" + myIsContinous(arr6));
	}

	private static boolean myIsContinous(int[] arr) {
		// �쳣ֵ���
		if (arr == null || arr.length < 5)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");

		// ��������
		quickSort(arr, 0, arr.length - 1);
		// ͳ��������0�ĸ��� cnt0
		int cnt0 = 0;
		// ��������֮��Ĳ�ֵ
		int dif = 0;
		// ͳ����������֮���ܹ���Ҫ��������ֵĸ���
		int insertSum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			dif = arr[i + 1] - arr[i];
			// �ж�����ǰ��0�ĸ���
			if (arr[i] == 0)
				cnt0++;
			// �ж����ڵ�����֮��Ŀ��Բ�������ֵĸ���,�����ڵ���1��˵�����Ƕ���
			else if (dif >= 1) {
				insertSum += dif - 1;
			}
			// ��0��������֮��Ĳ�ֵΪ0,˵������������ͬ���������˶��ӡ�������
			else if (dif == 0) {
				return false;
			}

		}
		// ����Ҫ��������ֵĸ���insertSum С�ڵ���0�ĸ���cnt0��������
		if (insertSum <= cnt0)
			return true;
		return false;

	}

	// ������������
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotPos = partition(arr, low, high);
			quickSort(arr, low, pivotPos - 1);
			quickSort(arr, pivotPos + 1, high);
		}
	}

	// �����㷨
	private static int partition(int[] arr, int low, int high) {
		int pivotKey = arr[low];
		while (low < high) {
			while (low < high && pivotKey <= arr[high])
				high--;
			arr[low] = arr[high];
			while (low < high && pivotKey >= arr[low])
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivotKey;
		return low;
	}

}
