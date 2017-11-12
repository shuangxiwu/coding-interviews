package case07_QueueWithTwoStacks;

import java.util.Stack;

/**
 * ��Ŀ��������ջʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead,�ֱ�����ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ��ܡ�
 * 
 * @author WangSai
 *
 */
public class QueueWith2Stacks<T> {
	// ����ջ��ֻ���ڲ�������
	private Stack<T> stack1;
	// ����ջ��ֻ���ڵ�������
	private Stack<T> stack2;

	public QueueWith2Stacks() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	// ��Ӳ���������ڶ���β������ڵ�
	public void appendTail(T t) {
		stack1.push(t);
	}

	// ɾ������������ڶ���ͷ��ɾ���ڵ�
	public T deleteHead() {
		// ��stack2Ϊ��ʱ����stack1�е�Ԫ��һ�ε�����ѹ��stack2
		// ��stack2��Ϊ��ʱ���Ƚ�stack2�е�Ԫ�ص���ֱ��Ϊ�գ��ٽ�stack1�е�Ԫ�ص���stack2
		if (stack2.empty())
			while (!stack1.empty())
				stack2.push(stack1.pop());
		// �����stack1�е�Ԫ�ص���stack2֮��stack2��ȻΪ�ա��ڶ������Ѿ�û��Ԫ���ˡ�
		if (stack2.empty())
			throw new RuntimeException("����Ϊ��");
		// ɾ��ջ��Ԫ�أ����ҷ��ظ�Ԫ�ء�
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueWith2Stacks<String> myQueue = new QueueWith2Stacks<>();
		myQueue.appendTail("my first string");
		myQueue.appendTail("my second string");
		myQueue.appendTail("my third string");
		System.out.println("��1��ɾ������ͷ������ɾ����Ԫ��Ϊ��" + myQueue.deleteHead());
		System.out.println("��2��ɾ������ͷ������ɾ����Ԫ��Ϊ��" + myQueue.deleteHead());
		System.out.println("��3��ɾ������ͷ������ɾ����Ԫ��Ϊ��" + myQueue.deleteHead());
		System.out.println("��4��ɾ������ͷ������ɾ����Ԫ��Ϊ��" + myQueue.deleteHead());
	}
}
