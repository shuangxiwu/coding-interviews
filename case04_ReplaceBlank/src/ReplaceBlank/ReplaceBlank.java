package ReplaceBlank;

public class ReplaceBlank {

	/**
	 * ����1���滻�ַ���������ԭ�ַ������滻�������¿���һ���ַ������滻�� ����2����ԭ�ַ������滻����ô�滻Ч�ʸߣ� ��ǰ�������һ�飬�Ӻ���ǰ�滻��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer("We Are Happy");
		String s2 = replaceBlank1(s1);
		System.out.println(s2);
		String s3 = replaceBlank2(s1);
		System.out.println(s3);
		System.out.println(s1);
		String s4 = replaceBlank2(null);
		System.out.println(s4);
	}

	// ����1���¿���һ���ַ������滻
	public static String replaceBlank1(StringBuffer str) {
		StringBuffer newSb = new StringBuffer();
		if (str == null)
			return null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				newSb.append("%20");
			else
				newSb.append(String.valueOf(str.charAt(i)));
		}
		return newSb.toString();
	}

	// ����2����ԭ�ַ������滻
	public static String replaceBlank2(StringBuffer str) {
		// �Կ��ַ������ж�
		if (str == null)
			return null;
		// ͳ�ƿո�����
		int numOfBlank = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				numOfBlank++;
			}
		}

		int oldSbLength = str.length();
		int newSbLength = oldSbLength + numOfBlank * 2;
		int newIndex = 0;
		int oldIndex = 0;
		newIndex = newSbLength - 1;
		oldIndex = oldSbLength - 1;
		str.setLength(newSbLength);
		while (oldIndex > 0 && newIndex > oldIndex) {
			if (str.charAt(oldIndex) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');

			} else {
				str.setCharAt(newIndex--, str.charAt(oldIndex));
			}
			oldIndex--;
		}
		return str.toString();
	}
}
