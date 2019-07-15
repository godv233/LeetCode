package LeetCode;

/**
 * ��С·���ͣ���̬�滮����
 * 
 * @author GODV
 * @date 2019��7��11������8:38:58
 * @description:
 */
public class LeetCode64 {
	public static void main(String[] args) {
		
	}

	// ���ö�ά�Ķ�̬�滮����ʵ������ԭ�����ϲ�������ʡ�ռ�
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
