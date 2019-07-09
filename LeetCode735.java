package LeetCode;

import java.util.Stack;

/**
 * ������ײ����
 * ʹ��ջ��ʵ�֡��൱��һ����ص�˼�룬���������Ǹ�����ռ����أ�ջ��
 * @author GODV
 * @date 2019��6��25������8:59:45
 * @description:
 */
public class LeetCode735 {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int temp : asteroids) {
			if (temp > 0) {
				stack.push(temp);
			} else {
				//temp�������
				while (!stack.empty() && stack.peek() > 0 && stack.peek() < -temp) {
					stack.pop();
				}
				//ͬ���ھ�
				if (!stack.empty() && stack.peek() == -temp) {
					stack.pop();
					continue;
				}
				//ռ�����
				if (stack.empty() || stack.peek() < 0) {
					stack.push(temp);
				}
			}
		}
		int[] res = new int[stack.size()];
		for (int i = stack.size() - 1; i > -1; i--) {
			res[i] = stack.pop();
		}
		return res;
	}

}
