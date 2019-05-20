package LeetCode;

import java.util.Arrays;

//摆动排序  我的思想 直接排序后插入
//一大一小排序
public class LeetCode324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);//直接升序
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
