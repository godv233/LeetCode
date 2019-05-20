package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 
 * @author GODV 用队列实现二叉树的层次遍历
 */
public class LeetCode102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();// 为null 返回一个空list
		}
		List<List<Integer>> resList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();// 层次便利使用队列
		queue.add(root);
		while (queue.isEmpty() == false) {
			List<Integer> list = new ArrayList<>();
			int count = queue.size();// 得到队列中节点的个数，方便我们把一层的数据加入一个list
			while (count > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			resList.add(list);
		}
		return resList;
	}

}
