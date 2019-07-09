package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * ���ظ����ֵ���ִ��� ʹ�û������������
 * 
 * @author GODV
 * @date 2019��6��26������8:31:55
 * @description:
 */
public class LeetCode3 {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				ans = Math.max(ans, j - i);//j-i�ͱ�ʾ��������
			} else {//�������ظ�ʱ��ɾ���ظ�Ԫ��ǰ�������Ԫ��
				set.remove(s.charAt(i));
				i++;
			}
		}
		return ans;
	}
}
