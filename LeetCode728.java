package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 自除数
 * 
 * @author GODV
 * @date 2019年5月25日上午10:39:17
 * @description: t=x 先x  %(t%10)从低到高取出每一位 -》 判断 如果是 t/=10 循环 直到t==0 就是。
 */
public class LeetCode728 {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new LinkedList<>();
		for (int num = left; num <= right; num++) {
			Set<Integer> set = new HashSet<>();
			int temp = num;
			boolean flag = true;
			while (temp != 0) {
				if (temp % 10 != 0)
					set.add(temp % 10);
				else {
					flag = false;
					break;
				}
				temp = temp / 10;
			}
			for (Integer x : set) {
				if (num % x != 0)
					flag = false;
			}
			if (flag)
				list.add(num);
		}
		return list;
	}
}
