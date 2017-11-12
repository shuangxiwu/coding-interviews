package case42_2LeftRotateString;

/**
 * ��Ŀ2���ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����������ַ�����abcdefg��������2,��
 * �ú�����������ת2λ�õ��Ľ����cdefgab����
 * 
 * @author WangSai
 *
 */
public class LeftRotateString {

	public static void main(String[] args) {
		String input = "abcdefg";
		int num = 7;
		System.out.println(myRotate1(input, num));
		System.out.println(myRotate2(input, num));
	}

	/**
	 * ����1����������stringbuffer
	 * 
	 * @param input����������ַ���
	 * @param num����ת�ַ�������
	 * @return ��ת֮����ַ���
	 */
	private static String myRotate1(String input, int num) {
		// �쳣���
		if (input == null || input.length() < num || num < 0)
			return null;
		// �����ַ��������������������Ӵ���������
		StringBuffer sb1 = new StringBuffer(input.substring(0, num));
		StringBuffer sb2 = new StringBuffer(input.substring(num, input.length()));
		// �������ǵı���˳��
		return sb2.toString() + sb1.toString();
	}

	/**
	 * ����2�� ��תÿ���Ӵ� abcdefg ,��ת�� ba gfedc�� ��ת�����ַ���,��ת��cdefg ab
	 * 
	 * @param input����������ַ���
	 * @param num����ת���ַ���
	 * @return ��ת֮����ַ���
	 */
	private static String myRotate2(String input, int num) {
		// �쳣ֵ���
		if (input == null || input.length() < num || num < 0) {
			return null;
		}
		if (input.length() == num)
			return input;
		char[] arr = input.toCharArray();
		// ��תÿ���Ӵ� abcdefg ,��ת�� ba gfedc
		reverseWord(arr, 0, num - 1);
		reverseWord(arr, num, input.length() - 1);
		// ��ת�����ַ���,��ת��cdefg ab
		reverseWord(arr, 0, input.length() - 1);
		StringBuffer sb1 = new StringBuffer();
		for (char i : arr) {
			sb1.append(i);
		}
		return sb1.toString();

	}

	private static void reverseWord(char[] arr, int left, int right) {
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
	}

}
