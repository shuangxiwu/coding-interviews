package case66_MatrixPath;

/**
 * 
 * ��ĿҪ��
 * 
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 * 
 * @author WangSai
 * 
 * 
 */
public class MatrixPath {

	public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str1 = "bcced".toCharArray();
		char[] str2 = "abcb".toCharArray();
		System.out.println("true:" + isMatrixPath(matrix, rows, cols, str1));
		System.out.println("false:" + isMatrixPath(matrix, rows, cols, str2));
	}

	/**
	 * ����matrix���Ƿ����str��·��
	 * 
	 * @param matrix,�����ҵľ�����һάģ���ά����
	 * @param rows�����������
	 * @param cols�����������
	 * @param str�������ҵ��ַ���
	 * @return �����ڷ���������·�����򷵻�true;���򣬷���false
	 */
	public static boolean isMatrixPath(char[] matrix, int rows, int cols, char[] str) {
		// �쳣ֵ���
		if (matrix == null || matrix.length <= 0)
			return false;
		boolean[] visted = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isMatrixPathCore(matrix, rows, cols, i, j, 0, str, visted))
					return true;
			}
		}
		return false;
	}

	/**
	 * �ݹ鴦��ǰ���ӵ��ַ��������ܵĸ���
	 * 
	 * @param matrix��������ľ���һά����ģ���ά����
	 * @param rows�����������
	 * @param cols�����������
	 * @param row����ǰ���ӵ��к�
	 * @param col����ǰ���ӵ��к�
	 * @param k���ַ����ĵ�k���ַ�
	 * @param str����������ַ���
	 * @param visted��״̬���飬��ʶ�Ƿ���ʹ���Ӧ�ĸ���
	 * @return ����ǰ���Ӻ�������һ�����ӵ��ַ�����str��·���ַ����򷵻�true�����򣬷���false
	 */
	private static boolean isMatrixPathCore(char[] matrix, int rows, int cols, int row, int col, int k, char[] str,
			boolean[] visted) {
		int index = row * cols + col;
		if (row < 0 || row >= rows || col < 0 || col >= cols // �Ƿ�Խ��
				|| visted[index] // �Ƿ���ʹ�
				|| str[k] != matrix[index]) // ��ǰ�ĸ��ӵ��ַ��Ƿ��str[k]���
			return false;
		// ��־�ø����Ѿ������ʹ�
		visted[index] = true;
		// ���ʹ���·���Ƿ��Ѿ���ȫ�����ַ���str
		if (k == str.length - 1)
			return true;
		// �ڵ�ǰ���ӣ����ĸ�������б���
		if (isMatrixPathCore(matrix, rows, cols, row - 1, col, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row + 1, col, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row, col - 1, k + 1, str, visted)
				|| isMatrixPathCore(matrix, rows, cols, row, col + 1, k + 1, str, visted))
			return true;
		// ���ݷ�
		visted[index] = false;
		return false;
	}
}
