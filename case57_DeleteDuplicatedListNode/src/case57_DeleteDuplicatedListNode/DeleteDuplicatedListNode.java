package case57_DeleteDuplicatedListNode;

/**
 * ��Ŀ����һ������������У����ɾ���ظ��Ľ�㣿���磬����ͼa���ظ��ڵ㱻ɾ��֮��������bͼ��ʾ��
 * 
 * a: N1 ������������> N2 ������������> N3 ������������> N3 ������������> N4 ������������> N4 ������������> N5
 * 
 * b: N1 ������������> N2 ������������> N5
 * 
 * @author WangSai
 *
 */
public class DeleteDuplicatedListNode {

	/**
	 * ����һ��ǰ���ڵ㣬���浱ǰ�ڵ����һ���ڵ㡣������ʱͷ��㣬ָ��ԭ�����ͷ��㡣
	 * 
	 * @param head��ԭ�����ͷ���
	 * @return ɾ���ظ��ڵ�֮����������ͷ���
	 */
	private static ListNode myDelete(ListNode head) {
		// �쳣ֵ����
		if (head == null)
			return null;
		// ��ʱͷ���
		ListNode root = new ListNode();
		// ��ǰ�ڵ��ǰһ���ڵ�
		ListNode pre = root;
		// ��ǰ�ڵ�
		ListNode cur = head;
		root.next = head;

		while (cur != null && cur.next != null) {
			// ���ظ���㣬��curֵ��ͬ�Ľ�㶼Ҫɾ��
			if (cur.data == cur.next.data) {
				// �ҵ���һ����ֵͬ�Ľڵ㣬ע�����п���Ҳ���ظ��ڵ�
				while (cur.next != null && cur.data == cur.next.data) {
					cur = cur.next;
				}
				// ָ����һ���ڵ㣬prev.nextҲ�������ظ����
				// ����prev��Ҫ�ƶ�����һ�����
				pre.next = cur.next;
			} else {
				pre.next = cur;
				pre = pre.next;
			}
			cur = cur.next;
		}
		return root.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ���ظ��ڵ㣬�ظ��ڵ����м�
		test1();
		// ���ظ��ڵ㣬�ظ��ڵ㿪ʼ����
		test2();
		// ���нڵ��ظ�
		test3();
		// û���ظ��ڵ�
		test4();
	}

	/**
	 * ���ظ��ڵ㣬�ظ��ڵ����м�
	 */
	public static void test1() {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("ɾ���ظ��ڵ�֮ǰ��");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("ɾ���ظ��ڵ�֮��");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * ���ظ��ڵ㣬�ظ��ڵ㿪ʼ����
	 */
	public static void test2() {
		ListNode head = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("ɾ���ظ��ڵ�֮ǰ��");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("ɾ���ظ��ڵ�֮��");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * ���нڵ��ظ�
	 */
	public static void test3() {
		ListNode head = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(2);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("ɾ���ظ��ڵ�֮ǰ��");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("ɾ���ظ��ڵ�֮��");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}

	/**
	 * û�нڵ��ظ�
	 */
	public static void test4() {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("ɾ���ظ��ڵ�֮ǰ��");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("ɾ���ظ��ڵ�֮��");
		ListNode node = myDelete(head);
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
		System.out.println("----------------");
	}
}