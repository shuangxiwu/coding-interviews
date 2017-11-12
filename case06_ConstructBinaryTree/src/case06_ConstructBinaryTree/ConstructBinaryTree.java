package case06_ConstructBinaryTree;

public class ConstructBinaryTree {

	/**
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж��������ظ������֡� ���磺
	 * �����ǰ���������{1,2,4,7,3,5,6,8} ����ĺ����������{4,7,2,1,5,3,8,6} �ؽ������¶����������������ͷ��㡣
	 * 1 / \ 2 3 / / \ 4 5 6 \ / 7 8
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
		System.out.println();
		test2();
		System.out.println();
		test3();
		System.out.println();
		test4();
		System.out.println();
		test5();
		System.out.println();
		test6();
		System.out.println();
		test7();
		System.out.println();
	}

	/**
	 * 
	 * @param preArr
	 *            ǰ���������
	 * @param inArr
	 *            �����������
	 * @return �ؽ���������ͷ���
	 */
	public static BinaryTreeNode construct(int[] preArr, int[] inArr) {
		// ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
		if (preArr == null || inArr == null || preArr.length != inArr.length || preArr.length < 1)
			return null;
		return constructTree(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
	}

	/**
	 * 
	 * @param preArr
	 *            ǰ���������
	 * @param pStartIndex
	 *            ǰ������Ŀ�ʼλ��
	 * @param pEndIndex
	 *            ǰ������Ľ���λ��
	 * @param inArr
	 *            �б�������
	 * @param iStartIndex
	 *            ��������Ŀ�ʼλ��
	 * @param iEndIndex
	 *            ��������Ľ���λ��
	 * @return root �������ĸ��ڵ�
	 */
	public static BinaryTreeNode constructTree(int[] preArr, int pStartIndex, int pEndIndex, int[] inArr,
			int iStartIndex, int iEndIndex) {

		BinaryTreeNode root = new BinaryTreeNode();
		// ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����
		if (pStartIndex > pEndIndex)
			return null;
		// ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ����
		root.data = preArr[pStartIndex];
		int index = iStartIndex;
		while (index <= iEndIndex && inArr[index] != root.data) {
			index++;
		}
		if (index > iEndIndex)
			throw new RuntimeException("input invalid.");

		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-iStartIndex ��
		// ��������Ӧ��ǰ�������λ����[pStartIndex+1, pStartIndex+index-iStartIndex]
		// ��������Ӧ�����������λ����[iStartIndex, index-1]
		root.lchild = constructTree(preArr, pStartIndex + 1, index - iStartIndex + pStartIndex, inArr, iStartIndex,
				index - 1);
		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����iEndIndex-index��
		// ��������Ӧ��ǰ�������λ����[pStartIndex+index-iStartIndex+1, pEndIndex]
		// ��������Ӧ�����������λ����[index+1, iEndIndex]
		root.rchild = constructTree(preArr, pStartIndex + index - iStartIndex + 1, pEndIndex, inArr, index + 1,
				iEndIndex);

		return root;
	}

	// *****����start*****//

	// �������������
	public static void printTree(BinaryTreeNode btn) {
		if (btn != null) {
			printTree(btn.lchild);
			System.out.print(btn.data + " ");
			printTree(btn.rchild);
		}
	}

	// ��ͨ������
	// 1
	// / \
	// 2 3
	// / / \
	// 4 5 6
	// \ /
	// 7 8
	private static void test1() {
		int[] preArr = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inArr = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// ���н�㶼û�����ӽ��
	// 1
	// /
	// 2
	// /
	// 3
	// /
	// 4
	// /
	// 5
	private static void test2() {
		int[] preArr = { 1, 2, 3, 4, 5 };
		int[] inArr = { 5, 4, 3, 2, 1 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// ���н�㶼û�����ӽ��
	// 1
	// \
	// 2
	// \
	// 3
	// \
	// 4
	// \
	// 5
	private static void test3() {
		int[] preArr = { 1, 2, 3, 4, 5 };
		int[] inArr = { 1, 2, 3, 4, 5 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// ����ֻ��һ�����
	private static void test4() {
		int[] preArr = { 1 };
		int[] inArr = { 1 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// ��ȫ������
	// 1
	// / \
	// 2 3
	// / \ / \
	// 4 5 6 7
	private static void test5() {
		int[] preArr = { 1, 2, 4, 5, 3, 6, 7 };
		int[] inArr = { 4, 2, 5, 1, 6, 3, 7 };
		BinaryTreeNode root = construct(preArr, inArr);
		printTree(root);
	}

	// �����ָ��
	private static void test6() {
		construct(null, null);
	}

	// ������������в�ƥ��
	private static void test7() {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		int[] inorder = { 4, 2, 8, 1, 6, 3, 7 };
		BinaryTreeNode root = construct(preorder, inorder);
		printTree(root);
	}

	// *****���� end*****//
}
