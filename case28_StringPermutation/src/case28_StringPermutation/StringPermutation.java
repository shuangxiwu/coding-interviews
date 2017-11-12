package case28_StringPermutation;

import java.util.HashSet;

/**
 * ��Ŀ������һ���ַ�������ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba
 * 
 * @author WangSai
 *
 */
public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefg";
		myPermutation(str);
	}

	private static void myPermutation(String input) {
		// ���ַ���""��null����ͬһ������
		if (input == null || input.length() < 1) {
			return;
		}
		// ȥ�ظ��ַ���
		HashSet<String> hs = new HashSet<>();
		// Ϊ�˱��ڴ�����ַ���ת�����ַ�����
		char[] arr = input.toCharArray();
		myPermutationCore(arr, 0, hs);
		int count = 0;
		for (String str : hs) {
			System.out.println(str);
			count++;
		}
		// ���ظ����ַ��������������
		System.out.println(count);
	}

	private static void myPermutationCore(char[] arr, int index, HashSet<String> hs) {

		if (index == arr.length - 1) {
			// ֹͣ�ݹ飬����ӡ��char[]����
			StringBuffer sb1 = new StringBuffer();
			for (char i : arr) {
				sb1.append(i);
			}

			hs.add(sb1.toString());

		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, i, index);
				myPermutationCore(arr, index + 1, hs); // abc
				swap(arr, i, index);
			}
		}
	}

	private static void swap(char[] arr, int i, int index) {
		char temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
