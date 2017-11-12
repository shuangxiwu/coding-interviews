package case07_StackWithTwoQueues;
/**
 *��Ŀ������������ʵ��ջ������ʵ��ջ��pop,push��empty��top(��ȡջ��Ԫ�أ����ǲ�ɾ��)
 * @author WangSai
 *
 */

import java.util.ArrayDeque;

public class StackWithTwoQueues<T> {
	// �������У���ģ��ʵ��ջ��ʱ��ʼ�ձ�������һ������Ϊ�ա�
	private ArrayDeque<T> queue1;
	private ArrayDeque<T> queue2;

	public StackWithTwoQueues() {
		queue1 = new ArrayDeque<>();
		queue2 = new ArrayDeque<>();
	}

	// ��from������ȡ��Ԫ�أ������������to�С��ڶ���from�б������һ��Ԫ�ء�
	private void move(ArrayDeque<T> from, ArrayDeque<T> to) {
		if (!isEmpty()) {
			while (from.size() > 1) {
				// ��from������ȡ��Ԫ�أ������������to�С��ڶ���from�б������һ��Ԫ�ء�
				to.offer(from.poll());
			}
		}
	}

	// ģ����ջ������queque1ʼ����Ϊ
	public void push(T t) {
		queue1.offer(t);
	}

	// ģ���ջ����,����������ջ��Ԫ�ء�
	public T pop() {
		T top = null;
		if (!isEmpty()) {
			if (!queue1.isEmpty()) {
				move(queue1, queue2);
				top = queue1.poll();
			} else {
				move(queue2, queue1);
				top = queue2.poll();
			}
		}
		return top;
	}

	// ģ��ջ��top����
	public T top() {
		T top = null;
		if (!isEmpty()) {
			if (!queue1.isEmpty()) {
				move(queue1, queue2);
				top = queue1.poll();
				queue2.offer(top);
			} else {
				move(queue2, queue1);
				top = queue2.poll();
				queue1.offer(top);
			}
		}
		return top;
	}

	// ʵ��ջΪ�չ���
	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

	public static void main(String[] args) {
		StackWithTwoQueues<String> myStack = new StackWithTwoQueues<>();
		myStack.push("1st e");
		myStack.push("2nd e");
		myStack.push("3rd e");
		System.out.println("myStack.isEmpty():" + myStack.isEmpty());
		System.out.println("��1�Σ�myStack.pop():" + myStack.pop());
		System.out.println("��3�Σ�myStack.pop():" + myStack.pop());
		System.out.println("myStack.top():" + myStack.top());
		System.out.println("��2�Σ�myStack.pop():" + myStack.pop());
		System.out.println("��4�Σ�myStack.pop():" + myStack.pop());
		System.out.println("myStack.isEmpty():" + myStack.isEmpty());
	}

}
