package LeetCode;

//二叉树路径和 
/**
 * @author GODV
 *
 */
public class LeetCode112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;// 递归终止的条件
		}
		if (root.left == null && root.right == null) {
			return sum - root.val == 0;
		} // 是否正确的关键

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);//递归的返回值
	}
}
