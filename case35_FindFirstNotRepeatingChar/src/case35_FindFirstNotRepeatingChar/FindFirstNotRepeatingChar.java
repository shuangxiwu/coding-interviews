package case35_FindFirstNotRepeatingChar;

import java.util.LinkedHashMap;

/**
 * ��Ŀ�����ַ������ҳ���һ��ֻ����һ�ε��ַ��������롰abaccdeff�����������b��
 * 
 * @author WangSai
 *
 */
public class FindFirstNotRepeatingChar {

	// ����1��ʹ��˫�м���,HashMap<K,V>
	private char findTheChar(String str) {
		// �쳣����
		if (str == null)
			return 0;
		// throw new IllegalArgumentException("�Ƿ������������¼��...");
		LinkedHashMap<Character, Integer> hp = new LinkedHashMap<>();
		char[] charArr = str.toCharArray();
		// �����ַ����飬���ַ���Ϊ�������ִ�����Ϊֵ��¼��
		for (int i = 0; i < charArr.length; i++) {
			// ���������������Ѷ�Ӧ��ֵ��Ϊ1
			if (!hp.containsKey(charArr[i]))
				hp.put(charArr[i], 1);
			// ��������Ӧ�ļ������ڼ���Ӧ��ԭֵ��+1
			else
				hp.put(charArr[i], hp.get(charArr[i]) + 1);
		}
		// ��ʼ���ַ�
		char theChar = '\u0000';
		// ����HashMap�������ֵ�һ��ֵΪ1�ļ�����ü���Ϊ��һ�����ֵ��ַ�,�����ظ��ַ���
		for (char as : hp.keySet()) {

			if (hp.get(as) == 1) {
				return as;
			}
		}
		return theChar;
	}

	/**
	 * ����2��
	 * 
	 * �Լ�������ϣֵ�����������顣char��СΪһ���ֽڣ���ΧΪ0-255�����Դ�����СΪ256��������
	 * 
	 * ����Ǳ��charһһ��Ӧ��
	 * 
	 * �����е�����1������ÿ���ַ���һ�γ��ֵ�λ��,2����ʼ��ʱΪ-1��3���ظ�����ʱ��Ϊ-2
	 */

	private char findTheChar2(String str) {
		if (str == null)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		int[] arr = new int[256];
		// arr��ʼֵΪ-1
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		int len = str.length();
		// ����str
		for (int i = 0; i < len; i++) {
			// str�е��ַ���Ӧ��intֵ��Ϊ����Ǳ꣬����ϣֵ
			int c = (int) str.charAt(i);
			// ��������Ϊstr�еĽǱ�i
			// -1˵��û���ֹ�
			if (arr[c] == -1) {
				arr[c] = i;
			}
			// ������ֹ�����Ϊ-2
			else {
				arr[c] = -2;
			}
		}
		// ����������֮���arr����ȡ��С�ĽǱ�
		char theChar = 0;
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// �����е�����Ϊ-1����-2��˵�����ֹ�0�λ��߶�Ρ�
			if (arr[i] < 0) {
				continue;
			}
			// ���ֹ�һ�ε��ַ�
			else {
				if (arr[i] < minIndex)
					// ����arr�ĽǱ꼴�Ƕ�Ӧ���ַ�
					theChar = (char) i;
				// arr[i]�����ݱ�������ַ����ĽǱ�
				minIndex = arr[i];
			}
		}
		return theChar;
	}

	public static void main(String[] args) {
		test2();
		test3();
		test4();
		test1();
	}

	// �ַ���λnull
	private static void test1() {
		String str = null;
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1�����������ַ���   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2�����������ַ���   " + ffnrc.findTheChar2(str));
	}

	// �ַ���ֻ��1���ַ�
	private static void test2() {
		String str = "a";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1�����������ַ���   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2�����������ַ���   " + ffnrc.findTheChar2(str));
	}

	// �ַ�����ȫ��Ϊ�ظ��ַ�
	private static void test3() {
		String str = "aaaaaaaa";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1�����������ַ���   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2�����������ַ���   " + ffnrc.findTheChar2(str));
	}

	// ��ͨ�ַ���
	private static void test4() {
		String str = "aaedbcf";
		FindFirstNotRepeatingChar ffnrc = new FindFirstNotRepeatingChar();
		System.out.println(str + '\t' + "    1�����������ַ���   " + ffnrc.findTheChar(str));
		System.out.println(str + '\t' + "    2�����������ַ���   " + ffnrc.findTheChar2(str));
	}
}
