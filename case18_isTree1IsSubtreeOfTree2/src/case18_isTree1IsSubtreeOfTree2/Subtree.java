package case18_isTree1IsSubtreeOfTree2;

public class Subtree {

	// (tree2,tree1) ��tree1�Ƿ���tree2������
	// tree2:.................tree1:
	// ..........8................8
	// ....... /...\ .......... /....\
	// .......8.....7..........9......2
	// ...../...\
	// ....9.....2
	// ........./..\
	// ........4....7
	/**
	 * ����tree2��Ѱ������tree1�ĸ�ֵ�ڵ���ͬ�Ľڵ㡣
	 * 
	 * @param tree2���ο��Ĵ�һ�����
	 * @param tree1����
	 * @return true��tree1��tree2������
	 */
	private static boolean isTree1IsSubtreeOfTree2(myTreeNode tree2, myTreeNode tree1) {
		// �쳣������
		if (tree1 == null)
			return true;
		if (tree2 == null)
			return false;
		//
		boolean result = false;
		if (tree1.data == tree2.data)
			result = isDoesSubtree(tree2, tree1);
		if (!result)
			result = isTree1IsSubtreeOfTree2(tree2.lchild, tree1);
		if (!result)
			result = isTree1IsSubtreeOfTree2(tree2.rchild, tree1);

		return result;
	}

	/**
	 * �ж���RΪ���ڵ������tree2��tree1�Ƿ������ͬ���ӽṹ��
	 * 
	 * @param tree2,�ο�����R�ڵ�
	 * @param tree1,�����Ľڵ�
	 * @return true,tree1��tree2������
	 */

	private static boolean isDoesSubtree(myTreeNode tree2, myTreeNode tree1) {
		// ��һ��˵�� tree1�Ѿ������ӽڵ�
		if (tree1 == null)
			return true;
		// ��һ��˵�� tree2�Ѿ������ӽڵ㣬����tree1û�е����ӽڵ�
		if (tree2 == null)
			return false;
		if (tree2.data != tree1.data)
			return false;
		// �ݹ��ж�tree1�����ӽڵ㣬tree2�����ӽڵ㣬�����Ƿ����
		boolean left = isDoesSubtree(tree2.lchild, tree1.lchild);
		// �ݹ��ж�tree1�����ӽڵ㣬tree2�����ӽڵ㣬�����Ƿ����
		boolean right = isDoesSubtree(tree2.rchild, tree1.rchild);
		return left && right;

	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	// ��ͨ����������B����A������
	// �������ǽڵ�ֵ����ĸΪ�ڵ����ƣ�
	// 1 a 2j
	// / \ / \
	// 2b 3c 4k 5l
	// /\ / \
	// 4d 5e 6f 7g
	private static void test1() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(4);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("//��ͨ����������B����A������--test1():");
		System.out.println(isTree1IsSubtreeOfTree2(a, j));
	}

	// ��ͨ����������B �� ����A������
	// �������ǽڵ�ֵ����ĸΪ�ڵ����ƣ�
	// ��A�� ��B
	// 1 a 2j
	// / \ / \
	// 2b 3c 3k 5l
	// /\ / \
	// 4d 5e 6f 7g
	private static void test2() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(3);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("��ͨ����������B �� ����A������--test2():");
		System.out.println(isTree1IsSubtreeOfTree2(a, j));
	}

	// ��ͨ����������B����ͨ����������A��null
	// �������ǽڵ�ֵ����ĸΪ�ڵ����ƣ�
	// ��A�� ��B��Ϊnull
	// 1 a
	// / \
	// 2b 3c
	// /\ / \
	// 4d 5e 6f 7g
	private static void test3() {
		myTreeNode j = new myTreeNode(2);
		myTreeNode k = new myTreeNode(4);
		myTreeNode l = new myTreeNode(5);
		j.lchild = k;
		j.rchild = l;
		System.out.print("��B����ͨ����������A��null--test3():");
		System.out.println(isTree1IsSubtreeOfTree2(null, j));
	}

	// ��ͨ����������B null����A����ͨ������
	// �������ǽڵ�ֵ����ĸΪ�ڵ����ƣ�
	// ��A��null, ��B:
	// 2j
	// / \
	// 4k 5l
	private static void test4() {
		myTreeNode a = new myTreeNode(1);
		myTreeNode b = new myTreeNode(2);
		myTreeNode c = new myTreeNode(3);
		myTreeNode d = new myTreeNode(4);
		myTreeNode e = new myTreeNode(5);
		myTreeNode f = new myTreeNode(6);
		myTreeNode g = new myTreeNode(7);
		a.lchild = b;
		a.rchild = c;
		b.lchild = d;
		b.rchild = e;
		e.lchild = f;
		e.rchild = g;
		System.out.print("��B null����A����ͨ������--test4():");
		System.out.println(isTree1IsSubtreeOfTree2(a, null));
	}

}
