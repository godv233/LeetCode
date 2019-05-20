package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �������Ĳ�α���
 * 
 * @author GODV �ö���ʵ�ֶ������Ĳ�α���
 */
public class LeetCode102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();// Ϊnull ����һ����list
		}
		List<List<Integer>> resList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();// ��α���ʹ�ö���
		queue.add(root);
		while (queue.isEmpty() == false) {
			List<Integer> list = new ArrayList<>();
			int count = queue.size();// �õ������нڵ�ĸ������������ǰ�һ������ݼ���һ��list
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
