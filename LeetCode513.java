package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ�������������������һ���ҵ�����ߵ�ֵ��
 * ���Ĳ������������ÿ����һ�㣬�ʹ洢ÿһ����ߵĵ�һ��Ԫ��
 * @author GODV
 * @date 2019��5��22������2:11:45
 * @description:
 */
public class LeetCode513 {
	public int findBottomLeftValue(TreeNode root) {
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {// ��Ϊ��
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
