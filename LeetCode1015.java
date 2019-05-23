package LeetCode;

/**
 * 
 * @author GODV
 * @date 2019年5月22日上午10:13:24
 * @description:给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 * 该问题的关键在于：只要K不能被2和5整除。那么就必回有解。循环就是了
 */
public class LeetCode1015 {
	 int smallestRepunitDivByK(int K) {
		    if (K%2 == 0 || K%5 == 0)
		        return -1;
		    int i = 1;
		    for(int n = 1; n % K != 0; i++) {
		        n %= K;
		        n = n * 10 + 1;
		    }
		    return i;
		}
}
