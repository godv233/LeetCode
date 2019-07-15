package LeetCode;

/**
 * 最小路径和；动态规划问题
 * 
 * @author GODV
 * @date 2019年7月11日下午8:38:58
 * @description:
 */
public class LeetCode64 {
	public static void main(String[] args) {
		
	}

	// 利用二维的动态规划，其实可以在原数组上操作，节省空间
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] min = new int[m][n];
		min[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			min[i][0] = min[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			min[0][i] = min[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
			}
		}
		return min[m - 1][n - 1];
	}
}
