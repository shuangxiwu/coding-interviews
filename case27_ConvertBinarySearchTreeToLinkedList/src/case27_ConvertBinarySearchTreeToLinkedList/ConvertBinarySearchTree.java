package case27_ConvertBinarySearchTreeToLinkedList;

/**
 * ��Ŀ������һ�ö��������������ö�����ת����һ�������˫������Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 * ����������ͼ�Ķ����������������ת��֮�������˫������
 * 
 * ..............10...............................................................
 * ........../.......\............................................................
 * .........6..........14...........................................................
 * ......./...\....../....\........................................................
 * ......4.....8....12......16.......................................................
 * 
 * ת��֮�������˫������4<==>6<==>8<==>10<==>12<==>14<==>16��
 * 
 * @author WangSai
 *
 */
public class ConvertBinarySearchTree {

	private static TreeNode myConvert(TreeNode root) {
		// �쳣���
		if (root == null)
			return null;
		// ������һ�εĴ���ڵ�
		TreeNode[] lastNode = new TreeNode[1];
		// �������
		myConvertCore(root, lastNode);
		TreeNode temp = lastNode[0];
		// System.out.println(temp.data); //�������֮��lastNode[0]ָ��ԭ�������һ���ڵ�
		// Ѱ���������ͷ���
		while (temp.lchild != null) {
			temp = temp.lchild;
		}
		return temp;
	}

	/**
	 * ������������ķ�ʽ��ɡ��ݹ���á�
	 * 
	 * @param root����ǰ����Ľ��
	 * @param lastNode����һ�δ���Ľ�㡣ʹ������ʱ��Ϊ�����ڶ������ţ��ǹ���ġ�
	 */
	private static void myConvertCore(TreeNode root, TreeNode[] lastNode) {
		// �ݹ�ֹͣ����
		if (root == null)
			return;
		// �ݹ鵱ǰ�ڵ��������
		myConvertCore(root.lchild, lastNode);
		// ��ǰ�ڵ��lchildָ����һ����㣬��root��ǰ���ڵ�ָ����һ�εĽڵ�
		root.lchild = lastNode[0];
		if (lastNode[0] != null) {
			// ǰһ���ڵ�ĺ����ڵ�ָ��ǰ�ڵ㡣
			lastNode[0].rchild = root;
		}
		// ��ǰ����Ľڵ���Ϊ��һ�δ��������һ����㡣
		lastNode[0] = root;
		// �ݹ�������
		myConvertCore(root.rchild, lastNode);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	/**
	 * ��ͨ��������
	 * ..............10...............................................................
	 * ........../.......\............................................................
	 * .........6..........14...........................................................
	 * ......./...\....../....\........................................................
	 * ......4.....8....12......16.......................................................
	 * 
	 */
	public static void test1() {
		TreeNode root = new TreeNode(10);
		TreeNode n6 = new TreeNode(6);
		TreeNode n14 = new TreeNode(14);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n12 = new TreeNode(12);
		TreeNode n16 = new TreeNode(16);
		root.lchild = n6;
		root.rchild = n14;
		n6.lchild = n4;
		n6.rchild = n8;
		n14.lchild = n12;
		n14.rchild = n16;
		TreeNode head = myConvert(root);
		System.out.println("-----��ͨ������--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----��ͨ������--end---");
	}

	/**
	 * б��������
	 * ..............10...............................................................
	 * ........../...................................................................
	 * .........6.....................................................................
	 * ......./.....................................................................
	 * ......4.....................................................................
	 * 
	 */
	public static void test2() {
		TreeNode root = new TreeNode(10);
		TreeNode n6 = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		root.lchild = n6;
		n6.lchild = n4;
		TreeNode head = myConvert(root);
		System.out.println("-----б������--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----б������--end---");
	}

	/**
	 * ֻ��һ���ڵ�Ķ�������
	 * ..............10...............................................................
	 * 
	 */
	public static void test3() {
		TreeNode root = new TreeNode(10);
		TreeNode head = myConvert(root);
		System.out.println("-----ֻ�и��ڵ������--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("-----ֻ�и��ڵ������--end---");
	}

	/**
	 * ������null��
	 * 
	 */
	public static void test4() {
		TreeNode root = null;
		TreeNode head = myConvert(root);
		System.out.println("----null--start---");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rchild;
		}
		System.out.println();
		System.out.println("----null--end---");
	}

}
