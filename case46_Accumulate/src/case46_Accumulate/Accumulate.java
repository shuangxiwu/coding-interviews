package case46_Accumulate;

/**
 * ��Ŀ����1+2+3+...+n,Ҫ����ʹ�ó˳�����for��while��if��else��switch,case�ȹؼ��ּ������ж����(A?B:C)��
 * 
 * @author WangSai
 *
 */
public class Accumulate {

	public static void main(String[] args) {
		int num = 2;
		System.out.println(mySum(num));
	}

	/**
	 * ˼·���ݹ�+&&
	 * 
	 * ��&&��ʵ�������жϣ�
	 * 
	 * �õݹ�ʵ���ۼ�
	 * 
	 * &&����ı��ʽ�������Ϊboolean�ͣ�����&&�Ҳ�Ҫ��һ���޹ر���a�ж��Ƿ���result��ȣ����Ҳ�ı��ʽ����boolean�͡�
	 * ���ܷ��ص���true����false�����ǵ�Ŀ�Ľ�������&&�Ҳ�ı��ʽִ�С�
	 * &&���ӵı��ʽ������Ҫ�����յ�boolean�������������������뱨��
	 * 
	 * @param args
	 */
	public static int mySum(int n) {
		int result = n;
		int a = 0;
		boolean value = (n > 0) && (a == (result += mySum(n - 1)));
		return result;
	}
}
