package LeetCode;

//�������������������������
//˼·��ֱ��һ��ѭ���ҳ���������ֵ �Ƚ�
public class LeetCode747 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 5, 6 };
		System.out.println(	dominantIndex(a));
	}

	public static int dominantIndex(int[] nums) {
		int max1 =0;
		int k1=0;
		int max2 =0;
		int k2=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>max1) {
				max2=max1;
				k2=k1;
				max1=nums[i];
				k1=i;
				continue;
			}else if (nums[i]>max2) {
				max2=nums[i];
				k2=i;
			}
		}
		if (max2*2<=max1) {
			return k1;
		}else {
			return -1;
		}
	}
}
