package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * ����֮��
 * 
 * @author GODV
 * @date 2019��6��29������1:39:53
 * @description:
 */
public class LeetCode1 {
	// �����ⷨ��n*n
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0)
			return res;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					break;
				}
			}
		}
		return res;
	}

	// ʹ��hashmap.һ��������Ҫ��߲�ѯЧ�ʣ��ͻ�ʹ��hashmap.�ռ任ʱ��
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0)
			return res;
		Map<Integer, Integer> dataMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (dataMap.containsKey(temp)) {
				res[0] = dataMap.get(temp);
				res[1] = i;
			}
			dataMap.put(nums[i], i);
		}
		return res;

	}
}
