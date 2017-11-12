package case25_FindPathInTree;

/**
 * ��Ŀ����Ŀ������һ�ö�������һ�������� ��ӡ���������н��ֵ�ĺ�Ϊ��������������·���������ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 */
import java.util.ArrayList;

public class FindMyPath {

	private void findThePath(MyNode root, int expectedSum) {
		// �쳣ֵ���
		if (root == null)
			throw new IllegalArgumentException("�Ƿ�����");
		ArrayList<Integer> mylist = new ArrayList<>();
		// �ݹ�ʵ�ֵ�ǰ�ڵ����һ���ڵ���ͣ����Ҽ�¼��ǰ�ڵ㵽������
		findThePathCore(root, 0, expectedSum, mylist);
	}

	/**
	 * 
	 * @param root,���������ڵ�
	 * @param currentSum,��ǰ��¼�ĺͣ���δ���ϵ�ǰ����ֵ��
	 * @param expectedSum,�����ĺ�
	 * @param mylist,����㵽��ǰ��������������Ľ�㣬����δ������ǰ��㣩
	 */
	private void findThePathCore(MyNode root, int currentSum, int expectedSum, ArrayList<Integer> mylist) {
		// ��ǰ�ڵ㲻Ϊ�յ�����£�������
		// ��ǰ�ڵ��ֵroot.data,���ϸ��ڵ㵽��һ���ڵ�·�������нڵ��ֵ�ú�
		// �ѵ�ǰ�ڵ��������mylist��
		// �ж�ĿǰΪֹ��õ�currentsum��ֵ
		// �� < expectedSum��������ݹ������ӽڵ�
		// �� == expectedSum,�ж��Ƿ�==expectedSum�������ǰ�ڵ����ӽڵ㣬���ӡ·��
		// ִ�е���һ��˵������ӡ��ɻ��ߵ�ǰ·����������������Ӧ��ɾ�����һ������������Ԫ�ء�
		if (root == null)
			return;
		currentSum += root.data;
		mylist.add(root.data);
		if (currentSum < expectedSum) {
			findThePathCore(root.lchild, currentSum, expectedSum, mylist);
			findThePathCore(root.rchild, currentSum, expectedSum, mylist);

		} else if (currentSum == expectedSum) {
			if (root.lchild == null && root.rchild == null)
				System.out.println(mylist.toString());
		}
		// ɾ��������������Ԫ��
		mylist.remove(mylist.size() - 1);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	// ��ͨ��������������������ֵ
	// 1
	// / \
	// 2 3
	private static void test1() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		N1.lchild = N2;
		N1.rchild = N3;
		System.out.println("��ͨ����������	����������ֵ:");
		fmp.findThePath(N1, 3);
	}

	// ��ͨ��������û������������ֵ
	private static void test2() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		N1.lchild = N2;
		N1.rchild = N3;
		System.out.println("��ͨ��������û��	 ����������ֵ:");
		fmp.findThePath(N1, 10);
	}

	// ֻ��һ���ڵ�Ķ������� �� ����������ֵ
	private static void test3() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		System.out.println("ֻ��һ���ڵ�Ķ������� ��	 ����������ֵ:");
		fmp.findThePath(N1, 1);
	}

	// ֻ��һ���ڵ�Ķ������� û�� ����������ֵ
	private static void test4() {
		FindMyPath fmp = new FindMyPath();
		MyNode N1 = new MyNode(1);
		System.out.println("ֻ��һ���ڵ�Ķ������� û��	 ����������ֵ:");
		fmp.findThePath(N1, 10);
	}

}
