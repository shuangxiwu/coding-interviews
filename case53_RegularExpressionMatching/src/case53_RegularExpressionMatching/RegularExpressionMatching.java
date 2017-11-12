package case53_RegularExpressionMatching;

import java.util.zip.InflaterInputStream;

/**
 * ��Ŀ����ʵ��һ����������ƥ�������.���͡�*����������ʽ��ģʽ�е��ַ���.����ʾ����һ���ַ�������*����ʾ��ǰ����ַ����Գ���
 * ����Σ���0�Σ��������У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ�����aaa����ģʽ��a.a���͡�ab*ac*a��ƥ�䣬����
 * ��aa.a������ab*a������ƥ�䡣
 * 
 * ˼·������Ҫ��ȷ'.'ȷ�����ַ��ĸ���Ϊ1������Ϊ���⣻'*'����ȷ����ǰ����ַ��ĸ�������0�Σ�
 * 
 * ��һ�������
 * 
 * ��ģʽ�ĵڶ����ַ�����'*'��ʱ������ַ����ĵ�һ���ַ���ģʽ���ĵ�һ���ַ���ȣ�������ƶ�һ����ƥ��ʣ�µ��ַ�����ģʽ
 * �������������ֱ�ӷ���false��
 * 
 * 
 * �ڶ����������ģʽ�ĵڶ����ַ���'*'��ʱ����ʱ����Ը��ӵ������Ϊ��ʱ����ڲ�ͬ�ļ���ƥ�䷽ʽ�����ַ���"aaa"��ģʽ"ab*ac*a"ƥ��Ϊ����
 * 
 * 1�����ģʽ���е��ַ����ַ����е��ַ����ȣ���ģʽ���ĵڶ����ַ�Ϊ'*'��
 * 
 * ѡ��ֻ��һ�֣���ģʽ��������ƶ������ַ�,���Ե�b��*����Ϊ'*'����ƥ��0���ַ���
 * 2�����ģʽ���е��ַ����ַ����е��ַ���ȣ�����ģʽ����Ϊ'.'������ģʽ���ĵڶ����ַ�Ϊ'*'����ʱ��ѡ�������������
 * 
 * ��1������ѡ����ģʽ��������ƶ������ַ�,���Ե�b��*����Ϊ'*'����ƥ��0���ַ����ַ���str���ֲ��䣻
 * 
 * ��2������ѡ��Խ��'*'��'*'ǰ��a������Ч���ַ���������Ϊ1��str++��
 * 
 * ��3������ѡ��ģʽ��pattern���䣬��Ϊ��*��ǰ��a�������������ģ����Һ��ַ���str��ȣ�ֻ��Ҫstr++���ɣ�
 * 
 * @author WangSai
 *
 */
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "aaa";

		String pattern1 = "a.a";
		System.out.println(pattern1 + '\t' + "----" + '\t' + myMatch(input, pattern1));

		String pattern2 = "a*a";
		System.out.println(pattern2 + '\t' + "----" + '\t' + myMatch(input, pattern2));

		String pattern3 = "ab*ac*a";
		System.out.println(pattern3 + '\t' + "----" + '\t' + myMatch(input, pattern3));

		String pattern4 = "a.aa";
		System.out.println(pattern4 + '\t' + "----" + '\t' + myMatch(input, pattern4));

		String pattern5 = "aaa*";
		System.out.println(pattern5 + '\t' + "----" + '\t' + myMatch(input, pattern5));
		String pattern6 = "abbbbb*";
		System.out.println(pattern6 + '\t' + "----" + '\t' + myMatch(input, pattern6));
		String pattern7 = "aa.b";
		System.out.println(pattern7 + '\t' + "----" + '\t' + myMatch(input, pattern7));
		String pattern8 = "a*bbb";
		System.out.println(pattern8 + '\t' + "----" + '\t' + myMatch(input, pattern8));

	}

	private static boolean myMatch(String input, String pattern) {
		// �쳣ֵ���
		if (input == null || pattern == null)
			return false;
		// ���õݹ�ķ�ʽʵ��
		return myMatchCore(input, 0, pattern, 0);
	}

	private static boolean myMatchCore(String input, int inputIndex, String pattern, int patIndex) {
		// �ַ���input��ģʽ��patternͬʱ����
		if (inputIndex >= input.length() && patIndex >= pattern.length()) {
			return true;
		}
		// �ַ���inputδ����������ģʽ��pattern������
		if (inputIndex < input.length() && patIndex >= pattern.length()) {
			return false;
		}
		// ģʽ��patternδ�������ַ���input���ܽ����ˣ�Ҳ����û����
		// ģʽ��pattern ���ﵹ���ڶ����ַ���������һ���ַ�Ϊ��*��
		if (patIndex + 1 < pattern.length() && pattern.charAt(patIndex + 1) == '*') {
			// �ַ���input������
			if (inputIndex >= input.length()) {
				return myMatchCore(input, inputIndex, pattern, patIndex + 2);
			}
			// �ַ���input��ģʽ��pattern��δ����

			else {
				// ��ǰ��pattern[parIndex]ֵ ����input[inputIndex]��ֵ
				if (pattern.charAt(patIndex) == input.charAt(inputIndex) || pattern.charAt(patIndex) == '.') {
					return myMatchCore(input, inputIndex, pattern, patIndex + 2)
							|| myMatchCore(input, inputIndex + 1, pattern, patIndex + 2)
							|| myMatchCore(input, inputIndex + 1, pattern, patIndex);
				}
				// ��ǰ��pattern[parIndex]ֵ �� ����input[inputIndex]��ֵ
				else
					return myMatchCore(input, inputIndex, pattern, patIndex + 2);
			}

		}

		// ִ�е�����˵����ƥ�䴮pattern�ڶ����ַ����ǡ�*�������ǿ���֪��ģʽ��δ�������ַ���input���ܽ����ˣ�Ҳ����û����
		// �ַ����Ѿ�����
		if (inputIndex >= input.length()) {
			return false;
		}
		// �ַ���δ������ģʽ��δ���������ҵڶ����ַ����ǡ�*��
		else {
			if (input.charAt(inputIndex) == pattern.charAt(patIndex) || pattern.charAt(inputIndex) == '.')
				return myMatchCore(input, inputIndex + 1, pattern, patIndex + 1);
			else
				return false;
		}
	}
}
