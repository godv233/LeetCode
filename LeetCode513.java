package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 树的层序遍历。我们每遍历一层，就存储每一层左边的第一个元素
 * @author GODV
 * @date 2019年5月22日下午2:11:45
 * @description:
 */
public class LeetCode513 {
	public int findBottomLeftValue(TreeNode root) {
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {// 不为空
			count = queue.size();
			res=queue.peek().val;
			while (count > 0) {
				TreeNode aNode = queue.poll();
				if (aNode.left != null) {
					queue.add(aNode.left);
				}
				if (aNode.right != null) {
					queue.add(aNode.right);
				}
				count--;
			}

		}

		return res;

	}
}
