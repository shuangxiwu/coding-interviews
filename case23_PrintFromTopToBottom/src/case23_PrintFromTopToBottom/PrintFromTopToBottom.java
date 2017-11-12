package case23_PrintFromTopToBottom;

/**
 * ��Ŀ���������´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ�����磬������ͼ�еĶ���������һ�δ�ӡ��8,6,10,5,7,9,11.
 * 
 * 		   8
 * 	     /   \
 *     6       10
 *   /   \    /   \
 *  5     7   9   11
 *  
 */
import java.util.ArrayDeque;

public class PrintFromTopToBottom {

	/**
	 * �������������
	 * 
	 * @param ��������������
	 * @return
	 */
	public void printTree(myTreeNode headNode) {

		// �쳣ֵ���
		// ��ӡͷ��㣬���Ұ������ӽڵ��Ⱥ��������С�
		// ���ӣ���ӡ��ǰ�Ľڵ㣨���ڵ�����ӣ������Ұѵ�ǰ�ڵ�������ӽڵ���ӡ�
		// �������ӣ���ӡ��ǰ�Ľڵ㣨���ڵ���Һ��ӣ������Ұѵ�ǰ�ڵ�������ӽڵ���ӡ�

		// �쳣ֵ���
		if (headNode == null)
			return;
		// ������������
		ArrayDeque<myTreeNode> myQueue = new ArrayDeque<>();
		// ���ڵ���ӡ�
		myQueue.offer(headNode);
		while (!myQueue.isEmpty()) {
			// ���е�һ��Ԫ�س��ӣ����Ҵ�ӡ���ݡ�
			myTreeNode tempNode = myQueue.poll();
			System.out.print(tempNode.data + " ");
			// ���ӽڵ㲻Ϊnull���������ӡ�
			if (tempNode.lchild != null)
				myQueue.offer(tempNode.lchild);
			if (tempNode.rchild != null)
				myQueue.offer(tempNode.rchild);
		}
	}

	public static void main(String[] args) {
		// ��������
		test1();
		// ֻ�����ӽڵ������
		test2();
		// ֻ�����ӽڵ������
		test3();
	}

	// ��������
	private static void test1() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N1 = new myTreeNode(6);
		myTreeNode N2 = new myTreeNode(10);
		myTreeNode N3 = new myTreeNode(5);
		myTreeNode N4 = new myTreeNode(7);
		myTreeNode N5 = new myTreeNode(9);
		myTreeNode N6 = new myTreeNode(11);
		headNode.lchild = N1;
		headNode.rchild = N2;
		N1.lchild = N3;
		N1.rchild = N4;
		N2.lchild = N5;
		N2.rchild = N6;
		pfttb.printTree(headNode);
		System.out.println();
	}

	// ֻ�����ӽڵ������
	private static void test2() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N2 = new myTreeNode(10);
		myTreeNode N6 = new myTreeNode(11);
		headNode.rchild = N2;
		N2.rchild = N6;
		pfttb.printTree(headNode);
		System.out.println();
	}

	// ֻ�����ӽڵ������
	private static void test3() {
		PrintFromTopToBottom pfttb = new PrintFromTopToBottom();
		myTreeNode headNode = new myTreeNode(8);
		myTreeNode N1 = new myTreeNode(6);
		myTreeNode N3 = new myTreeNode(5);
		headNode.lchild = N1;
		N1.lchild = N3;
		pfttb.printTree(headNode);
		System.out.println();
	}

}
