package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 转盘锁
 * 思路：利用图的BFS求解.0000为起始点，9000,1000,0900,0100,0090,0010,0001,0009这八个节点与是起始点的可达点，
 * 注意过滤这一层已经遍历过得节点和死亡节点。
 * 
 * @author GODV
 *
 */
public class LeetCode752 {
	public int openLock(String[] deadends, String target) {
		HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));// 直接不成功的所有元素
		HashSet<String> visited = new HashSet<>();// 被访问过的元素
		String start = "0000";
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		q1.offer(start);
		int step = 0;
		if (dead.contains(start) || dead.contains(target)) {
			return -1;
		}
		while (!q1.isEmpty()) {
			String current = q1.poll();
			if (current.equals(target)) {
				return step;
			}
			List<String> next = getNexts(current);// 得到下一步的所有可能
			for (String string : next) {
				if (!dead.contains(string) && !visited.contains(string)) {
					visited.add(string);// 访问过了
					q2.offer(string);// 放入队列
				}
			}
			if (q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<>();
				step++;
			}

		}

		return -1;

	}

	public List<String> getNexts(String cur) {
		List<String> reStrings=new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			StringBuffer pre=new StringBuffer(cur);
			pre.setCharAt(i, cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));
			reStrings.add(pre.toString());
			StringBuffer after=new StringBuffer(cur);
			after.setCharAt(i,(char)cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));
            reStrings.add(after.toString());
		}
		
		return reStrings;

	}
}
