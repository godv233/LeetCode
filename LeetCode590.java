package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N�����ĺ������
 * 
 * @author GODV
 * @date 2019��5��23������8:17:38
 * @description:����ǰ�ķ�ʽһ����ֱ�ӵݹ���ã��ȱ������ӣ��ٱ������ڵ�
 */

public class LeetCode590 {
	// �ݹ�ʵ��
	public List<Integer> postorder(Node root) {
		List<Integer> afterOrder = new ArrayList<>();
		if (root == null) {
			return afterOrder;
		}
		if (root.children == null || root.children.size() == 0) {
			afterOrder.add(root.val);
			return afterOrder;
		}
		// �ȱ������ӡ��ٱ������ڵ�
		List<Node> childs = root.children;
		for (Node node : childs) {
			afterOrder.addAll(postorder(node));
		}
		afterOrder.add(root.val);
		return afterOrder;
	}

	// ջ�ĵ���ʵ��:�е������ڲ������
	public List<Integer> postorder1(Node root) {
		List<Integer> tempOrder = new ArrayList<>();
		if (root == null) {
			return tempOrder;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {// ��Ϊ��
			Node node = stack.pop();
			tempOrder.add(node.val);
			if (node.children != null && node.children.size() != 0) {// ���ӽڵ����ջ
				for (Node node1 : node.children) {
					stack.add(node1);
				}
			}
		}

		Collections.reverse(tempOrder);//�ߵ�˳��
		return tempOrder;
	}
}
