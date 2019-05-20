package LeetCode;

import java.util.Stack;

/**
 * 
 * @author GODV
 * @date 2019��5��19��
 * @description ��·�� ���ַ�������/�ָ��һ���ַ�������
 *              �����ַ���,�����".."�򵯳�һ��Ԫ�أ������"."�����κβ��������򽫵�ǰ���ַ�����ջ
 *              ���ջ��û��Ԫ�أ�������·��"/"�������Ԫ�أ���ջ�е�Ԫ������ƴ�ӡ�
 */
public class LeetCode71 {
	public String simplifyPath(String path) {
		if (path == null) {
			return "";
		}
		String[] pathList = path.split("/");
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < pathList.length; i++) {
			if (pathList[i] != null && !pathList[i].equals("")) {
				if (pathList[i].equals(".")) {
					continue;
				} else if (pathList[i].equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else {
					stack.add(pathList[i]);
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			return "/";
		}
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
		}
		return sb.toString();
	}
}
