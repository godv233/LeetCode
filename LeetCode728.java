package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * �Գ���
 * 
 * @author GODV
 * @date 2019��5��25������10:39:17
 * @description: t=x ��x  %(t%10)�ӵ͵���ȡ��ÿһλ -�� �ж� ����� t/=10 ѭ�� ֱ��t==0 ���ǡ�
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
