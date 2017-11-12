package case52_ArrayConstruction;

/**
 * ��Ŀ������һ������A[0��1��2��...,N-1],�빹��һ������B[0��1��2��...,N-1]������B�е�Ԫ��:
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]*A[n]�������ó�����
 * 
 * @author WangSai
 *
 */
public class ArrayConstruction {

	public static void main(String[] args) {
		double[] A1 = { 1, 2, 3 };
		double[] B1 = multiply(A1);

		MyPrint(B1);
		double[] A2 = { 1, 2 };
		double[] B2 = multiply(A2);
		MyPrint(B2);

		double[] A3 = { 1, 2, 3, 4 };
		double[] B3 = multiply(A3);
		MyPrint(B3);

		double[] A4 = { 0, 2, 3, 4 };
		double[] B4 = multiply(A4);
		MyPrint(B4);
	}

	/**
	 * @param A2
	 * @param B2
	 */
	public static void MyPrint(double[] B) {
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println();
	}

	/**
	 * ��B[i]��ֵ������һ������������
	 * 
	 * @param A������������
	 * @return ���������ĳɼ�����
	 */
	private static double[] multiply(double[] A) {
		// A��������������Ԫ�أ��ſ�������B����
		if (A == null || A.length <= 1) {
			return null;
		}
		// ����B����
		double[] B = new double[A.length];
		// ���ݾ������϶��´���C���顣������ʱ��B���鵱��C����ʹ��
		B[0] = 1;
		for (int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		// ���ݾ������¶��ϴ�������D[i]�������������Ҫ����C[i]*D[i]�õ�B[i]��
		// ���Կ�����һ������temp���D[i],�Ϳ���C[i]*temp�õ�B[i]
		double temp = 1;
		for (int i = A.length - 1 - 1; i >= 0; i--) {
			temp *= A[i + 1];
			// B[i] = C[i]*D[i]
			B[i] = temp * B[i];
		}
		return B;
	}

}
