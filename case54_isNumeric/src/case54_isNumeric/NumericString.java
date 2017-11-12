package case54_isNumeric;

/**
 * ��Ŀ����ʾ��ֵ���ַ�������ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ�����+100������5e2������-123������3.1416��
 * �Լ���-1E-16������ʾ��ֵ�����ǡ�12e������1a3.14������1.2.3������12e+5.4�������ǡ�
 * 
 * @author WangSai
 *
 */
public class NumericString {

	public static void main(String[] args) {
		String[] arr1 = { "+100", "-100", "100", "-1.2", "-1.2e+2", "-1.2e-2", "-e3", ".2" };
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("true:+" + isNumeric(arr1[i]));
		}
		String[] arr2 = { "+", "-+", "-100+2", "-1.2e", "-1.2e1.2", "-1.2e-2.2" };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("false:+" + isNumeric(arr2[i]));
		}
	}

	/**
	 * 
	 * @param str,��������ַ���
	 * @return �Ƿ��Ǳ�ʾ��ֵ���ַ���
	 */
	private static boolean isNumeric(String str) {
		// null ���߿��ַ���
		if (str == null || str.length() <= 0) {
			return false;
		}
		int len = str.length();
		// �ַ�����0�Ǳ�
		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		if (index >= len)
			return false;
		// ɨ������,������ɨ�赽��һ�������ֵ��ַ��ĽǱ�
		// ����λ֮�����������С���㣬e/E��������
		index = scanDigit(str, index);
		// ������
		if (index >= len)
			return true;
		if (index < len) {
			// .2 ���� +.2 ���� +.e2�����
			if (str.charAt(index) == '.') {
				index++;
				if (index > len)
					return false;
				index = scanDigit(str, index);
				// ��С��
				if (index >= len)
					return true;
				// С����֮���ǿ�ѧ������
				if (str.charAt(index) == 'e' || str.charAt(index) == 'E')
					return isExp(str, index);
			}
			// ��ѧ������
			else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
				return isExp(str, index);
			} else
				return false;
		}
		return false;
	}

	// �ǲ��ǿ�ѧ������
	private static boolean isExp(String str, int index) {
		if (str.charAt(index) != 'e' && str.charAt(index) != 'E') {
			return false;
		}
		index++;
		if (index >= str.length())
			return false;
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		if (index >= str.length())
			return false;
		index = scanDigit(str, index);
		if (index < str.length())
			return false;
		else
			return true;
	}

	// ɨ���ַ����е����֣������������ĵ�һ���������ֵ��ַ��ĽǱ�
	private static int scanDigit(String str, int index) {
		while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9')
			index++;
		return index;
	}

}
