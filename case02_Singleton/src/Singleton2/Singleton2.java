package Singleton2;

/**
 * ����ģʽ ��һ���أ��ʹ�������
 * 
 * @author WangSai
 *
 */
public class Singleton2 {
	private static Singleton2 s = new Singleton2();
	private Singleton2(){
		
	}

	public static Singleton2 getInstance() {
		return s;
	}


}
