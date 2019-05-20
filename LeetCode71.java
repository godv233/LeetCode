package LeetCode;

import java.util.Stack;

/**
 * 
 * @author GODV
 * @date 2019年5月19日
 * @description 简化路径 将字符串根据/分割成一个字符串数组
 *              遍历字符串,如果是".."则弹出一个元素，如果是"."则不做任何操作，否则将当前的字符串入栈
 *              如果栈内没有元素，则代表根路径"/"。如果有元素，则将栈中的元素逆序拼接。
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
