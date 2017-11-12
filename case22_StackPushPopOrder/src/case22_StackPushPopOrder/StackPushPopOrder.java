package case22_StackPushPopOrder;

import java.util.Stack;

/**
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ������С�����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹջ���У�����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * 
 * @author WangSai
 *
 */
public class StackPushPopOrder {

	public static void main(String[] args) {
		int[] arrIn = { 1, 2, 3, 4, 5 };
		int[] arrOut = { 1, 5, 2, 3, 4 };
		System.out.println(isOrder(arrIn, arrOut));
	}

	private static boolean isOrder(int[] arrIn, int[] arrOut) {
		// �쳣ֵ���
		if (arrIn == null || arrOut == null || arrIn.length != arrOut.length || arrIn.length <= 0)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// ��������ջ
		Stack<Integer> stack = new Stack<>();
		int inIndex = 0;
		int outIndex = 0;
		// �����ջԪ�ػ�δ��ȫ�����꣬���������
		while (outIndex < arrOut.length) {
			// ���ջΪ�գ�����ջ��Ԫ�ز����ڳ�ջ���е�Ԫ�أ���һֱ��ջ��ֱ����ջ����ȫ����ջ��ɡ�
			while (stack.empty() || stack.peek() != arrOut[outIndex]) {
				// ��������ջ����Ԫ���Ѿ�ȫ����ջ�����˳���ѭ��
				if (inIndex >= arrIn.length)
					break;
				stack.push(arrIn[inIndex]);
				inIndex++;
			}
			// ִ�е�����ط��������ֿ��ܵ������
			// ���1��ջ��Ԫ��==��ջ����Ԫ��
			// ���2����ջ����ȫ��Ԫ�ض���ջ��ϣ���Ȼû���ҵ����ջ������ͬ��Ԫ�ء�
			// �������2��
			if (stack.peek() != arrOut[outIndex])
				break;
			// ��ջ��Ԫ�����ջ����Ԫ����ͬ�������һ����ջ����Ԫ�ء�
			else {
				stack.pop();
				outIndex++;
			}

		}
		// ִ�е��˴����������
		// ��һ�֣����whileѭ�����ڵ�һ��������˳�����ջ�п϶�����δ��ջ��Ԫ�أ�ջһ����Ϊ�ա�
		// �ڶ��֣����еĳ�ջԪ�ض�����ȷƥ�䣬������Ԫ�ض��ᱻ��ջ�е�����ջһ��Ϊ�ա�
		return stack.empty();
	}

}
