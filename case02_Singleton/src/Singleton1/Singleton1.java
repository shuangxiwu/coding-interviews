package Singleton1;

/**
 * ����ģʽ ����ؽ�����û�д������󡣵�����getInstance����ʱ���Ŵ�������
 * 
 * @author WangSai
 * 
 *
 */
public class Singleton1 {
	private static Singleton1 s = null;

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		if (s == null)
			s = new Singleton1();
		return s;
	}
}