package case34_UglyNumbers;

/**
 * ��Ŀ�����ǰ�ֻ��������2��3 ��5 ��������������Ugly Number�������С�����˳��ĵ�1500�������� ˼·������ж�ÿ�������ǲ��ǳ���
 * 
 * @author WangSai
 *
 */
public class UglyNums {

	public static void main(String[] args) {
		UglyNums myUg = new UglyNums();
		System.out.println(myUg.getUglyNums(1));
	}

	// �����жϴ�1��ʼ��ÿ�������ǲ��ǳ���
	private int getUglyNums(int index) {
		if (index <= 0)
			return -1;
		int numbers = 0;
		int uglyCount = 0;
		while (uglyCount < index) {
			numbers++;
			if (isUgly(numbers))
				uglyCount++;
		}
		// ���س���
		return numbers;
	}

	// ����ĳһ�������ǲ��ǳ���
	private boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return number == 1;
	}

}
