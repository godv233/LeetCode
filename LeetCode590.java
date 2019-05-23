package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 * 
 * @author GODV
 * @date 2019年5月23日下午8:17:38
 * @description:和以前的方式一样，直接递归调用，先遍历孩子，再遍历根节点
 */

public class LeetCode590 {
	// 递归实现
	public List<Integer> postorder(Node root) {
		List<Integer> afterOrder = new ArrayList<>();
		if (root == null) {
			return afterOrder;
		}
		if (root.children == null || root.children.size() == 0) {
			afterOrder.add(root.val);
			return afterOrder;
		}
		// 先遍历孩子。再遍历根节点
		List<Node> childs = root.children;
		for (Node node : childs) {
			afterOrder.addAll(postorder(node));
		}
		afterOrder.add(root.val);
		return afterOrder;
	}

	// 栈的迭代实现:有点类似于层序遍历
	public List<Integer> postorder1(Node root) {
		List<Integer> tempOrder = new ArrayList<>();
		if (root == null) {
			return tempOrder;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {// 不为空
			Node node = stack.pop();
			tempOrder.add(node.val);
			if (node.children != null && node.children.size() != 0) {// 将子节点加入栈
				for (Node node1 : node.children) {
					stack.add(node1);
				}
			}
		}

		Collections.reverse(tempOrder);//颠倒顺序
		return tempOrder;
	}
}
