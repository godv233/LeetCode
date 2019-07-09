package LeetCode;

import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和:这个问题可以拓展到k数之和。
 * 
 * @author GODV
 * @date 2019年7月7日下午7:14:13
 * @description:
 */
public class LeetCode18 {
	/**
	 * 两数之和
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<Integer> twoSum(int[] nums, int target) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);// 先排序
		int left = 0;
		int right = nums.length - 1;// 首尾两个指针
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				res.add(nums[left]);
				res.add(nums[right]);
				left++;
				right--;
			} else if (nums[left] + nums[right] < target) {
				while (left < right && nums[left] == nums[left + 1]) {
					left++;// 跳过重复值
				}
				left++;
			} else {
				while (left < right && nums[right] == nums[right - 1]) {
					right--;// 跳过重复值
				}
				right--;
			}

		}
		return res;
	}

	/**
	 * 三数之和：相当于在两数之和的基础上多了一个循环。还是两个指针
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);// 先排序
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {// 去掉重复
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));// 加入结果集
					while (left < right && nums[left] == nums[left + 1]) {
						left++;// 跳过重复值
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;// 跳过重复值
					}
					left++;
					right--;

				} else if (nums[i] + nums[left] + nums[right] < target) {
					while (left < right && nums[left] == nums[left + 1]) {
						left++;// 跳过重复值
					}
					left++;
				} else {
					while (left < right && nums[right] == nums[right - 1]) {
						right--;// 跳过重复值
					}
					right--;
				}
			}
		}
		return res;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);// 先排序
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {// 去除指针i可能的重复情况
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {// 去除j可能重复的情况
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) {
							left++;// 跳过重复值
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;// 跳过重复值
						}
						left++;
						right--;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						while (left < right && nums[left] == nums[left + 1]) {
							left++;// 跳过重复值
						}
						left++;
					} else {
						while (left < right && nums[right] == nums[right - 1]) {
							right--;// 跳过重复值
						}
						right--;
					}
				}
			}
		}
		return result;
	}
}
