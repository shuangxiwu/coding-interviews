package case11_Power;

/**
 * ��Ŀ��ʵ�ֺ��� double Power(double base,int exponent)����base��exponent�η���
 * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 * 
 * ��ʵ�ַ���ͨ���ݹ�ķ�ʽ��ɡ�
 * 
 * //a^n=|���� = a^(n/2)*a^(n/2) .............................................. //
 * //....|���� = a^((n-1)/2)*a^((n-1)/2)*a....................................
 * 
 * @author WangSai
 *
 */
public class PowerOp {

	// ͨ���ݹ�ķ�ʽ���
	public double Power3(double base, int exponent) {
		if (isEqual(base, 0.0) && exponent < 0)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// ������ֵ��0���ݶ���1
		if (exponent == 0)
			return 1.0;
		// ��ָ��exponentΪ����ʱ���ȼ�����exponent����ֵΪ�ݵ�ֵ��Ȼ��ȡ������
		if (exponent < 0) {
			return 1 / powerByRe(base, -exponent);
		}
		// ��ָ��exponentΪ����
		else {
			return powerByRe(base, exponent);
		}

	}

	// ���õݹ�ķ�ʽ���exponent���ݵļ��㡣
	private double powerByRe(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		double result = powerByRe(base, exponent >> 1);
		result *= result;
		// ���ָ��nΪ��������Ҫ�ٳ�һ�ε���base
		if ((exponent & 1) == 1)
			result *= base;
		return result;
	}

	// ���жϵ���base�ǲ��ǵ���0ʱ������ֱ��дbase==0�� ������Ϊ�ڼ�����ڱ�ʾС��ʱ������float��double��С����������
	private boolean isEqual(double num1, double num2) {
		if (num1 - num2 > -0.000001 && num1 - num2 < 0.000001)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		PowerOp p = new PowerOp();
		double base = 1.0;
		int exponent = 0;
		System.out.println(base + "^" + exponent + "��  " + p.Power3(base, exponent));
		double base1 = 5.0;
		int exponent1 = 2;
		System.out.println(base1 + "^" + exponent1 + "��  " + p.Power3(base1, exponent1));

		double base3 = 5.0;
		int exponent3 = -2;
		System.out.println(base3 + "^" + exponent3 + "��  " + p.Power3(base3, exponent3));

		double base4 = -2.0;
		int exponent4 = -2;
		System.out.println(base4 + "^" + exponent4 + "��  " + p.Power3(base4, exponent4));

		double base5 = 0.0;
		int exponent5 = -2;
		System.out.println(base5 + "^" + exponent5 + "��  " + p.Power3(base5, exponent5));
	}
}
