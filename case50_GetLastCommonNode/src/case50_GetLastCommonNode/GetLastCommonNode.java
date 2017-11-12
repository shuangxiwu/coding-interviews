package case50_GetLastCommonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * ��Ŀ����������������㣬�����ǵ���͹������ȡ�
 * 
 * @author WangSai
 *
 */
public class GetLastCommonNode {

	/**
	 * 1>:�����Ƕ���������������Ը�������������Ͷ��������ĵ��ص������ɡ�
	 * 
	 * @param root,�������ĸ��ڵ�
	 * @param node1���������е�ָ���ڵ�
	 * @param node2���������е�ָ���ڵ�
	 * @return �������е���͹�������
	 */
	private TreeNode getMyNode1(TreeNode root, TreeNode node1, TreeNode node2) {
		// �쳣ֵ���
		if (root == null)
			return null;
		// �ݹ���ã��жϡ�
		// �����е�ǰ�ڵ��ֵ����node1��node2��ֵ��ʱ����͹������������ӽڵ��С�
		if (root.data > node1.data && root.data > node2.data) {
			return getMyNode1(root.lchild, node1, node2);
		}
		// �����е�ǰ�ڵ��ֵС��node1��node2��ֵ��ʱ����͹������������ӽڵ��С�
		else if (root.data < node1.data && root.data < node2.data) {
			return getMyNode1(root.rchild, node1, node2);
		}
		// �����е�ǰ�ڵ��ֵ����node1��node2��ֵ֮���ʱ�򣬸ýڵ������͹������ȡ�
		else if ((root.data >= node1.data && root.data <= node2.data)
				|| (root.data <= node1.data && root.data >= node2.data)) {
			return root;
		}
		return null;
	}

	/**
	 * 2>:��������ͨ����������ָ�򸸽ڵ��parentָ�롣�����������ת����������ĵ�һ�������ڵ�����⡣
	 * 
	 * @param root,�������ĸ��ڵ�
	 * @param node1���������е�ָ���ڵ�
	 * @param node2���������е�ָ���ڵ�
	 * @return �������е���͹�������
	 */
	private TreeNode getMyNode2(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		// ��������ջ1
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		while (node1 != null) {
			stack1.push(node1);
			node1 = node1.parent;
		}
		// ��������ջ2
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		while (node2 != null) {
			stack2.push(node2);
			node2 = node2.parent;
		}
		while (stack1.size() > 0 && stack2.size() > 0) {
			TreeNode tmp1 = stack1.pop();
			TreeNode tmp2 = stack2.pop();

			if (tmp2.data == tmp1.data) {
				return tmp1;
			}
		}
		return null;
	}

	/**
	 * 3>:��������ͨ����û��ָ�򸸽ڵ��parentָ�롣���ǿ��Դ�ͷ���ڵ㿪ʼ������Ȼ��Ѱ���node1��node2�ڵ��·������������Ȼ��
	 * ����ת����������ĵ�һ�������ڵ�����⡣
	 * 
	 * @param root,�������ĸ��ڵ�
	 * @param node1���������е�ָ���ڵ�
	 * @param node2���������е�ָ���ڵ�
	 * @return �������е���͹�������
	 */
	private static TreeNode getMyNode3(TreeNode root, TreeNode node1, TreeNode node2) {
		// �쳣ֵ���
		if (root == null)
			return null;
		// �����ռ䱣�����node1��·��
		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		// �����ռ䱣�����node2��·��
		ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
		// Ѱ�Ҵ���node1����rootΪ���ڵ�����е�·��
		findPath(root, node1, list1);
		// Ѱ�Ҵ���node2����rootΪ���ڵ�����е�·��
		findPath(root, node2, list2);
		// ��list1�б���Ľڵ���ջ
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Iterator<TreeNode> ite1 = list1.iterator();
		while (ite1.hasNext()) {
			stack1.push(ite1.next());
		}
		// ��list2�б���Ľڵ���ջ
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		Iterator<TreeNode> ite2 = list2.iterator();
		while (ite2.hasNext()) {
			stack2.push(ite2.next());
		}
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			TreeNode n1 = stack1.pop();
			TreeNode n2 = stack2.pop();
			if (n1 == n2)
				return n1;
		}
		return null;
	}

	/**
	 * ��rootΪ���ڵ��������node�ڵ��·����
	 * 
	 * @param root,���ĸ��ڵ�
	 * @param node�����еĽڵ�
	 * @param list,�������node1��·��
	 */
	private static void findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		if (root != node) {
			if (root.lchild == null && root.rchild == null && root.mchild == null) {
				list.remove(list.size() - 1);
				return;
			} else {
				findPath(root.lchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				findPath(root.rchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				findPath(root.mchild, node, list);
				for (TreeNode temp : list) {
					if (temp == node)
						return;
				}
				list.remove(list.size() - 1);
			}
		} else if (root == node) {
			return;
		}
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

	/**
	 * ��ͨ������
	 * ..............1..............................................................
	 * ........../.......\...........................................................
	 * .........2.........3..........................................................
	 * ......./..\......./..\.........................................................
	 * ......4...5......6....7.......................................................
	 * ...../.../..\......./.|.\....................................................
	 * ....8...12..9......13.10.11...................................................
	 */
	private static void test1() {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);

		root.lchild = n2;
		root.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		n3.lchild = n6;
		n3.rchild = n7;
		n4.lchild = n8;
		n5.rchild = n9;
		n5.lchild = n12;
		n7.rchild = n11;
		n7.lchild = n13;
		n7.mchild = n10;

		System.out.print("��ͨ����������͹�������Ϊ 1 ��");
		TreeNode node1 = getMyNode3(root, n8, n11);
		System.out.println(node1.data);
		System.out.print("��ͨ������͹�������Ϊ 7 ��");
		TreeNode node2 = getMyNode3(root, n13, n11);
		System.out.println(node2.data);
		System.out.print("��ͨ��n11Ϊ���еĽڵ㣬��һ���ڵ�Ϊnull����͹�������Ϊ null ��");
		TreeNode node3 = getMyNode3(root, null, n11);
		System.out.println(node3);
	}

	/**
	 * �˻�������
	 * ..............1..............................................................
	 * ........../..................................................................
	 * .........2...................................................................
	 * ......./......................................................................
	 * ......4.......................................................................
	 * ...../.......................................................................
	 * ....8.........................................................................
	 */
	private static void test2() {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);

		root.lchild = n2;
		n2.lchild = n4;
		n2.rchild = n8;

		System.out.print("�˻�Ϊб������͹�������Ϊ 2 ��");
		TreeNode node1 = getMyNode3(root, n8, n4);
		System.out.println(node1.data);
	}
}
