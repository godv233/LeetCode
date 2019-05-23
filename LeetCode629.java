package LeetCode;

/**
 * K个逆序对数组
 * 
 * @author GODV
 * @date 2019年5月22日下午3:27:56
 * @description:
 */
public class LeetCode629 {
	public int kInversePairs(int n, int k) {
		long[][] dp = new long[n + 1][k + 1];
		if (k > n * (n - 1) / 2 || k < 0)
			return 0;
		if (k == 0 || k == n * (n - 1) / 2)
			return 1;

		int mod = 1000000007;
		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= Math.min(k, n * (n - 1) / 2); j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if (j >= i)
					dp[i][j] -= dp[i - 1][j - i];
				dp[i][j] = (dp[i][j] + mod) % mod; // 处理dp[i][j]为负数的情况
			}
		}
		return (int) dp[n][k];
	}
}
