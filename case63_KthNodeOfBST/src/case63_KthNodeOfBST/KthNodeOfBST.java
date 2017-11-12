package case63_KthNodeOfBST;

/**
 * ��Ŀ������һ�ö��������������ҳ����еĵ�K��Ľ�㡣��������ͼ�Ķ����������У����ڵ���ֵ��С˳�����������ֵ��4
 * ............5...............................................................
 * ........../....\............................................................
 * .........3......7...........................................................
 * ......./..\.../...\..........................................................
 * ......2...4...6....8.........................................................
 * 
 * 
 * @author WangSai
 *
 */

public class KthNodeOfBST {

	public static void main(String[] args) {
		KthNodeOfBST kno = new KthNodeOfBST();
		MyNode root = new MyNode(5);
		MyNode N2 = new MyNode(3);
		MyNode N3 = new MyNode(7);
		MyNode N4 = new MyNode(2);
		MyNode N5 = new MyNode(4);
		MyNode N6 = new MyNode(6);
		MyNode N7 = new MyNode(8);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		System.out.println(kno.findKthOfBST(root, 6).data);

	}

	/**
	 * ���������������ӽ�<���ڵ�<���ӽڵ㣬����������������ɽ������򲢻�ȡ��K���ڵ㡣
	 * 
	 * @param root�������������ĸ��ڵ�
	 * @param k��kֵ
	 * @return ��k���������ڵ�
	 */
	private MyNode findKthOfBST(MyNode root, int k) {
		// �쳣ֵ���
		if (root == null || k <= 0)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		int[] temp = { k };
		// ������������ķ���������Եõ���K���ֵ
		return findKthOfBSTCore(root, temp);
	}

	// ͨ���������������
	private MyNode findKthOfBSTCore(MyNode root, int[] temp) {
		MyNode tempNode = null;
		if (root == null)
			return null;
		// �����������б���
		tempNode = findKthOfBSTCore(root.lchild, temp);
		// ��������û���ҵ�
		if (tempNode == null) {
			// ��ǰ�ĸ��������Ҫ�ҵĽ��
			if (temp[0] == 1)
				return root;
			// ��ǰ�ĸ���㲻��Ҫ�ҵĽ�㣬�����Ѿ��ҹ��ˣ����Լ�������һ
			else
				temp[0]--;
		}
		// ��������û���ҵ������ҵ�ǰ�ڵ㲻����Ҫ�ҵĵ㣬Ѱ�����ӽڵ�
		if (tempNode == null)
			tempNode = findKthOfBSTCore(root.rchild, temp);
		return tempNode;
	}

}
