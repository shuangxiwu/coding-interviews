package case21_MyStackWithMin;

import java.util.Stack;

/**
 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min�������ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)��
 * 
 * @author WangSai
 *
 */
public class MyStackWithMin {
	/**
	 * 1��˼·��ͨ������ջʵ�֣�����ջstackDataʵ�ִ�����ݣ�����ջstackMinʵ�ִ����С�����ݡ�
	 * 2��ѹջ��ֻҪ�зǿ�Ԫ��������ջ��ѹ��stackData��ͬʱ�жϸ�Ԫ���븨��ջstackMin��ջ��Ԫ�صĴ�С����С�ڵ���stackMinջ��Ԫ�أ�����ջstackMin��
	 * ���򣬲�ѹջ��stackMin��Ԫ�ظ��� ������ stackData��
	 * 3����ջ��stackData��Ϊ��������ջ���ж�stackMin��ջ��Ԫ���Ƿ���stackData�ղŵĳ�ջԪ����ͬ�������ͬ��stackMinջ��Ԫ��Ҳ��ջ��
	 *
	 * @param <T>�����Ͷ�����������
	 */
	public static class MyStack<T extends Comparable<T>> {
		private Stack<T> stackData;
		private Stack<T> stackMin;

		// ���캯��
		public MyStack() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}

		// ʵ��ѹջ
		public void push(T t) {
			// �쳣ֵ��⣬t����Ϊnull
			if (t == null)
				throw new IllegalArgumentException("IllegalArgument");
			// �������ջ��Ϊnull����t�ֱ�ѹ������ջ��
			if (stackData.empty()) {
				stackData.push(t);
				stackMin.push(t);
			}
			// �����Ԫ�� С�ڵ��� stackMin��ջ��Ԫ�أ���ѹ��ջstackMin��
			else if (t.compareTo(stackMin.peek()) <= 0) {
				stackMin.push(t);
				stackData.push(t);
			}
			// ֻҪ����Ԫ�أ�����Ҫѹ��stackData��
			else {
				stackData.push(t);
			}
		}

		// ʵ�ֵ�ջ
		public T pop() {
			if (stackData.empty())
				throw new RuntimeException("Stack is already empty");
			// ֻҪ�е�ջ���󣬾Ͱ�stackDataջ��Ԫ�ص���ȥ
			T t = stackData.pop();
			// ���ջstackData��Ϊnull����stackMin�п϶���Ԫ�ء�
			// ��pop����stackData�е�Ԫ�أ�ǡ��Ҳ����stackMin��ջ��Ԫ�أ���ɾ��stackMin��ջ��Ԫ��
			if (t != null && t == stackMin.peek()) {
				stackMin.pop();
			}
			return t;
		}

		// ��ȡ��Сֵ
		public T min() {
			if (stackData.empty())
				throw new IllegalArgumentException("Stack is already empty");
			return stackMin.peek();
		}
	}

	// ����MyStack
	public static void main(String[] args) {
		MyStack<Integer> stack1 = new MyStack<>();
		// ѹ��3����ȡmin
		stack1.push(3);
		System.out.println("ѹ��3����ȡmin: " + stack1.min());
		// ѹ��4����ȡmin
		stack1.push(4);
		System.out.println("ѹ��4����ȡmin: " + stack1.min());
		// ѹ��5����ȡmin
		stack1.push(5);
		System.out.println("ѹ��5����ȡmin: " + stack1.min());
		// ѹ��0����ȡmin
		stack1.push(0);
		System.out.println("ѹ��0����ȡmin: " + stack1.min());
		// popһ�Σ�����0֮�󣬻�ȡminӦ����3
		System.out.println("pop��1�Σ�       	    " + stack1.pop());
		System.out.println("pop��1��֮�󣬻�ȡmin: " + stack1.min());

		System.out.println("pop��2�Σ�       	    " + stack1.pop());
		System.out.println("pop��3�Σ�       	    " + stack1.pop());
		System.out.println("pop��3��֮�󣬻�ȡmin: " + stack1.min());
		System.out.println("pop��4�Σ�       	    " + stack1.pop());
		System.out.println("pop��5�Σ� " + stack1.pop());
		System.out.println("pop��5��֮�󣬻�ȡmin: " + stack1.min());
	}
}
