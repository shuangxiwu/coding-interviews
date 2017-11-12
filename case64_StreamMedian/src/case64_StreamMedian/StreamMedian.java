package case64_StreamMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��Ŀ����εõ�һ���������е���λ����
 * 
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * 
 * ˼·��
 * 
 * Java��PriorityQueue
 * �Ǵ�JDK1.5��ʼ�ṩ���µ����ݽṹ�ӿڣ�Ĭ���ڲ�����Ȼ���򣬽��ΪС���ѣ�Ҳ�����Զ������������������淴ת�Ƚϣ���ɴ󶥶ѡ�
 * 
 * Ϊ�˱�֤����������(ʱ�临�Ӷ�O(lgN))��ȡ��λ��(ʱ�临�Ӷ�O(1))��ʱ��Ч�ʶ���Ч������ʹ�ô󶥶�+С���ѵ��������������㣺
 * 
 * 1���������е�������Ŀ��ܳ���1����������ʹ��λ��ֻ������������ѵĽ��Ӵ���
 * 
 * 2���󶥶ѵ��������ݶ�С��С���ѣ�����������������Ҫ��
 * 
 * @author WangSai
 *
 */
public class StreamMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamMedian sm = new StreamMedian();
		int[] arr = { 1, 2, 3, 5, 6, 8, 0 };
		for (int i = 0; i < arr.length; i++) {
			sm.Insert(arr[i]);
			System.out.print(sm.GetMedian() + " ");
		}
	}

	// ����С����
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	// �����󶥶�
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
		// PriorityQueueĬ����С���ѣ�ʵ�ִ󶥶ѣ���Ҫ��תĬ��������
		public int compare(Integer num1, Integer num2) {
			return num2.compareTo(num1);
			// return num1.compareTo(num2);,����С���ѵ�����ʽ
		}
	});
	// ͳ���Ѿ����������������δ�����ոն�ȡ���������ݡ�
	private int count = 0;

	public void Insert(Integer num) {
		// ����������Ϊż��ʱ���¼����Ԫ�أ�Ӧ������󶥶�
		// ��ע�ⲻ��ֱ�ӽ���󶥶ѣ����Ǿ�С����ɸѡ��ȡ�󶥶������Ԫ�ؽ���С���ѣ�
		if ((count & 1) == 0) {// �ж�ż���ĸ�Ч����
			if (num > minHeap.peek() && !minHeap.isEmpty()) {
				// 1.�¼����Ԫ�����뵽С���ѣ���С����ɸѡ��������С��Ԫ��
				minHeap.offer(num);
				// 2.ɸѡ��ġ�С�����е����Ԫ�ء�����󶥶�
				maxHeap.offer(minHeap.poll());
			} else
				maxHeap.offer(num);
		}
		// ����������Ϊ����ʱ���¼����Ԫ�أ�Ӧ������С����
		else {
			if (num < maxHeap.peek() && !maxHeap.isEmpty()) {
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			} else
				minHeap.offer(num);
		}
		// ͳ�ƴ󶥶Ѻ�С�����е���������+1
		count++;
	}

	public Double GetMedian() {
		if (count == 0)
			throw new RuntimeException("no available number,please check");
		if ((count & 1) == 0) {// �ж���ż���ĸ�Чд��
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek() * 1.0;
		}
	}
}
