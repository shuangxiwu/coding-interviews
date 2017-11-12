package case40_NumbersAppearOnce;

public class NumbersAppearOnce {
	/**
	 * ������һ�����������У�����ĳ��������֮�⣬���������ֶ����������Ρ� ��д�����ҳ����������֡�Ҫ��ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(1)
	 * ˼·��
	 * 
	 * ǰ��֪ʶ��
	 * 
	 * 1���κ�һ���������������� ������㣬��������㡣
	 * 
	 * 2���κ����ֺ� 0 ��������㶼�����ֱ���
	 * 
	 * ���ⷽ���� ��������ֻ��1�����ֲ���ͬ�أ�
	 * 
	 * 0���������飬��ͷ��β����������õ��Ľ�������Ǹ�����ͬ�����֡� ����������2�����ֲ���ͬ�أ�
	 * 1���������飬��ͷ��β����������õ��Ľ����Ҫ�ҵ�2����ͬ�����ֵ��������
	 * 2��������������������ַ��䵽�����������У���������Ҳ�ֱ���䵽�������������У�Ȼ���ٷֱ����
	 * 3����Ϊ2����ͬ�����ֻ���䵽ͬһ����������ȥ�������������������Ľ��Ϊ0������Ӱ������ 4���õ��Ľ��
	 * 
	 * @author WangSai
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 5, 1, 2, 3, 3 };
		NumbersAppearOnce nao = new NumbersAppearOnce();
		nao.NumberAppearOnce(arr); // С���ɣ�new����֮�󣬿�����main����÷Ǿ�̬������
	}

	// ������ֻ����1�ε�����
	public void NumberAppearOnce(int[] arr) {
		// �����쳣���
		if (arr == null)
			return;
		if (arr.length < 2)
			return;
		int resultOr = 0;
		int num1 = 0;
		int num2 = 0;
		// �������飬�õ������
		for (int i = 0; i < arr.length; i++) {
			resultOr ^= arr[i];
		}
		int index = FindFirstBitIs1(arr, resultOr);
		// ����reusltOr��λ��һ��Ϊ1��λ�����ж����������ڸ�λ���Ƿ�Ϊ1����Ϊ���顣
		for (int j = 0; j < arr.length; j++) {
			if (isBit1(arr[j], index) == 1) {
				num1 ^= arr[j];
			} else
				num2 ^= arr[j];
		}
		System.out.println(num1);
		System.out.println(num2);
	}

	// Ѱ�ҵڼ�λ��1
	public int FindFirstBitIs1(int[] arr, int resultOr) {
		// ������У���1��λ1�ĵ�λ
		int bitNum = 0;
		while ((resultOr & 1) == 0 && bitNum < Integer.SIZE) {
			resultOr >>>= 1;
			bitNum++;
		}
		return bitNum;
	}

	public int isBit1(int data, int index) {
		data >>>= index;
		return data & 1;
	}

}
