package case15_FindKthFromEnd;

public class FindKthFromEnd {
	/**
	 * ��Ҫ���ǵ���� 1�������� 2��KΪ�� 3��K���������нڵ�ĸ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next = null;

		// ����1��һ�α�����ͨ����������ΪK-1�ķ�ʽ����
		int temp = findKthNodeFromEnd(listNode1, 7).val;
		System.out.println(temp);
		// ����2�����α���
		temp = findKthNodeFromEnd2(listNode1, 7).val;
		System.out.println(temp);
	}

	// ����ڵ�ṹ
	public static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

	// ����1��һ�α�����ͨ���������ΪK-1�ı�����õ�����k���ڵ�
	public static ListNode findKthNodeFromEnd(ListNode listN1, int k) {
		// ���������kΪ0
		ListNode firstNode = listN1;
		ListNode secondeNode = null;
		if (listN1 == null || k == 0) {
			return null;
		}
		// ���ǽڵ���������k
		for (int i = 0; i < k - 1; i++) {
			if (firstNode.next != null)
				firstNode = firstNode.next;
			else
				return null;
		}
		secondeNode = listN1;
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			secondeNode = secondeNode.next;
		}

		return secondeNode;
	}

	// ����2�����α���
	public static ListNode findKthNodeFromEnd2(ListNode listN2, int k) {
		int totalNode = 0;
		ListNode bakNode = listN2;
		// ���������kΪ0
		if (listN2 == null || k == 0) {
			return null;
		}
		// ������������ܽ����
		while (listN2 != null) {
			totalNode++;
			listN2 = listN2.next;
		}
		if (totalNode < k)
			return null;
		for (int j = 0; j < totalNode - k; j++) {
			bakNode = bakNode.next;
		}
		return bakNode;
	}

}
