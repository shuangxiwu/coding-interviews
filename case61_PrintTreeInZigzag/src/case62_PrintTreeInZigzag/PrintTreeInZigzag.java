package case62_PrintTreeInZigzag;

import java.util.Stack;

/**
 * ��Ŀ����ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��а��մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ��
 * �������Դ����ơ����簴��֮���δ�ӡ��ͼ�������Ľ��Ϊ��
 * 
 * 1
 * 
 * 3 2
 * 
 * 4 5 6 7
 * 
 * 15 14 13 12 11 10 9 8
 * 
 * ..............1...............................................................
 * ........../.......\............................................................
 * .........2..........3...........................................................
 * ......./...\....../....\........................................................
 * ......4.....5....6......7.......................................................
 * ..../..\../..\../..\..../...\...................................................
 * ...8...9.10..11.12..13.14....15.................................................
 * 
 * @author WangSai
 *
 */
public class PrintTreeInZigzag {
	/**
	 * ������������ջ������һ�����������нڵ㣬��һ������ż���нڵ㡣
	 * �����нڵ㰴�մ����Ҵ�ӡ������Ҫ���մ��ҵ�����ջ��ż���нڵ����ݰ��մ��ҵ����ӡ������Ҫ���մ�������ջ��
	 * 
	 * @param root,����ӡ�������ĸ��ڵ�
	 */
	private void myPrint(MyNode root) {
		// �쳣ֵ���
		if (root == null)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// �������������ֱ𱣴������к�ż��������
		Stack<MyNode> stackOdd = new Stack<>();
		Stack<MyNode> stackEven = new Stack<>();
		stackOdd.push(root);
		// ��������������countToBePrint��ǰ�д���ӡ��Ԫ������;countNextRows��һ�е�Ԫ������
		int countToBePrint = 1;
		int countNextRows = 0;
		// ������ջ����Ϊnullʱ��˵����������δ������ɡ�
		while (!stackOdd.empty() || !stackEven.empty()) {
			MyNode tempNode = new MyNode();
			// stackOdd��ջ���������ݽڵ�,���Ҵ�ӡ��ջ�ڵ�����ݣ�stackEven��ջż���н��
			while (countToBePrint > 0) {
				// stackOdd��ջ,����ӡ��ջ�ڵ�����ݣ���ǰ�д���ӡ��Ԫ������-1��
				tempNode = stackOdd.pop();
				System.out.print(tempNode.data + " " + '\t');
				countToBePrint--;
				// ��ż����ѹջ������ѹ��ڵ�֮��Ԫ���������ӡ�
				if (tempNode.lchild != null) {
					stackEven.push(tempNode.lchild);
					countNextRows++;
				}
				if (tempNode.rchild != null) {
					stackEven.push(tempNode.rchild);
					countNextRows++;
				}
			}
			// ��ӡ��һ��֮�󣬻���
			System.out.println();
			countToBePrint = countNextRows;
			countNextRows = 0;
			// stackEven��ջ�����Ҵ�ӡ��ջ�ڵ�����ݣ�stackOdd��ջ
			while (countToBePrint > 0) {
				tempNode = stackEven.pop();
				System.out.print(tempNode.data + " " + '\t');
				countToBePrint--;
				// �������нڵ�ѹջ������ѹ��ڵ�֮��Ԫ���������ӡ�
				if (tempNode.rchild != null) {
					stackOdd.push(tempNode.rchild);
					countNextRows++;
				}
				if (tempNode.lchild != null) {
					stackOdd.push(tempNode.lchild);
					countNextRows++;
				}
			}
			// ��ӡ��һ��֮�󣬻���
			System.out.println();
			countToBePrint = countNextRows;
			countNextRows = 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test1() :");
		test1();
		System.out.println("test2() :");
		test2();
		System.out.println("test3() :");
		test3();
	}

	// ��������
	// ..............1...............................................................
	// ........../.......\............................................................
	// .........2..........3...........................................................
	// ......./...\....../....\........................................................
	// ......4.....5....6......7.......................................................
	// ..../..\../..\../..\..../...\...................................................
	// ...8...9.10..11.12..13.14....15.................................................
	private static void test1() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(1);
		MyNode N2 = new MyNode(2);
		MyNode N3 = new MyNode(3);
		MyNode N4 = new MyNode(4);
		MyNode N5 = new MyNode(5);
		MyNode N6 = new MyNode(6);
		MyNode N7 = new MyNode(7);
		MyNode N8 = new MyNode(8);
		MyNode N9 = new MyNode(9);
		MyNode N10 = new MyNode(10);
		MyNode N11 = new MyNode(11);
		MyNode N12 = new MyNode(12);
		MyNode N13 = new MyNode(13);
		MyNode N14 = new MyNode(14);
		MyNode N15 = new MyNode(15);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		N3.lchild = N6;
		N3.rchild = N7;
		N4.lchild = N8;
		N4.rchild = N9;
		N5.lchild = N10;
		N5.rchild = N11;
		N6.lchild = N12;
		N6.rchild = N13;
		N7.lchild = N14;
		N7.rchild = N15;

		ptiz.myPrint(root);
	}

	// б������
	// ............8...............................................................
	// ........../.................................................................
	// .........6..................................................................
	// ......./.....................................................................
	// ......5......................................................................
	private static void test2() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N4 = new MyNode(5);
		root.lchild = N2;
		N2.lchild = N4;
		ptiz.myPrint(root);
	}

	// ��ͨ������
	// ............8...............................................................
	// ........../....\............................................................
	// .........6......10...........................................................
	// ......./..\..................................................................
	// ......5...7..................................................................
	private static void test3() {
		PrintTreeInZigzag ptiz = new PrintTreeInZigzag();
		MyNode root = new MyNode(8);
		MyNode N2 = new MyNode(6);
		MyNode N3 = new MyNode(10);
		MyNode N4 = new MyNode(5);
		MyNode N5 = new MyNode(7);
		root.lchild = N2;
		root.rchild = N3;
		N2.lchild = N4;
		N2.rchild = N5;
		ptiz.myPrint(root);
	}
}
