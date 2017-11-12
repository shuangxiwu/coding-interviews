package case11_Power;

/**
 * ��Ŀ��ʵ�ֺ��� double Power(double base,int exponent)����base��exponent�η���
 * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 * 
 * ��ʵ�ַ��������ٶȱȽ�������Ҫһ��һ�ε��۳ˡ�
 * 
 * @author WangSai
 *
 */
public class Power {

	// 1������exponentΪ������0�����������
	// 2,����baseΪ0��eΪ���������
	// 3���ж�˫������Ϊ0,������"=="��������С��ĳһ��0.000001��Ϊ0.0
	/**
	 * 
	 * @param base������
	 * @param exponent��ָ��
	 * @return ������ָ������
	 */
	public double PowerBaseExponent(double base, int exponent) {
		// 0�ĸ�������
		if (isEqual(base, 0.0) && exponent < 0)
			throw new IllegalArgumentException("�Ƿ�����������������¼��...");
		// ��������0����
		if (exponent == 0)
			return 1.0;
		// ��ָ��Ϊ��������ת��Ϊ����ֵ֮�󣬰�����ָ�����м��㣬Ȼ��1/result
		if (exponent < 0) {
			int absExponent = -exponent;
			return 1 / powerWithUnsignedE(base, absExponent);
		}
		return powerWithUnsignedE(base, exponent);

	}

	// ����ָ��Ϊ�����������
	private double powerWithUnsignedE(double base, int absExponent) {
		double result = 1.0;
		for (int i = 1; i <= absExponent; i++)
			result *= base;
		return result;
	}

	// ���жϵ���base�ǲ��ǵ���0ʱ������ֱ��дbase==0�� ������Ϊ�ڼ�����ڱ�ʾС��ʱ������float��double��С����������
	private boolean isEqual(double a, double b) {
		if ((a - b < 0.0000001) && (a - b > -0.0000001))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Power p = new Power();
		double base = 1.0;
		int exponent = 0;
		System.out.println(base + "^" + exponent + "��  " + p.PowerBaseExponent(base, exponent));
		double base1 = 5.0;
		int exponent1 = 2;
		System.out.println(base1 + "^" + exponent1 + "��  " + p.PowerBaseExponent(base1, exponent1));

		double base3 = 5.0;
		int exponent3 = -2;
		System.out.println(base3 + "^" + exponent3 + "��  " + p.PowerBaseExponent(base3, exponent3));

		double base4 = -2.0;
		int exponent4 = -2;
		System.out.println(base4 + "^" + exponent4 + "��  " + p.PowerBaseExponent(base4, exponent4));

		double base5 = 0.0;
		int exponent5 = -2;
		System.out.println(base5 + "^" + exponent5 + "��  " + p.PowerBaseExponent(base5, exponent5));
	}
}
