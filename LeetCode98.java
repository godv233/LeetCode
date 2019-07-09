package LeetCode;

import java.util.ArrayList;

/**
 * 验证二叉搜索树
 * 
 * @author GODV
 * @date 2019年6月25日下午6:56:32
 * @description:
 */
public class LeetCode98 {
	// 使用中序排列有序来判断,效率不高
	private ArrayList<Integer> res = new ArrayList<>();

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		inOrderHelper(root);
		for (int i = 0; i < res.size() - 1; i++) {
			if (res.get(i + 1) <= res.get(i))
				return false;
		}
		return true;
	}

	private void inOrderHelper(TreeNode root) {
		if (root == null)
			return;
		inOrderHelper(root.left);
		res.add(root.val);
		inOrderHelper(root.right);
	}

	// 利用二叉搜索树的性质来判断.
	public boolean isValidBST2(TreeNode root) {
		return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST2(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val >= max || root.val <= min)
			return false;
		return isValidBST2(root.left, min, root.val) && isValidBST2(root.right, root.val, max);
	}

}
