package LeetCode;

import java.util.Stack;

/**
 * 行星碰撞问题
 * 使用栈来实现。相当于一种阵地的思想，是正数还是负数会占领阵地（栈）
 * @author GODV
 * @date 2019年6月25日下午8:59:45
 * @description:
 */
public class LeetCode735 {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int temp : asteroids) {
			if (temp > 0) {
				stack.push(temp);
			} else {
				//temp攻击阵地
				while (!stack.empty() && stack.peek() > 0 && stack.peek() < -temp) {
					stack.pop();
				}
				//同归于尽
				if (!stack.empty() && stack.peek() == -temp) {
					stack.pop();
					continue;
				}
				//占领阵地
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
