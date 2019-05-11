package LeetCode;

//������ֻ����һ�ε����������Ķ���������

public class LeetCode540 {
	public static void main(String[] args) {
		int[] is = { 1, 2, 3, 4, 2, 3, 4, 1, 5 };
		singleNonDuplicate(is);
		singleNonDuplicate2(is);
	}

	// �����δ��������� ֱ��ʹ��������� n
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

	// ������Ŀ������������������� ʹ�ö��ַ� logn
	public static int singleNonDuplicate2(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (left + right) / 2;
			if (nums[mid] == nums[mid - 1]) {// �е��������
				if ((mid - left) % 2 == 0) {// ���Ϊż��
					right = mid - 2;
				} else {
					right = mid + 1;
				}

			} else if (nums[mid] == nums[mid + 1]) {// �е���ұߵ���ȣ�
				if ((right - mid) % 2 == 0) {// ��Ϊż������˵���ұߵĴ��ڴ�ֵ���ı�left��ֵ
					left = mid + 2;
				} else {// ��Ϊ��������˵����ߵĴ��ڴ�ֵ���ı�right��ֵ
					right = mid - 1;
				}
			} else {// �е�����Ҷ�����ȣ�ֱ�ӷ���
				return nums[mid];
			}
		}
		System.out.println(nums[right]);
		return nums[right];

	}
}
