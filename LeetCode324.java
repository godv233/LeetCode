package LeetCode;

import java.util.Arrays;

//�ڶ�����  �ҵ�˼�� ֱ����������
//һ��һС����
public class LeetCode324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);//ֱ������
		int n=nums.length/2;
        int[] nums2=Arrays.copyOf(nums,nums.length);
        int j=0;
        int k=nums.length-1;
        if((nums.length&1)==0){
            for(int i=n-1;i>=0;i--){
                nums[j++]=nums2[i];
                nums[j++]=nums2[k];
                k--;
            }  
        }else{
            for(int i=n;i>0;i--){
                nums[j++]=nums2[i];
                nums[j++]=nums2[k];
                k--;
            }
            nums[j]=nums2[0];
        }
	}
}
