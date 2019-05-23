package LeetCode;

import java.util.TreeMap;

/**
 * 
 * @author GODV
 * @date 2019��5��20������1:50:48
 * @description:�ҳ�������飬���ֵ����Сֵ���1 ʹ��hashmapʵ��
 */
public class LeetCode594 {
	public static void main(String[] args) {
		int[] a= {};
		System.out.println(findLHS(a));
	}
	public static int findLHS(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int sum = 0;
		int a = 0;
		for (Integer i : map.keySet()) {
			if (map.containsKey(i)) {
				a = map.get(i);
				if (map.containsKey(i+1)) {
					a=a+map.get(i+1);
				}
			}
			sum = Math.max(a, sum);
		}
		return sum;
	}
}
