package case42_1ReverseSentence;

import java.util.Stack;

/**
 * ��Ŀ1������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ���������������ַ�����I am a
 * student.���� ������� student. a am I ����
 * 
 * @author WangSai
 *
 */
public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "   I am a student.  ";
		System.out.println("getMySentence1(str): " + getMySentence1(str));
		System.out.println("getMySentence2(str): " + getMySentence2(str));
	}

	/**
	 * ����1������ջ���������ص㴦��
	 * 
	 * @param input,��������ַ���
	 * @return ��ת֮����ַ���
	 */
	private static String getMySentence1(String input) {
		// �쳣ֵ���
		if (input == null)
			return null;
		// �Կո�Ϊ�ָ��������ַ����ֳɶ���ַ����ֱ�ѹ��ջ�С�
		String[] str = input.split(" ");
		Stack<String> stack1 = new Stack<>();
		for (String mystr : str) {
			if (mystr.isEmpty())
				continue;
			stack1.push(mystr);
		}
		StringBuffer sb1 = new StringBuffer();
		// ��ѹ�����֮�������ε�������
		while (stack1.size() > 1) {
			sb1.append(stack1.pop());
			sb1.append(" ");
		}
		// �������һ����ʱ�򣬲���ӿո�
		sb1.append(stack1.pop());
		return sb1.toString();
	}

	/**
	 * ����2���Ե������ַ����ĸߵ�λ��Ȼ�󣬵����ڲ����н�����
	 * 
	 * @param input,��������ַ���
	 * @return ��ת֮����ַ���
	 */
	private static String getMySentence2(String input) {
		if (input == null)
			return null;
		char[] arr = input.toCharArray();
		reverseWord(arr, 0, input.length() - 1);
		int left = 0;
		int right = 0;
		while (left < input.length()) {
			if (arr[left] == ' ') {
				left++;
				right++;
			} else if (right == input.length() || arr[right] == ' ') {
				reverseWord(arr, left, right - 1);
				right++;
				left = right;

			} else {
				right++;
			}
		}
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb1.append(arr[i]);
		}
		return sb1.toString();

	}

	private static void reverseWord(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
