package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 * 
 * @author GODV
 * @date 2019年6月25日下午7:37:51
 * @description:
 */
class MyStack {
	private Queue<Integer> queue_1;
	private Queue<Integer> queue_2;

	/**
	 * Initialize your data structure here.
	 */
	public MyStack() {
		queue_1 = new LinkedList<>();
		queue_2 = new LinkedList<>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		queue_1.offer(x);
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		while (queue_1.size() != 1) {
			queue_2.offer(queue_1.poll());
		}
		int temp = queue_1.poll();
		while (queue_2.size() != 0) {
			queue_1.offer(queue_2.poll());
		}
		return temp;
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		while (queue_1.size() != 1) {
			queue_2.offer(queue_1.poll());
		}
		return queue_1.peek();
	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return queue_1.size() == 0;
	}

}

public class LeetCode225 {

}
