package case58_GetBinaryTreeNextNode;

/**
 * ��Ŀ�� ����һ�ö����������е�һ����㣬����ҳ��������˳�����һ���ڵ㣿���еĽڵ�����������ֱ�ָ�������ӽڵ��ָ�����⣬
 * ����һ��ָ��ָ�򸸽ڵ��ָ�롣
 * 
 * @author WangSai
 *
 */
public class GetBinaryTreeNextNode {

	/**
	 * 
	 * @param root,���ĸ��ڵ�
	 * @param MyNode,�����ҵĽڵ�
	 * @return �������������MyNode�ڵ����һ���ӽڵ�
	 */
	private static BinaryTreeNode getMyInOrderTraverNexNode(BinaryTreeNode root, BinaryTreeNode MyNode) {
		// root||mynodeΪnull
		if (root == null || MyNode == null)
			return null;
		// MyNodeΪ���ڵ�root
		if (root == MyNode) {
			// 1.�� ���ӽڵ�
			if (MyNode.rchild != null) {
				BinaryTreeNode temp = MyNode.rchild;
				while (temp.lchild != null) {
					temp = temp.lchild;
				}
				return temp;
			}
			// 2.�� ���ӽڵ�,û�����ӽڵ�
			// 3.û�������ӽڵ�
			else if (root.rchild == null) {
				return null;
			}
		}
		// MyNode��Ϊ���ڵ�
		else {
			// 1,�ýڵ� �����ӽڵ�
			if (MyNode.rchild != null) {
				BinaryTreeNode temp = MyNode.rchild;
				while (temp.lchild != null) {
					temp = temp.lchild;
				}
				return temp;
			}
			// 2,�ýڵ� û�����ӽڵ�
			else {
				// 1),�ýڵ�Ϊ���ڵ�����ӽڵ�
				if (MyNode == MyNode.parent.lchild)
					return MyNode.parent;
				// 2),�ýڵ�Ϊ���ڵ�����ӽڵ�
				else {
					BinaryTreeNode temp = MyNode;
					if (temp.parent == root) {
						return null;
					}
					// �ýڵ�ĸ��ڵ���ǲ������ӽڵ�,һֱ����Ѱ�Ҹ��ڵ㣬һֱ����ĳһ���ڵ���ӽڵ�
					while (temp.parent != temp.parent.parent.lchild) {
						if (temp.parent.parent == root) {
							return null;
						}
						temp = temp.parent;
					}
					return temp.parent.parent;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("test1--");
		test1();
		System.out.println("test2--");
		test2();
		System.out.println("test3--");
		test3();
		System.out.println("test4--");
		test4();
	}

	// ��ֻ��һ�����ڵ�ʱ
	public static void test1() {
		// ............1...............................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		System.out.println("root����һ���ڵ�:null:" + '\t' + getMyInOrderTraverNexNode(root, root));
	}

	// ���������ڵ㣬���ڵ�����ӽڵ�
	public static void test2() {
		// ............1...............................................................
		// ........../....\............................................................
		// ...............3...........................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N3 = new BinaryTreeNode(3);
		root.rchild = N3;
		N3.parent = root;
		System.out.println("root����һ���ڵ�:3:" + '\t' + getMyInOrderTraverNexNode(root, root).data);
		System.out.println("N3����һ���ڵ�:null:" + '\t' + getMyInOrderTraverNexNode(root, N3));
	}

	// ���������ڵ㣬���ڵ�����ӽڵ�
	public static void test3() {
		// ............1...............................................................
		// ........../....\............................................................
		// ..........2...............................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N2 = new BinaryTreeNode(2);
		root.lchild = N2;
		N2.parent = root;
		System.out.println("root����һ���ڵ�:null:" + '\t' + getMyInOrderTraverNexNode(root, root));
	}

	// ���ж���ڵ�
	public static void test4() {
		// ............1...............................................................
		// ........../....\............................................................
		// .........2......3...........................................................
		// ......./..\.../...\..........................................................
		// ......4...5...6....7.........................................................
		// ...../.....\../......\.......................................................
		// ....8.....9..10......11.......................................................
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode N2 = new BinaryTreeNode(2);
		BinaryTreeNode N3 = new BinaryTreeNode(3);
		BinaryTreeNode N4 = new BinaryTreeNode(4);
		BinaryTreeNode N5 = new BinaryTreeNode(5);
		BinaryTreeNode N6 = new BinaryTreeNode(6);
		BinaryTreeNode N7 = new BinaryTreeNode(7);
		BinaryTreeNode N8 = new BinaryTreeNode(8);
		BinaryTreeNode N9 = new BinaryTreeNode(9);
		BinaryTreeNode N10 = new BinaryTreeNode(10);
		BinaryTreeNode N11 = new BinaryTreeNode(11);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N2.parent = root;
		N3.lchild = N6;
		N3.rchild = N7;
		N3.parent = root;
		N4.lchild = N8;
		N4.parent = N2;
		N5.rchild = N9;
		N5.parent = N2;
		N6.lchild = N10;
		N6.parent = N3;
		N7.rchild = N11;
		N7.parent = N3;
		N8.parent = N4;
		N9.parent = N5;
		N10.parent = N6;
		N11.parent = N7;
		System.out.println("N11����һ���ڵ�:null" + '\t' + getMyInOrderTraverNexNode(root, N11));
		System.out.println("N9����һ���ڵ�:1" + '\t' + getMyInOrderTraverNexNode(root, N9).data);
		System.out.println("N2����һ���ڵ�:5" + '\t' + getMyInOrderTraverNexNode(root, N2).data);
		System.out.println("N8����һ���ڵ�:4" + '\t' + getMyInOrderTraverNexNode(root, N8).data);
		System.out.println("N3����һ���ڵ�:7" + '\t' + getMyInOrderTraverNexNode(root, N3).data);
	}
}
