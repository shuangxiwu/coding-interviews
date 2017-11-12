package case55_FirstCharInStream;

import java.util.LinkedHashMap;

/**
 * ��Ŀ����ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ���go��ʱ����һ��ֻ����һ�ε��ַ��ǡ�g����
 * ���Ӹ��ַ����ж���ǰ�����ַ���google��ʱ����һ��ֻ����һ�ε��ַ��ǡ�l����
 * 
 * @author WangSai
 *
 */
public class FirstCharInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("findMyFirsChar1   :");
		System.out.println(findMyFirsChar1("g") + " : " + "g");
		System.out.println(findMyFirsChar1("go") + " : " + "go");
		System.out.println(findMyFirsChar1("goo") + " : " + "goo");
		System.out.println(findMyFirsChar1("goog") + " : " + "goog");
		System.out.println(findMyFirsChar1("googl") + " : " + "googl");
		System.out.println(findMyFirsChar1("google") + " : " + "google");
		System.out.println("new CharStatistics().findFisrtCharInStream:vvvvv");
		System.out.println(new CharStatistics().findFisrtCharInStream("g") + ":" + "g");
		System.out.println(new CharStatistics().findFisrtCharInStream("go") + ":" + "go");
		System.out.println(new CharStatistics().findFisrtCharInStream("goo") + ":" + "goo");
		System.out.println(new CharStatistics().findFisrtCharInStream("goog") + ":" + "goog");
		System.out.println(new CharStatistics().findFisrtCharInStream("googl") + ":" + "googl");
		System.out.println(new CharStatistics().findFisrtCharInStream("google") + ":" + "google");
	}

	/**
	 * 
	 * @param str����������ַ�
	 * @return ��һ�����ظ����ַ�
	 */
	private static char findMyFirsChar1(String str) {
		// �쳣ֵ���
		if (str == null)
			throw new IllegalArgumentException("�Ƿ���������������¼��...");
		// ��ȡ�ַ������ַ������Ұ��ն�ȡ��˳�����δ��������У��������ַ���ֵ�ǳ��ֵĴ���
		int len = str.length();
		LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
		for (int i = 0; i < len; i++) {
			// �����в����ڣ������
			char key = str.charAt(i);
			// ÿ��ȡһ���ַ������ж��������Ѿ����ڵĲ��ظ��ĵ�һ��������valueΪ1�ļ�
			if (!lhm.containsKey(key)) {
				lhm.put(key, 1);
			}
			// �������Ѿ�������ֵ��Ϊ-1
			else
				lhm.put(key, -1);
		}
		char theKey = '#';
		for (Character key : lhm.keySet()) {
			if (lhm.get(key) == 1) {
				theKey = key;
				return theKey;
			}
		}
		return theKey;
	}

	/**
	 * �Լ�������ϣ��������ʵ��O(1)ʱ������ַ��� ʵ���ַ����в��ҵ�һ�����ظ������֡�
	 * 
	 * @author WangSai
	 *
	 */
	public static class CharStatistics {
		// ���������������洢�ַ����ַ����е�λ�ã����ַ���Ӧ��intֵ��Ϊarr�ĽǱꡣ
		// �����е�ֵ��ʼ��Ϊ-1�������ظ���ֵ��ʱ��-2��ֻ����һ�δ洢�ַ����ַ����е�λ�ýǱꡣ
		int[] arr = new int[255];
		// �ַ����ĽǱ꣬Ĭ��Ϊ0�Ǳ�
		int strIndex = 0;

		// ��������ʱ����ʼ����������arr
		public CharStatistics() {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = -1;
			}
		}

		public char findFisrtCharInStream(String str) {
			// �쳣ֵ���
			if (str == null)
				throw new IllegalArgumentException("�Ƿ���������������¼��...");
			// ����str�����ַ������ַ�������ʽ��Insert����
			for (int i = 0; i < str.length(); i++) {
				// ���ַ������ַ�������ʽ��Insert����
				Insert(str.charAt(i));
			}
			char theKey = '#';
			// ��ȡarr�е���С�Ǹ�ֵ
			int minIndex = Integer.MAX_VALUE;
			// ��������arr����ȡ��С�ĽǱ�
			for (int i = 0; i < arr.length; i++) {
				// �����Ϊ�Ǳ꣬����Ϊ��������˵�����ֶ���ֻ������һ�Ρ�
				if (arr[i] >= 0) {
					if (arr[i] < minIndex) {
						minIndex = arr[i];
						theKey = (char) i;
					}
				}
			}

			return theKey;
		}

		// ������ַ����ж�����ÿһ���ַ������ж�֮ǰ�Ƿ���ֹ���arr�д洢��-1(û�г��ֹ�), -2(���ֹ�����2��) ,
		// strindexֵ(ֻ���ֹ�һ���Ҹ�ֵΪ��str�еĽǱ�)��
		private void Insert(char ch) {
			int arrIndex = (int) ch;
			if (arr[arrIndex] == -1) {
				arr[arrIndex] = strIndex;
			}
			// ch�Ѿ����ֹ�1�λ��߳��ֹ����
			else {
				arr[arrIndex] = -2;
			}
			strIndex++;
		}
	}

}
