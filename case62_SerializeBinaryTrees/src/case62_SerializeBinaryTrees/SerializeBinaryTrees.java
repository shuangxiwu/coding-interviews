package case62_SerializeBinaryTrees;

/**
 * ��Ŀ����ʵ�������������ֱ��������л��ͷ����л���������
 * 
 * ˼·������ǰ���������������л��뷴���л�����ν���л�ָ���Ǳ���������Ϊ�ַ�������ν�����л�ָ��������
 * �ַ������¹���ɶ�����������ǰ��������������л�����������Ϊǰ����������ǴӸ���㿪ʼ�ġ����ڱ�������
 * ��ʱ����Nullָ��ʱ����ЩNullָ�뱻���л�Ϊһ��������ַ���#�������⣬���֮�����ֵ�ö��Ÿ�����
 * 
 * @author WangSai
 *
 */
public class SerializeBinaryTrees {

	/**
	 * ���л�����������ǰ������ķ�����
	 * 
	 * @param root,�������Ķ������ĸ��ڵ�
	 * @return ���������л����ַ���
	 */
	public static String Serialize(TreeNode root) {
		// �쳣ֵ���
		if (root == null)
			return null;
		StringBuilder sb = new StringBuilder();
		SerializeCore(root, sb);
		return sb.toString();
	}

	// ǰ�����������
	private static void SerializeCore(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		SerializeCore(root.lchild, sb);
		SerializeCore(root.rchild, sb);
	}

	/**
	 * �����л�������
	 * 
	 * @param str�����������л�֮����ַ���
	 * @return �����л�֮��Ķ�����
	 */
	public static TreeNode Deserialize(String str) {
		if (str == null || str.length() <= 0)
			return null;
		String[] split = str.split(",");
		int[] index = { 0 };
		TreeNode node = DeserializeCore(split, index);
		return node;
	}

	private static TreeNode DeserializeCore(String[] str, int[] index) {
		// ����null�ڵ�
		if (str[index[0]].equals("#"))
			return null;
		if (index[0] >= str.length)
			return null;
		// ����ǰ�ڵ�
		TreeNode root = new TreeNode(Integer.parseInt(str[index[0]]));
		index[0]++;
		root.lchild = DeserializeCore(str, index);
		index[0]++;
		root.rchild = DeserializeCore(str, index);
		return root;
	}

	// ǰ��������������鿴Ч��
	private static void preTraverse(TreeNode node) {
		if (node == null) {
			System.out.print("$,");
			return;
		}
		System.out.print(node.val + ",");
		preTraverse(node.lchild);
		preTraverse(node.rchild);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.lchild = n2;
		root.rchild = n3;
		n2.lchild = n4;
		n2.rchild = n5;
		// ���л�֮����ַ���
		System.out.println("���л�֮����ַ���:");
		String s1 = Serialize(root);
		System.out.println(s1);
		// �����л�������
		TreeNode node = Deserialize(s1);
		System.out.println("�����л�֮��Ķ������������л�֮��鿴�ַ���Ч��:");
		// ǰ�����
		preTraverse(node);
	}
}
