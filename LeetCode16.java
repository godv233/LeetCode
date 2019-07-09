package LeetCode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 
 * @author GODV
 * @date 2019年7月7日下午4:05:47
 * @description:
 */
public class LeetCode16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = nums[0]+nums[1]+nums[2];
		int left = 0, right = 0;
		int sum;
		for (int i = 0; i < nums.length - 2; i++) {
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - sum) < Math.abs(target - min)) {
					min = sum;
				}
				if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				} else {
					return target;
				}
			}
		}

		return min;
	}

}
