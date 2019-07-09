package LeetCode;

import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��:������������չ��k��֮�͡�
 * 
 * @author GODV
 * @date 2019��7��7������7:14:13
 * @description:
 */
public class LeetCode18 {
	/**
	 * ����֮��
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<Integer> twoSum(int[] nums, int target) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);// ������
		int left = 0;
		int right = nums.length - 1;// ��β����ָ��
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				res.add(nums[left]);
				res.add(nums[right]);
				left++;
				right--;
			} else if (nums[left] + nums[right] < target) {
				while (left < right && nums[left] == nums[left + 1]) {
					left++;// �����ظ�ֵ
				}
				left++;
			} else {
				while (left < right && nums[right] == nums[right - 1]) {
					right--;// �����ظ�ֵ
				}
				right--;
			}

		}
		return res;
	}

	/**
	 * ����֮�ͣ��൱��������֮�͵Ļ����϶���һ��ѭ������������ָ��
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);// ������
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {// ȥ���ظ�
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));// ��������
					while (left < right && nums[left] == nums[left + 1]) {
						left++;// �����ظ�ֵ
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;// �����ظ�ֵ
					}
					left++;
					right--;

				} else if (nums[i] + nums[left] + nums[right] < target) {
					while (left < right && nums[left] == nums[left + 1]) {
						left++;// �����ظ�ֵ
					}
					left++;
				} else {
					while (left < right && nums[right] == nums[right - 1]) {
						right--;// �����ظ�ֵ
					}
					right--;
				}
			}
		}
		return res;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);// ������
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {// ȥ��ָ��i���ܵ��ظ����
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {// ȥ��j�����ظ������
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) {
							left++;// �����ظ�ֵ
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;// �����ظ�ֵ
						}
						left++;
						right--;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						while (left < right && nums[left] == nums[left + 1]) {
							left++;// �����ظ�ֵ
						}
						left++;
					} else {
						while (left < right && nums[right] == nums[right - 1]) {
							right--;// �����ظ�ֵ
						}
						right--;
					}
				}
			}
		}
		return result;
	}
}
