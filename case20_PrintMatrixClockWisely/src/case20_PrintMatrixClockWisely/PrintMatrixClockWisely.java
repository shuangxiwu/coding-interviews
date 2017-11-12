package case20_PrintMatrixClockWisely;

public class PrintMatrixClockWisely {
	/**
	 * ��Ŀ������һ�����󣬰��մ���������˳ʱ���˳���ӡ��ÿһ�����֡� ˼·�� ѭ����ӡ: 1���ȴ�ӡһ�У���1�п϶����ӡ��
	 * 2���ٴ�ӡ��ǰ��������һ�� 3���ٵ����ӡ��ǰ��������һ�� 4���ٵ����ӡ��ǰ����ĵ�һ�� ��ʼ����Ĺ��ɣ�
	 * (0,0),(1,1),(2,2)...(startX,startY),��ʼ�������������ֵ��ȡ� ���� startX<=
	 * (rows-1)/2,startY<=(columns-1)/2 ��ǰ���󣬵�1�� ���� (start,columns-1-start) =>
	 * (start,endX) ��ǰ�������1�� ���� (start+1,rows-1-start) => (start+1,endY)
	 * ��ǰ�������1�� ���� (start,columns-1-start+1) => (start,endX-1) ��ǰ���󣬵�1�� ����
	 * (start+1,columns-1+1) => (start+1,endY-1)
	 * 
	 * @author WangSai
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ʼ������ arr[][]
		int[][] arr = new int[5][6];
		for (int i = 0; i < arr.length; i++) {
			// int tmp = i * 2;
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = i * 6 + j;
				System.out.print(arr[i][j] + " " + '\t');
			}
			System.out.println();
		}
		System.out.println("˳ʱ���ӡ����");
		// ˳ʱ���ӡ���� arr[][]
		printMatrixWisely(arr);
	}

	// ѭ����ӡ
	public static void printMatrixWisely(int[][] arr) {
		if (arr == null || arr.length < 1 || arr[0].length < 1)
			return;
		int start = 0;
		int rows = arr.length;
		int columns = arr[0].length;
		while (2 * start < columns && 2 * start < rows) {
			printMatrix(arr, rows, columns, start);
			start++;
		}
	}

	// ��ӡһȦ
	public static void printMatrix(int[][] arr, int rows, int columns, int start) {
		int endX = columns - 1 - start; // ���һ�е��к�
		int endY = rows - 1 - start; // ���һ�е��к�
		// ��ӡ��Ȧ��һ��
		for (int i = start; i <= endX; i++)
			System.out.print(arr[start][i] + " ");
		// ��ӡ��Ȧ���һ�� �����������У�
		if (start < endY)
			for (int i = start + 1; i <= endY; i++)
				System.out.print(arr[i][endX] + " ");
		// ��ӡ��Ȧ���һ�� ���������������У�
		if ((start < endX) && (start < endY))
			for (int i = endX - 1; i >= start; i--)
				System.out.print(arr[endY][i] + " ");
		// ��ӡ��Ȧ�ĵ�һ�� ���������������У�
		if ((start < endX) && (start < endY - 1))
			for (int i = endY - 1; i >= start + 1; i--)
				System.out.print(arr[i][start] + " ");
	}
}
