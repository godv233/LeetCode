package LeetCode;

import java.util.ArrayList;

/**
 * ��֤����������
 * 
 * @author GODV
 * @date 2019��6��25������6:56:32
 * @description:
 */
public class LeetCode98 {
	// ʹ�����������������ж�,Ч�ʲ���
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

	// ���ö������������������ж�.
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
