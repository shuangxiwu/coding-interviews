package case39_TreeDepth;

/**
 * ��Ŀ1������һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * 
 * @author WangSai
 *
 */
public class TreeDepth {

	/**
	 * ͨ����������ȡ�����������
	 * 
	 * @param root�������ĸ��ڵ�
	 * @return �����������
	 */
	private int getTreeDepth(myTreeNode root) {
		if (root == null)
			return 0;
		int left = getTreeDepth(root.lchild);
		int right = getTreeDepth(root.rchild);
		return left > right ? (left + 1) : (right + 1);
	}

	public static void main(String[] args) {
		// ��ͨ������
		test1();
		// б������
		test2();
		// ֻ��һ���ڵ�
		test3();
		// ͷ���Ϊnull
		test4();
	}

	// ��ͨ������
	private static void test1() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		myTreeNode N2 = new myTreeNode(2);
		myTreeNode N3 = new myTreeNode(3);
		myTreeNode N4 = new myTreeNode(4);
		myTreeNode N5 = new myTreeNode(5);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		System.out.println(td.getTreeDepth(root));
	}

	// б������
	private static void test2() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		myTreeNode N2 = new myTreeNode(2);
		myTreeNode N4 = new myTreeNode(4);
		root.lchild = N2;
		N2.lchild = N4;
		System.out.println(td.getTreeDepth(root));
	}

	// ֻ��һ���ڵ�
	private static void test3() {
		TreeDepth td = new TreeDepth();
		myTreeNode root = new myTreeNode(1);
		System.out.println(td.getTreeDepth(root));
	}

	// ͷ���Ϊnull
	private static void test4() {
		TreeDepth td = new TreeDepth();
		System.out.println(td.getTreeDepth(null));
	}
}
