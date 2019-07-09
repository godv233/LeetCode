package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 
 * @author GODV
 * @date 2019年6月29日下午1:39:53
 * @description:
 */
public class LeetCode1 {
	// 暴力解法：n*n
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

	// 使用hashmap.一般我们想要提高查询效率，就会使用hashmap.空间换时间
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
