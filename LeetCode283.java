package LeetCode;

/**
 * �ƶ�0 ����0�����ƶ������ ������һ��ѭ�� 
 * ������׷�����
 * ����һ��index����ʾ��0���ĸ�����ѭ���������飬
 * 
 * @author GODV
 *
 */
public class LeetCode283 {
	public void moveZeroes(int[] nums) {
		int k=nums.length;
		for (int i = 0; i < k; i++) {
			if (nums[i]==0) {
				for (int j = i; j < k-1; j++) {
					nums[j]=nums[j+1];
				}
				nums[k-1]=0;
				k--;
				i--;
			}
		}
	}
	
	public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
