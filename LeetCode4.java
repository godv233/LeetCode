package LeetCode;

/**
 * 有序数组的中位数
 * 
 * @author GODV
 * @date 2019年6月29日上午11:11:31
 * @description:
 */
public class LeetCode4 {
	public static void main(String[] args) {
		int[] a = { 1, 3 };
		int[] aa = { 2, 4 };
		System.out.println(findMedianSortedArrays(a, aa));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	       if(nums1==null&&nums2==null)
		            return 0;
		        int m=nums1.length;
		        int n=nums2.length;
		        int k=m+n;
		        int i=0,j=0,t=0;
		        int[] res=new int[k];
		        while(i<m&&j<n){
		            if(nums1[i]<=nums2[j]){
		                res[t]=nums1[i];
		                i++;
		                t++;
		            }
		            else{
		                res[t]=nums2[j];
		                j++;
		                t++;
		            }
		        }
		        while(i<m){
		            res[t]=nums1[i];
		            i++;
		            t++;
		        }
		        while(j<n){
		            res[t]=nums2[j];
		                j++;
		                t++;
	            }
		        return (double)k%2==0?(res[k/2-1]+res[k/2])/2.0:res[k/2];
	    }
}
