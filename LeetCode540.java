package LeetCode;

//数组中只出现一次的数，其他的都出现两次

public class LeetCode540 {
	public static void main(String[] args) {
		int[] is = { 1, 2, 3, 4, 2, 3, 4, 1, 5 };
		singleNonDuplicate(is);
		singleNonDuplicate2(is);
	}

	// 针对于未排序的数组 直接使用异或运算 n
	public static int singleNonDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		System.out.println(res);
		return res;

	}

	// 对于题目条件给定的排序的数组 使用二分法 logn
	public static int singleNonDuplicate2(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (left + right) / 2;
			if (nums[mid] == nums[mid - 1]) {// 中点和左边相等
				if ((mid - left) % 2 == 0) {// 左边为偶数
					right = mid - 2;
				} else {
					right = mid + 1;
				}

			} else if (nums[mid] == nums[mid + 1]) {// 中点跟右边的相等，
				if ((right - mid) % 2 == 0) {// 若为偶数，则说明右边的存在答案值，改变left的值
					left = mid + 2;
				} else {// 若为奇数，则说明左边的存在答案值，改变right的值
					right = mid - 1;
				}
			} else {// 中点跟左右都不相等，直接返回
				return nums[mid];
			}
		}
		System.out.println(nums[right]);
		return nums[right];

	}
}
