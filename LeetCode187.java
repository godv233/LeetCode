package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 重复的DNA序列：ACGT 编写一个函数来查找子串，这个子串长度为10，在原字符串中出现超过一次。 思想：1，一个hashmap实现
 * 2.两个hashset实现：添加到一个set中，如果失败，证明重复，就添加到另一个中
 * 
 * @author GODV
 *
 */
public class LeetCode187 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> reStrings = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			if (map.get(string) > 1) {
				reStrings.add(string);
			}
		}
		return reStrings;

	}

	public List<String> findRepeatedDnaSequences2(String s) {
		Set<String> set = new HashSet<>();
		Set<String> help = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String cur = s.substring(i, i + 10);
			if (!set.add(cur))
				help.add(cur);
		}
		return new ArrayList<String>(help);
	}
}
