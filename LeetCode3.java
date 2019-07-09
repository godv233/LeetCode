package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复数字的最长字串。 使用滑动窗口来解决
 * 
 * @author GODV
 * @date 2019年6月26日下午8:31:55
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
				ans = Math.max(ans, j - i);//j-i就表示滑动窗口
			} else {//当出现重复时：删除重复元素前面的所有元素
				set.remove(s.charAt(i));
				i++;
			}
		}
		return ans;
	}
}
