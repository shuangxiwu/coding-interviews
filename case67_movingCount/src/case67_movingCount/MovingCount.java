package case67_movingCount;

/**
 * ��Ŀ��
 * 
 * ��Ŀ�������и�m��n�еķ���һ�������˴�����(0,0)�ĸ��ӿ�ʼ�ƶ�����ÿһ�ο��������ҡ��ϡ����ƶ�һ��
 * �����ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��(35,37)����Ϊ3+5
 * +3+7=18.�������ܽ��뷽��(35,38)����Ϊ3+5+3+8=19.���ʸû������ܹ��ﵽ���ٸ��ӣ�
 * 
 * @author WangSai
 * @Time 2017��6��5��17:16:58
 *
 */
public class MovingCount {

	/**
	 * @param argsm
	 */
	public static void main(String[] args) {
		System.out.println("getMovingCount:" + getMovingCount(4, 6, 6));
	}

	/**
	 * ��ȡ�����˿��Ե���ĸ�����
	 * 
	 * @param threshold������ֵ
	 * @param m�����������
	 * @param n�����������
	 * @return �����˿��Ե���ĸ�������
	 */
	public static int getMovingCount(int threshold, int m, int n) {
		// �쳣ֵ���
		if (m <= 0 || n <= 0 || threshold < 0)
			return -1;
		boolean[] visted = new boolean[m * n];
		return getMovingCountCore(threshold, m, n, 0, 0, visted);
	}

	// �ݹ���ʵ�ǰ�������ܵĸ���
	private static int getMovingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
		// �жϱ߽�ֵ���Ƿ�Խ�磬�Ƿ���ʹ�����������������λ֮���Ƿ����k
		if (row < 0 || row >= rows || col < 0 || col >= cols || visted[row * cols + col]
				|| checkSum(row, col) > threshold)
			return 0;
		visted[row * cols + col] = true;
		return 1 + getMovingCountCore(threshold, rows, cols, row - 1, col, visted)
				+ getMovingCountCore(threshold, rows, cols, row + 1, col, visted)
				+ getMovingCountCore(threshold, rows, cols, row, col - 1, visted)
				+ getMovingCountCore(threshold, rows, cols, row, col + 1, visted);

	}

	/**
	 * ��������������λ֮��
	 * 
	 * @param row,��ǰ���к�
	 * @param col����ǰ���к�
	 * @return row�����col�������λ֮��
	 */
	private static int checkSum(int row, int col) {
		int sum = 0;
		while (row > 0) {
			sum += row % 10;
			row /= 10;
		}
		while (col > 0) {
			sum += col % 10;
			col /= 10;
		}
		return sum;
	}
}