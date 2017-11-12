package FindNumInArr;

public class FindNumInArr {

	public static void main(String[] args) {
		int[][] arr = new int[5][7];
		System.out.print("[");
		for (int i = 0; i < 5; i++) {
			System.out.print("[");
			for (int j = 0; j < 7; j++) {
				arr[i][j] = i + j * 3;
				System.out.print(arr[i][j] + ",");
			}
			System.out.println("]");
		}
		System.out.println("]");
		boolean find = FindNumIn2DArr(arr, 22);
		System.out.println("22+" + find);

		find = FindNumIn2DArr(arr, 22);
		System.out.println("0+" + find);

		find = FindNumIn2DArr(arr, 25);
		System.out.println("25+" + find);

	}

	public static boolean FindNumIn2DArr(int[][] arr, int key) {
		boolean find = false;
		// ��ȡ��ά���������������
		int rows = arr.length;
		// int columns = arr[0].length;
		// ��ȡ���Ͻǵ�Ԫ�صĽǱ�
		int row = 0;
		int column = arr[0].length - 1;
		if (arr == null)
			return find;
		// �Ӷ�ά�������Ͻǿ�ʼ����
		while (row < rows && column >= 0) {
			if (arr[row][column] == key) {
				find = true;
				break;
			} else if (arr[row][column] > key)
				column--;
			else
				row++;
		}

		return find;
	}

}
