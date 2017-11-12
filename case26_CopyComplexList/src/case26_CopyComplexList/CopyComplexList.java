package case26_CopyComplexList;

/**
 * ��Ŀ����ʵ�ֺ���ListNode Clone(ListNode root)������һ�����������ڸ��������У� ÿ���ڵ������һ��Next
 * ָ��ָ����һ���ڵ��⣬����һ��siblingָ�������е����������null��
 * 
 * @author WangSai
 *
 */
public class CopyComplexList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexListNode n1 = new ComplexListNode(1);
		ComplexListNode n1_ = new ComplexListNode(1);
		ComplexListNode n2 = new ComplexListNode(2);
		ComplexListNode n2_ = new ComplexListNode(2);
		ComplexListNode n3 = new ComplexListNode(3);
		ComplexListNode n3_ = new ComplexListNode(3);
		n1.next = n1_;
		n1_.next = n2;
		n2.next = n2_;
		n2_.next = n3;
		n3.next = n3_;
		// n3_.next = n4;
		// n4.next = n4_;
		// n4.next = n5;
		// simpleCopy(n1);
		ComplexListNode node = reConnected(n1);
		// while (node != null) {
		// System.out.print(node.data + " ");
		// node = node.next;
		// }

		while (n1 != null) {
			System.out.print(n1.data + " ");
			n1 = n1.next;
		}
	}

	/**
	 * 
	 * @param head,ԭ�����ͷ���
	 * @return ���Ƴ����Ľڵ��ͷ���
	 */
	private static ComplexListNode Clone(ComplexListNode head) {
		// �쳣ֵ���
		if (head == null)
			return null;
		// ��ԭ�����ÿһ���ڵ���渴�Ƴ�һ����ǰһ���ڵ���ͬ�Ľڵ㣬���Ҳ��뵽ǰһ���ڵ���档ֻ����next
		simpleCopy(head);
		// ����sibling
		connectSibling(head);
		// �������
		reConnected(head);
		return null;

	}

	/**
	 * ��ԭ�����ÿһ�ڵ�N���渴��һ���µĽڵ�N'��������ǰһ���ڵ���ͬ��
	 * 
	 * ���Ƴ�����������newlist��N1 ����>N1' ����>N2 ����>N2' ����>N3 ����>N3' ����>N4 ����> N4'
	 * 
	 * @param head��ԭ�����ͷ�ڵ�
	 */
	private static void simpleCopy(ComplexListNode head) {
		while (head != null) {
			// �½��ڵ�
			ComplexListNode temp = new ComplexListNode();
			// Ϊ�½ڵ㸳ֵ��ֵΪ��ǰ�����head�ڵ��ֵ
			temp.data = head.data + 100;
			// ���½ڵ���뵽ԭhead����һ���ڵ��ǰ�档
			temp.next = head.next;
			// ��temp���뵽head����
			head.next = temp;
			// headָ��ԭ�������һ���ڵ�
			head = temp.next;
		}
	}

	/**
	 * �����Ƴ���������newlist(N1����>N1'����>N2����>N2'����>N3����>N3'����>N4����> N4')�е�sibling�ڵ㡣
	 * 
	 * @param head,���Ƴ�����������newlist��ͷ��㡣
	 */
	private static void connectSibling(ComplexListNode head) {
		while (head != null) {
			// head.next:�������б����Ƴ������½ڵ�
			// head.next.next:ԭ������head����һ���ڵ�
			// head.sibling:ԭ�ڵ��sibling�ڵ�
			// head.next.sibling:���Ƴ������½ڵ��sibling�ڵ�
			// head.sibling.next:ԭ�ڵ��sibling�ڵ����һ���ڵ㣬���½ڵ��sibling�ڵ�
			if (head.sibling != null) {
				head.next.sibling = head.sibling.next;
			}
		}
	}

	/**
	 * ��ԭ���Ľڵ�͸��Ƴ������½����в�֡�������ԭ���Ľڵ㣬ż���Ǹ��Ƴ����Ľ�㡣
	 * 
	 * @param head,���Ƴ���������newlist(N1��>N1'��>N2��>N2'��>N3��>N3'��>N4��>N4')��ͷ��㡣
	 * @return ��ĿҪ����½ڵ��ͷ���N1'����N1' ����>N2' ����>N3' ����> N4'��ͷ��㡣
	 */
	private static ComplexListNode reConnected(ComplexListNode head) {

		// ��¼ż�������ɵ������ͷ���
		ComplexListNode newHead = head.next;
		// ָ��ż�����
		ComplexListNode pointer = newHead;
		// ��ԭʼ�������ͷ��������
		ComplexListNode pre = head;

		while (pre != null) {
			pre.next = pre.next.next;
			if (pointer.next == null) {
				pointer.next = null;
			} else {
				pointer.next = pointer.next.next;
			}
			pre = pre.next;
			pointer = pointer.next;
		}
		return newHead;
	}
}
