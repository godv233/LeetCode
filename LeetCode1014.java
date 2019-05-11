package LeetCode;

//最佳观光组合
/**
 * 因为a[i]+a[j]+i-j的最大值 其实就是a[i]+i的最大 找出i a[j]-j的最大值 找出j
 * 
 * @author GODV
 *
 */
public class LeetCode1014 {
	public static void main(String[] args) {
		int[] arr = { 8, 1, 5, 2, 6 };
		System.out.println(maxScoreSightseeingPair(arr));
	}

	// 暴力方法
	public static int maxScoreSightseeingPair(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] + i - j > max) {
					max = a[i] + a[j] + i - j;
				}
			}
		}
		return max;
	}

	// 贪心思想 随着遍历数组，我们对两部分和取最大值，
	// 并且若当前的值—下标对之和比之前更大，我们就更新left部分的值即可。
	public int maxScoreSightseeingPair2(int[] A) {
		int left = A[0], res = Integer.MIN_VALUE;
		for (int j = 1; j < A.length; j++) {

			res = Math.max(res, left + A[j] - j);
			left = Math.max(left, A[j] + j);
		}
		return res;
	}
}
