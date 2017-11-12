package case29_MoreThanHalfNum;

import java.util.HashMap;

public class ByHashMap {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3 };
		System.out.println(moreThanHalf(arr));
	}

	// ���ִ�������һ�������
	private static int moreThanHalf(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���������Ƿ�...");
		// ����map����
		HashMap<Integer, Integer> hp = new HashMap<>();
		// �ѳ��ֵ����ֺ͸����ֳ��ֵĴ����ֱ���Ϊ����ֵ���洢��map��
		for (int j = 0; j < arr.length; j++) {
			if (!hp.containsKey(arr[j]))
				hp.put(arr[j], 1);
			else {
				hp.put(arr[j], hp.get(arr[j]) + 1);
			}
		}
		// ����
		for (Integer key : hp.keySet()) {
			// System.out.println(hp.get(key));
			if (hp.get(key) >= arr.length / 2)
				return key;
		}
		throw new RuntimeException("���������Ƿ�......");

	}
}
