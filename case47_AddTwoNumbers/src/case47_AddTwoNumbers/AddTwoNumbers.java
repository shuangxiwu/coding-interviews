package case47_AddTwoNumbers;

/**
 * ��Ŀ��дһ������������������֮�ͣ�Ҫȥ�ں������ڲ���ʹ��+ - * / ����������š�
 * 
 * ˼·�������ʮ���ƵĴ�������
 * 
 * ��1����������������λ�ļӷ����� 5+17= ��5+7=2��+��0+10=10��=12�� ��2���������λ��5+7����λΪ10��
 * ��3�����ѵ�һ���͵ڶ����Ľ���������������Եõ�������Ҫ��Ľ����
 * 
 * ��������ƣ���1������Ч�ڶ������е����Ч������2�����������ְ�λ����֮������һλ�����Եõ���λ����3�����ѵ�һ���͵ڶ����Ľ����ͣ����ظ�ǰ���ֵ��
 * ֱ����������λΪֹ��
 * 
 * @author WangSai
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		int num1 = 16;
		int num2 = 97;
		System.out.println("getMySum(" + num1 + "," + num2 + ")  =" + '\t' + getMySum(num1, num2));
		num1 = 16;
		num2 = -97;
		System.out.println("getMySum(" + num1 + "," + num2 + ")  =" + '\t' + getMySum(num1, num2));
	}

	/**
	 * ���üӼ��˳����ӷ�
	 * 
	 * @param num1,������
	 * @param num2,����
	 * @return num1��num2�ĺ�
	 */
	private static int getMySum(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}

}
