package case60_PrintBinaryTreeByRows;

/**
 * ��Ŀ�����ϵ��°����ӡ��������ͬһ��Ľ�㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�У�
 * ............8...............................................................
 * ........../....\............................................................
 * .........6......10...........................................................
 * ......./..\.../...\..........................................................
 * ......5...7...9....11.........................................................
 * ��ͼ��������ӡ�����
 * 8
 * 6 10
 * 5  7  9  11
 * 
 * @author WangSai
 *
 */
import java.util.ArrayDeque;

public class PrintBinaryTreeByRows {
	/**
	 * ˼·�����ö��аѰ��ղ����������Ԫ�أ���������С�Ȼ����аѵ�һ��Ԫ�س����У�ͬʱ�Ѹ�Ԫ�ص������ӽڵ��Ⱥ�����С�
	 * �����Ϳ���ʵ�ְ��ղ��������������Ϊ��ʵ�ְ����д�ӡ����������Ҫ����������
	 * 1��currentCount,���浱ǰ��ʣ����Ҫ����ӡ��Ԫ�ظ�����2��nextRowsCount,ͳ����һ�е�Ԫ��������
	 * 
	 * @param root,�������ĸ��ڵ�
	 */
	private void getMyRows(MyNode root) {
		if (root == null)
			return;
		// ���ö��б�������������ݣ������е�һ��Ԫ�س����е�ʱ�򣬰���������Ԫ�طֱ�����С�
		ArrayDeque<MyNode> queue1 = new ArrayDeque<>();
		// �Ѷ������ĸ�Ԫ�������
		queue1.offer(root);
		int currentCount = 1;
		int nextRowsCount = 0;
		while (!queue1.isEmpty()) {
			// ȡ�����е�һ��Ԫ�أ�����ӡ
			MyNode tempNode = null;
			tempNode = queue1.poll();
			System.out.print(tempNode.data + " ");
			// ��ǰ����Ҫ����ӡ��Ԫ��-1��
			currentCount--;
			// �ó���Ԫ�ص����ӽڵ�����Ϊnull��������С�������һ��ͳ�Ƶ���Ԫ��+1
			if (tempNode.lchild != null) {
				queue1.offer(tempNode.lchild);
				nextRowsCount++;
			}
			// �ó���Ԫ�ص����ӽڵ�����Ϊnull��������С�������һ��ͳ�Ƶ���Ԫ��+1
			if (tempNode.rchild != null) {
				queue1.offer(tempNode.rchild);
				nextRowsCount++;
			}
			// ����ǰ��Ԫ��ȫ���������У���ӡ���С�
			// ��ʼ��һ�д�ӡ��������ͳ�ơ�
			if (currentCount == 0) {
				System.out.println('\t');
				currentCount = nextRowsCount;
				nextRowsCount = 0;
				// ����Ԫ�ش�ӡ��ϣ�������һ��Ԫ��Ϊ0�����ʾ�Ѿ���ӡ��ϡ�
				if (currentCount == 0 && nextRowsCount == 0) {
					System.out.println("Done");
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		test1();
		System.out.println("***********");
		test2();
		System.out.println("***********");
		test3();
		System.out.println("***********");
	}

	// ��������
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\.../...\..........................................................
	// ......5...7...9....11.........................................................
	private static void test1() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		MyNode N6 = new MyNode(9);
		MyNode N7 = new MyNode(11);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		rbtb.getMyRows(root);
	}

	// б������
	// ............8...............................................................
	// ........../.................................................................
	// .........6..................................................................
	// ......./.....................................................................
	// ......5......................................................................
	private static void test2() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N4 = new MyNode(5);
		root.lchild = N2;
		N2.lchild = N4;
		rbtb.getMyRows(root);
	}

	// ��ͨ������
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\..................................................................
	// ......5...7..................................................................
	private static void test3() {
		PrintBinaryTreeByRows rbtb = new PrintBinaryTreeByRows();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		rbtb.getMyRows(root);
	}

}
