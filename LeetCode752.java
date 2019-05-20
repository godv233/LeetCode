package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ת����
 * ˼·������ͼ��BFS���.0000Ϊ��ʼ�㣬9000,1000,0900,0100,0090,0010,0001,0009��˸��ڵ�������ʼ��Ŀɴ�㣬
 * ע�������һ���Ѿ��������ýڵ�������ڵ㡣
 * 
 * @author GODV
 *
 */
public class LeetCode752 {
	public int openLock(String[] deadends, String target) {
		HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));// ֱ�Ӳ��ɹ�������Ԫ��
		HashSet<String> visited = new HashSet<>();// �����ʹ���Ԫ��
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
			List<String> next = getNexts(current);// �õ���һ�������п���
			for (String string : next) {
				if (!dead.contains(string) && !visited.contains(string)) {
					visited.add(string);// ���ʹ���
					q2.offer(string);// �������
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
