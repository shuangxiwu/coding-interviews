package case45_LastNumberInCircle;

import java.util.LinkedList;

/**
 * ��Ŀ��0,1,...,n-1��n�������ų�1��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ�����֡�
 * 
 * @author WangSai
 *
 */
public class LastNumberInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40000;
		int m = 997;
		System.out.println(lastRemaining1(n, m));
	}

	/**
	 * ����1�����û�������
	 * 
	 * @param n�����ֵĸ���
	 * @param m����m������
	 * @return ���ʣ�µ�����
	 */
	private static int lastRemaining1(int n, int m) {
		// �쳣ֵ���
		if (n < 1 || m < 1) {
			return -1;
		}
		// ��������
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// ��ǰ�����������е�λ��
		int index = 0;
		while (list.size() > 1) {
			// �ƶ�m-1�Σ��Ϳ��Ե����m����
			for (int i = 1; i <= m - 1; i++) {
				index++;
				index %= list.size();
			}
			// ɾ��
			list.remove(index);
			if (index == list.size()) {
				index = 0;
			}
		}
		return list.get(0);
	}
}
