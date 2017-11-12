package case51_FindDuplicateNumbers;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ��Ŀ����һ������Ϊn�������е��������ֶ���0~n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ�
 * ���ҳ�����������һ���ظ������֡����磬������볤��Ϊ7������{2,3,1,0,2,5,3},��ô��Ӧ��������ظ�������2����3��
 * 
 * @author WangSai
 *
 */
public class FindDuplicateNumbers {

	/**
	 * ����1������map����ʵ�֡�����arr[]���ѱ�������������Ϊmap�ļ�����map�������������ظ������иü���˵���ظ�
	 * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
	 * 
	 * @param arr,Ҫ������������
	 */
	private void findTheNumbers(int[] arr) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ�����������������¼��");
		// ����arr[]���ѱ�������������Ϊmap�ļ�����map�������������ظ������иü���˵���ظ���
		HashMap<Integer, Integer> hp = new HashMap<>();
		for (Integer key : arr) {
			if (!hp.containsKey(key))
				hp.put(key, 1);
			else
				hp.put(key, hp.get(key) + 1);
		}
		// ����hp�ļ�set���ϣ���>1��value��key���浽set��
		HashSet<Integer> hs = new HashSet<>();
		for (Integer key : hp.keySet()) {
			int value = hp.get(key);
			if (value > 1)
				hs.add(key);

		}
		System.out.println(hs.toString());

	}

	/**
	 * ����2����ԭ����Ļ����ϣ�ͨ���жϵ�ǰ�����Ƿ���ϵ�ǰ��λ���жϡ�
	 * 
	 * ����ע�⵽�����е����ֶ���0��n-1�С� ������������û���ظ������֣���ô����������֮������i���������±�Ϊi��λ�á��������������ظ���
	 * ���֣���Щλ�ÿ��ܴ��ڶ�����֣�ͬʱ��Щλ�ÿ� ��û�����֡� ���������� ����������飬��Ȼ��ͷ��βһ��ɨ����������е�ÿ�����֡���ɨ�赽
	 * �±�Ϊi������ʱ�����ȱȽ�������֣���m��ʾ���ǲ��ǵ���i������ǣ�����ɨ����һ�����֡�������ǣ��������͵�m�����ֽ��бȽϡ� ������͵�
	 * m��������ȣ����ҵ���һ�� �ظ��� ���֣����������±�Ϊi��m��λ�ö������ˣ���������͵�m�����ֲ���ȣ��Ͱѵ�i�����ֺ͵�m�����ֽ�������m
	 * �ŵ������� ��λ �á����������ض�����Ƚϡ������Ĺ��̣�ֱ�����Ƿ���һ ���ظ������֡�
	 * 
	 * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	 * 
	 * @param arr��ҪѰ�ҵ�����
	 * @return true��arr�������ظ�������
	 */
	private boolean findTheNumbers2(int[] arr) {
		// �쳣ֵ���
		if (arr == null || arr.length <= 0)
			throw new IllegalArgumentException("�Ƿ������������¼��...");
		// �����Ƿ����ظ�������
		boolean moreThanOne = false;
		// �����ظ�������
		HashSet<Integer> hs = new HashSet<>();
		// ����arr
		for (int i = 0; i < arr.length; i++) {
			// �жϵ�ǰ����arr[i]�Ƿ�Ӧ���ڵ�ǰ������Ǳ���i
			while (arr[i] != i) {
				// �ж���arr[i]Ϊ�Ǳ����arr[arr[i]]�Ƿ�Ӧ���ڵ�ǰ������Ǳ���arr[i]�ϡ�
				// arr[arr[i]]�����ڽǱ�arr[i],��arr[i]�ŵ��Ǳ�arr[i]��
				if (arr[arr[i]] != arr[i]) {
					int temp = arr[arr[i]];
					arr[arr[i]] = arr[i];
					arr[i] = temp;
				}
				// arr[i]�ͽǱ�arr[i]�ϵ�����arr[arr[i]],��������ͬ�����֡�
				// ��־λ����Ϊtrue
				// ������ǰѭ�����ж���һ��λ�ã���i+1��ֵ
				else {
					moreThanOne = true;
					// ���ظ���ֵ���浽set��
					hs.add(arr[i]);
					break;
				}
			}
		}
		System.out.println(hs.toString());
		return moreThanOne;
	}

	public static void main(String[] args) {
		System.out.println("test1() Found:");
		test1();
		System.out.println("test2() Found:");
		test2();
		System.out.println("test3() Found:");
		test3();
	}

	// ������û���ظ�Ԫ�� arr[]={0,1,2,3,4,5}
	private static void test1() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);

	}

	// ���������ظ�Ԫ�� arr[]={1,2,2,4,4}
	private static void test2() {
		int[] arr = { 1, 2, 2, 4, 4 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);
	}

	// ���������ظ�Ԫ�� arr[]={1,1,1}
	private static void test3() {
		int[] arr = { 1, 1, 1 };
		FindDuplicateNumbers fdn = new FindDuplicateNumbers();
		System.out.print("findTheNumbers:   ");
		fdn.findTheNumbers(arr);
		System.out.print("findTheNumbers2:   ");
		fdn.findTheNumbers2(arr);
	}
}
