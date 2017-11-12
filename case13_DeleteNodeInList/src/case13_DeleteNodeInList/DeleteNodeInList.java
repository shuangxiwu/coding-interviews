package case13_DeleteNodeInList;

/**
 * ��Ŀ�������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ㡣
 * 
 * ˼·��
 * 
 * 1��Ҫɾ���Ľڵ���β�ڵ�ʱ��ͨ��������ɾ���ýڵ㡣 *
 * 2���������ж���ڵ㣬Ҫɾ���Ľڵ�NodeP���м�ڵ�ʱ��ͨ��NodeP����һ���ڵ㸲�ǵ�ǰ�ڵ�����ݣ�����NodePָ����һ������һ���ڵ㣬������O(1)ʱ�����ɾ����
 * 3��Ҫɾ���Ľڵ����ڵ�����ֻ��һ���ڵ�ʱ��
 * 
 * ��ע�⣺����������ı��ϵĲ�һ�������ϵ�û�з���ֵ�������ΪJAVA���ô��ݵ�ԭ�����ɾ���Ľ����ͷ��㣬��������÷���ֵ�ķ�ʽ����ôͷ�����Զɾ�����ˡ�
 * 
 * @author WangSai
 *
 */
public class DeleteNodeInList {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeInList del = new DeleteNodeInList();
		MyNode mn1 = new MyNode(111);
		MyNode mn2 = new MyNode(222);
		MyNode mn3 = new MyNode(333);
		MyNode mn4 = new MyNode(444);
		MyNode mn5 = new MyNode(555);
		MyNode mn6 = new MyNode(666);
		mn1.nextNode = mn2;
		mn2.nextNode = mn3;
		mn3.nextNode = mn4;
		mn4.nextNode = mn5;
		mn5.nextNode = mn6;
		mn6.nextNode = null;
		MyNode test = del.deleteNode(mn1, mn6);
		while (test != null) {
			System.out.println(test.data + " ");
			test = test.nextNode;
		}
	}

	// ɾ�������еĽڵ㡣
	private MyNode deleteNode(MyNode headNode, MyNode toBeDeleted) {
		// �쳣������
		if (headNode == null || toBeDeleted == null)
			return headNode;
		// �������ж���ڵ㣬��Ҫɾ���Ľڵ㲻��β�ڵ�
		if (toBeDeleted.nextNode != null) {
			// ��Ҫ��ɾ���Ľڵ�������滻��ǰҪ��ɾ���Ľڵ�����ݡ�
			toBeDeleted.data = toBeDeleted.nextNode.data;
			toBeDeleted.nextNode = toBeDeleted.nextNode.nextNode;
		}
		// ������ֻ��һ���ڵ㣬��Ҫɾ��ͷ��㡣
		else if (headNode == toBeDeleted)
			headNode = null;
		// ������Ҫ�ö���ڵ㣬Ҫɾ���Ľڵ���β�ڵ�
		else if (toBeDeleted.nextNode == null) {
			MyNode tempNode = headNode;
			while (tempNode.nextNode != toBeDeleted) {
				tempNode = tempNode.nextNode;
			}
			tempNode.nextNode = null;
		}
		return headNode;
	}
}
