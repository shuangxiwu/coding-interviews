package case56_EntryNodeOfLoop;

/**
 * ��Ŀ��һ�������а�����������ҳ�������ڽڵ㣿��������ͼ�������У�������ڽڵ��ǽڵ�3��
 * 
 * N1 ����>N2 ����>N3 ����>N4 ����>N5 ����>N6 ����>N7 ����>N8 ����>N9 ����>N10 ����>N11 ����>N12
 * ............^��������������������������<��������������������������<��������������������������<��������������������������v
 * 
 * ˼·��
 * 
 * 1�������ж��������Ƿ��л�����������������ָ�룬fast��slowָ��head��fast�ߵĿ죬slow�ߵ��������л���fast��׷��slow��
 * ���������Ľڵ���ǻ��еĽڵ㡣
 * 
 * 2�����л�����������Ľڵ㿪ʼͳ�ƻ��еĽڵ���n
 * 
 * 3���ٶ�������ָ��p1,p2�������ͷ��ʼ��p1����n����Ȼ��p2��p1һ����ǰ�ߣ�����һ������ʱ�����ǻ����������ڽڵ㡣
 * 
 * @author WangSai
 *
 */
public class EntryNodeOfLoop {

	/**
	 * �ж��������Ƿ���ڻ�����������ָ��һ���ߵ� ��fast��һ���ߵ���slow��������fast������slow�����ˣ�˵�����ڻ������ҷ��������ĵ㡣
	 * ���������򷵻�null��
	 * 
	 * @param head,�����ͷ���
	 * @return ���������Ľڵ㣬�������ڻ��򷵻�null
	 */
	private static ListNode meetingNode(ListNode head) {
		// �쳣���
		if (head == null)
			return null;
		// ��������ָ�룬һ���ߵĿ죬һ���ߵ���
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast == null)
				return null;
			fast = fast.next;

			slow = slow.next;
			if (fast == slow) {
				return slow;
			}
		}
		return null;
	}

	/**
	 * �ҵ������ĵ�󣬼��㻷���ж��ٸ���
	 * 
	 * @param node�����������һ���ڵ�
	 * @return �����ж��ٸ��ڵ�
	 */
	private static int numOfNodeInLoop(ListNode node) {
		if (node == null)
			return 0;
		int count = 1;
		ListNode temp = node;
		temp = temp.next;
		while (node != temp) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * Ѱ�һ�����ڽڵ㡣��������ָ��p1,p2��p1����n����Ȼ��p1 p2һ����ǰ�ߣ�����������ʱ�����ǻ����������ڡ�
	 * 
	 * @param head,�����ͷ���
	 * @param num,�����л��������еĽڵ�����
	 * @return ����Ļ������
	 */

	private static ListNode myEntryNode(ListNode head, int num) {
		// numΪ0��˵��û�л�
		if (num == 0)
			return null;
		// fast����num����Ȼ��slow��fastһ����ǰ�ߡ���fast��slow����ʱ��������ڵĵ㡣
		ListNode fast = head;
		ListNode slow = head;
		while (num > 0) {
			fast = fast.next;
			num--;
		}
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �����л�
		test1();
		// ������û�л�
		test2();
		// ������
		test3();
		// ������������β�ڵ�ָ��ͷ���
		test4();
	}

	/**
	 * �����л�
	 */
	public static void test1() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n8;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3.data);
	}

	/*
	 * ������û�л�
	 */
	public static void test2() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3);
	}

	/*
	 * ������
	 */
	public static void test3() {

		ListNode entryNode1 = myEntryNodeInLoop(null);
		System.out.println(entryNode1);
	}

	/*
	 * ����β�ڵ�ָ��ͷ�ڵ�
	 */
	public static void test4() {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = head;

		ListNode entryNode3 = myEntryNodeInLoop(head);
		System.out.println(entryNode3.data);
	}

	private static ListNode myEntryNodeInLoop(ListNode head) {
		// �Ƿ��л������л��򷵻ػ��е������㣻��û���򷵻�null
		ListNode nodeInloop = meetingNode(head);
		// ͳ�ƻ����ж��ٸ��ڵ�
		int numInLoop = numOfNodeInLoop(nodeInloop);
		System.out.println("�����ж��ٸ��ڵ㣺" + numInLoop);
		// ���ػ�����ڽڵ�
		ListNode entryNode = myEntryNode(head, numInLoop);
		return entryNode;
	}
}
