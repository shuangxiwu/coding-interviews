package case49_StringToInt;

/**
 * ��Ŀ����һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * 
 * @author WangSai
 *
 */
public class Solution {

	/**
	 * �Ѹ������ַ���ת�������֡���Ҫ���ǵ����⣺
	 * 
	 * ���ַ���""��"+10","-100"
	 * 
	 * 
	 * @param str
	 * @return �ַ�����Ӧ������
	 */
	public int StrToInt(String str) {
		// �쳣ֵ���
		if (str == null || str.length() <= 0)
			return 0;
		// ��־�Ƿ��Ǹ���
		boolean isPostive = true;
		// ��¼�ַ����ĽǱ�
		int index = 0;
		// �ַ�����Ӧ������
		int number = 0;
		// �ж��ǲ��Ǵ� + -������
		if (str.charAt(index) == '+') {
			isPostive = true;
			index++;
		} else if (str.charAt(index) == '-') {
			isPostive = false;
			index++;
		}
		// �ж��Ƿ���ֻ�� '+' '-'���ַ���
		if (index >= str.length())
			return 0;
		// �����ַ����е�����
		while (index < str.length()) {
			if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
				number = number * 10 + str.charAt(index) - '0';
				index++;
			} else
				return 0;
		}
		// ����Ǹ���
		if (!isPostive)
			number = 0 - number;
		return number;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str1 = "+";
		System.out.println(str1 + " : " + s.StrToInt(str1));
		String str2 = "+10";
		System.out.println(str2 + " : " + s.StrToInt(str2));
		String str3 = "-100";
		System.out.println(str3 + " : " + s.StrToInt(str3));
		String str4 = "10";
		System.out.println(str4 + " : " + s.StrToInt(str4));
		String str5 = "123";
		System.out.println(str5 + " : " + s.StrToInt(str5));
		String str6 = "111a2";
		System.out.println(str6 + " : " + s.StrToInt(str6));
		String str7 = "++";
		System.out.println(str7 + " : " + s.StrToInt(str7));
		String str8 = "";
		System.out.println(str8 + " : " + s.StrToInt(str8));
		String str9 = null;
		System.out.println(str9 + " : " + s.StrToInt(str9));
	}

}
