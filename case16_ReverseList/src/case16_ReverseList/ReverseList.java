package case16_ReverseList;

public class ReverseList {
	/**
	 * ��ת������Ҫע������� 1�������� 2��ֻ��һ���ڵ� 3�����ڶ���ڵ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = null;
		ListNode listNodeRev2 = ReverseList2(listNode1);
		ListNode l2 = listNodeRev2.next;
		System.out.print(l2.val);
	}

	// ��ת����
	public static ListNode ReverseList2(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode nowListNode = head; // ���浱ǰ�ڵ�
		ListNode preListNode = null; // ��ǰ�ڵ��ǰһ���ڵ�
		ListNode revListNodeHead = null;// ��ǰ�ڵ����һ���ڵ�
		while (nowListNode != null) {
			ListNode nextListNode = nowListNode.next;
			if (nextListNode == null)
				revListNodeHead = nowListNode;
			nowListNode.next = preListNode;
			preListNode = nowListNode;
			nowListNode = nextListNode;
		}
		return revListNodeHead;
	}

	// ���쵥����ڵ�
	public static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
