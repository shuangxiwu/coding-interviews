package case29_MoreThanHalfNum;

/**
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г���5�Σ��������鳤�ȵ�һ�룬һ�����2���쳣��������������ʱ���-1
 * 
 * @author WangSai
 *
 */
public class MoreThanHalfNum2 {
	/**
	 * @param ����
	 * @return ���ִ�����������һ�������
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3 };
		System.out.println(moreThanHalf(arr));
	}

	// ���ִ�����������һ�������
	private static int moreThanHalf(int[] arr) {
		// ����쳣���
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���������Ƿ�...");
		// ����arr[0]���Ǵ�������һ���ֵ
		int result = arr[0];
		// ��¼���ֵĴ���
		int times = 1;
		// ���˵����ִ�������һ�����
		for (int i = 1; i < arr.length; i++) {
			if (times == 0) {
				result = arr[i];
				times = 1;
			} else if (arr[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		return checkMoreThanHalf(arr, result);
	}

	// ��������õ����ֵĴ������Ƿ񳬹����鳤�ȵ�һ�롣
	private static int checkMoreThanHalf(int[] arr, int result) {
		int times = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == result)
				times++;
		}
		if (times * 2 > arr.length)
			return result;
		else
			// return -1;
			throw new RuntimeException("���������Ƿ�...");
	}

}
