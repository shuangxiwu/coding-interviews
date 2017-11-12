package case37_FindFirstCommonNode;

import java.util.Stack;

/**
 * ��Ŀ���������������ҳ����ǵĵ�һ��������㡣
 * 
 * @author WangSai
 *
 */
public class FindFirstCommonNode {

	/**
	 * ����1��
	 * 
	 * ˼·���ӵ������β�ڵ㿪ʼѰ�ң�����������ֱ�ѹ��ջstack1��stack2�У�Ȼ�����ε���ջ���Ϳ���ʵ�ִ�����β����ʼ�Ƚϡ���Ϊ������ֻ��һ��next���ã�
	 * ���ԣ��ӵ�һ��������㿪ʼ�ͻ��Y�Ρ���β�ڵ㿪ʼ�Ƚϣ�Ѱ�ҵ�һ������ͬ�ĵط������ɡ�
	 * 
	 * @param head1,����1��ͷ���
	 * @param head2������2��ͷ���
	 * @return ����1������2�ĵ�һ��������㡣
	 */
	private static MyNode getMyFirstCommonNode(MyNode head1, MyNode head2) {
		// �쳣ֵ���
		if (head1 == null || head2 == null)
			return null;
		// ��������������Ϊͬһ�������ͷ���
		if (head1 == head2)
			return head1;
		Stack<MyNode> stack1 = new Stack<>();
		Stack<MyNode> stack2 = new Stack<>();
		MyNode myCommonNode = null;
		// ������1ѹ��ջ��
		while (head1 != null) {
			stack1.push(head1);
			head1 = head1.next;
		}
		// ������2ѹ��ջ��
		while (head2 != null) {
			stack2.push(head2);
			head2 = head2.next;
		}
		MyNode stack1Node = stack1.pop();
		MyNode stack2Node = stack2.pop();
		while (!stack1.empty() && !stack2.empty() && stack1Node == stack2Node) {
			myCommonNode = stack1Node;
			stack1Node = stack1.pop();
			stack2Node = stack2.pop();

		}
		return myCommonNode;

	}

	/**
	 * ����2��
	 * 
	 * ˼·�������������й�����㣬���β��һ���غϡ���Ϊ������ֻ��1��next���á��ȷֱ�����1������2�������������ĳ���count1��count2�������Ƚϳ�
	 * ����������ǰ�߼���Math.abs��count1-count2��,Ȼ��һ����������й�����㣬��Ӹý�㿪ʼ������ȫ���غϣ�����Y�Ρ����ɻ�õ�һ��������㡣
	 * 
	 * @param head1,����1��ͷ���
	 * @param head2������2��ͷ���
	 * @return ����1������2�ĵ�һ��������㡣
	 */
	private static MyNode getMyFirstCommonNode2(MyNode head1, MyNode head2) {
		if (head1 == null || head2 == null)
			return null;
		if (head1 == head2)
			return head1;
		MyNode n1 = head1;
		MyNode n2 = head2;
		int count1 = 0, count2 = 0;
		// ��������1����ȡԪ������
		while (n1 != null) {
			n1 = n1.next;
			count1++;
		}
		// ��������2����ȡԪ������
		while (n2 != null) {
			n2 = n2.next;
			count2++;
		}
		// Ԫ�ض���Ǹ������ȿ�ʼ�߼�����Ȼ�󣬵�����ʣ���Ԫ����ͬʱ����ʼ�Ƚϡ�
		int dif = count2 - count1;
		while (dif < 0) {
			head1 = head1.next;
			dif++;
		}
		while (dif > 0) {
			head2 = head2.next;
			dif--;
		}
		while (head1 != null && head2 != null && head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		// ִ�е���һ���������������
		// ���1����Ϊ����Ԫ��head1==head2������head1���ɡ�
		// ���2�����������û����ͬ��Ԫ�ء�
		if (head1 == head2)
			return head1;
		return null;
	}

	public static void main(String[] args) {
		test1();
		System.out.println("test1()*********** over");
		test2();
		System.out.println("test2()*********** over");
		test3();
		System.out.println("test3()*********** over");
		test4();
		System.out.println("test4()*********** over");
	}

	// ����1������2���һ�������ͬ
	// ����1��head1(0)����>N1(1)����>N2(2)����>N3(3)����>null
	// ����2��head2(5)����>M1(6)����>M2(7)����>N3(3)����>null
	private static void test1() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		MyNode M2 = new MyNode(7);
		// MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = M2;
		M2.next = N3;
		System.out.println("����1:head1(0)����>N1(1)����>N2(2)����>N3(3)����>null:");
		System.out.println("����2:head2(5)����>M1(6)����>M2(7)����>N3(3)����>null:");
		System.out.println(getMyFirstCommonNode(head1, head2).data);
		System.out.println(getMyFirstCommonNode2(head1, head2).data);

	}

	// ����1������2�ӵ�һ����㿪ʼ����ͬ,������ͬһ�������ͷ���
	// ����1��head1(9)����>N1(1)����>N2(2)����>N3(3)����>null
	// ����2��head1(9)����>N1(1)����>N2(2)����>N3(3)����>null
	private static void test2() {
		MyNode head1 = new MyNode(9);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		System.out.println("����1:head1(9)����>N1(1)����>N2(2)����>N3(3)����>null:");
		System.out.println("����2:head1(9)����>N1(1)����>N2(2)����>N3(3)����>null:");
		System.out.println(getMyFirstCommonNode(head1, head1).data);
		System.out.println(getMyFirstCommonNode2(head1, head1).data);

	}

	// ����1:head1(0)����>N1(1)����>N2(2)����>N3(3)����>null
	// ����2:head2(5)����>M1(6)����>M2(7)����>M3(8)����>null
	// û�й������
	private static void test3() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		MyNode M2 = new MyNode(7);
		MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = M2;
		M2.next = M3;
		System.out.println("����1:head1(0)����>N1(1)����>N2(2)����>N3(3)����>null:");
		System.out.println("����2:head2(5)����>M1(6)����>M2(7)����>M3(8)����>null:");
		System.out.println(getMyFirstCommonNode(head1, head2));
		System.out.println(getMyFirstCommonNode2(head1, head2));

	}

	// ����1:head1(0)����>N1(1)����>N2(2)����>N3(3)����>null
	// ����2:head2(5)����>M1(6)����>N2(2)����>N3(3)����>null
	// ���в���ʼ��ͬ��
	private static void test4() {
		MyNode head1 = new MyNode(0);
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		head1.next = N1;
		N1.next = N2;
		N2.next = N3;

		MyNode head2 = new MyNode(5);
		MyNode M1 = new MyNode(6);
		// MyNode M2 = new MyNode(7);
		// MyNode M3 = new MyNode(8);
		head2.next = M1;
		M1.next = N2;
		System.out.println("����1:head1(0)����>N1(1)����>N2(2)����>N3(3)����>null:");
		System.out.println("����2:head2(5)����>M1(6)����>N2(2)����>N3(3)����>null:");
		System.out.println(getMyFirstCommonNode(head1, head2).data);
		System.out.println(getMyFirstCommonNode2(head1, head2).data);

	}
}
