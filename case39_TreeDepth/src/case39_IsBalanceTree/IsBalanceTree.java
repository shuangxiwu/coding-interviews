package case39_IsBalanceTree;

import case39_TreeDepth.myTreeNode;

/**
 * ��Ŀ2������һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ������������ĳ����������һ�����������������������1����ô������һ��ƽ���������
 * 
 * 
 */
public class IsBalanceTree {

	/**
	 * @param root�������ĸ��ڵ�
	 * @return true��ʾ������ƽ�������
	 */
	private static boolean isItBalance1(myTreeNode root) {
		if (root == null)
			return true;
		// ��ȡroot�ڵ���������������
		int left = getTreeDepth(root.lchild);
		int right = getTreeDepth(root.rchild);
		int dif = left - right;
		if (dif < -1 || dif > 1)
			return false;
		else
			return isItBalance1(root.lchild) && isItBalance1(root.rchild);
	}

	/**
	 * ��1�ֽⷨ
	 * 
	 * @param root�������ĸ��ڵ�
	 * @return �����������
	 */
	// ��ȡĳ�ڵ���������
	private static int getTreeDepth(myTreeNode root) {
		// �ݹ���ֹ����
		if (root == null)
			return 0;
		// ��ǰ�ڵ�����������
		int left = getTreeDepth(root.lchild);
		// ��ǰ�ڵ�����������
		int right = getTreeDepth(root.rchild);
		// ��ǰ�ڵ�������������ȴ���Ǹ��ڵ����ֵ+1�����ǵ�ǰ�ڵ�Ľڵ���ȡ�
		return left > right ? left + 1 : right + 1;

	}

	/**
	 * ��2�ֽⷨ���ú�������ķ�ʽ������������ÿһ����㣬�ڱ�����һ�����֮ǰ���Ǿ��Ѿ���������������������
	 * ֻҪ�ڱ���ÿ������ʱ���¼������ȣ�ĳһ������ȵ�������Ҷ�ڵ��·���ĳ��ȣ������ǾͿ���һ�߱���һ���ж�ÿ������ǲ���ƽ��ġ�
	 * 
	 * //�������������
	 * 
	 * @param args
	 */

	private static boolean isItBalance2(myTreeNode root) {
		int[] depth = new int[1];
		return isItBalance2Core(root, depth);

	}

	private static boolean isItBalance2Core(myTreeNode root, int[] depth) {
		// �ڵ�Ϊnull
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		// �жϵ�ǰ�ڵ�����������Ƿ�Ϊƽ������������Ҽ��㵱ǰroot�ڵ����ȡ�
		// ���㷽����ͨ�����沢��ȡroot�������������ֵ�ϴ��ֵ��Ȼ��+1�����ǵ�ǰ�ڵ����ȡ�
		int[] left = new int[1];
		int[] right = new int[1];
		if (isItBalance2Core(root.lchild, left) && isItBalance2Core(root.rchild, right)) {
			int dif = left[0] - right[0];
			if (dif >= -1 && dif <= 1) {
				depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("-----test1()-----:");
		test1();
		System.out.println("-----test2()-----:");
		test2();
		System.out.println("-----test3()-----:");
		test3();
		System.out.println("-----test4()-----:");
		test4();
		System.out.println("-----test5()-----:");
		test5();
	}

	// ��ȫ������
	// 1
	// / \
	// 2 3
	// /\ / \
	// 4 5 6 7
	private static void test1() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n3.lchild = n6;
		n3.rchild = n7;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));

	}

	// ������ȫ������������ƽ�������
	// 1
	// / \
	// 2 3
	// /\ \
	// 4 5 6
	// /
	// 7
	private static void test2() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n5.lchild = n7;
		n3.rchild = n6;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// ����ƽ�������
	// 1
	// / \
	// 2 3
	// /\
	// 4 5
	// /
	// 7
	private static void test3() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n1.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n5.lchild = n7;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// 1
	// /
	// 2
	// /
	// 3
	// /
	// 4
	// /
	// 5
	private static void test4() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		// myTreeNode n7 = new myTreeNode(7);
		n1.lchild = n2;
		n2.lchild = n3;
		n3.lchild = n4;
		n4.lchild = n5;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}

	// 1
	// \
	// 2
	// \
	// 3
	// \
	// 4
	// \
	// 5
	private static void test5() {
		myTreeNode n1 = new myTreeNode(1);
		myTreeNode n2 = new myTreeNode(2);
		myTreeNode n3 = new myTreeNode(3);
		myTreeNode n4 = new myTreeNode(4);
		myTreeNode n5 = new myTreeNode(5);
		// myTreeNode n6 = new myTreeNode(6);
		// myTreeNode n7 = new myTreeNode(7);
		n1.rchild = n2;
		n2.rchild = n3;
		n3.rchild = n4;
		n4.rchild = n5;
		System.out.println(isItBalance1(n1));
		System.out.println(isItBalance2(n1));
	}
}
