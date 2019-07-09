package LeetCode;

public class LeetCode14 {
	// 分治法mlog（n） n 个长度为 m 的相同字符串。
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		return commonPrefix(strs, 0, strs.length - 1);
	}

	public String commonPrefix(String[] strings, int left, int right) {
		if (left >= right) {
			return strings[left];
		}
		int mid = (left + right) / 2;
		String leftCommonString = commonPrefix(strings, left, mid);
		String rightCommonString = commonPrefix(strings, mid + 1, right);
		return Common(leftCommonString, rightCommonString);

	}

	public String Common(String left, String right) {
		int min = Math.min(left.length(), right.length());
		for (int i = 0; i < min; i++) {
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);

	}

	// 暴力法 O（s）
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

}
