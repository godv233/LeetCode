package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *数字字母组合
 * @author GODV
 * @date 2019年7月7日下午5:22:12
 * @description:
 */
public class LeetCode17 {
	//递归函数。cur为当前已经遍历过的字符。digits为题目给定的字符串。
    //简单的原理是我们一次从每一个数字对应的字符串中取出来，然后从最底层开始遍历，依次向上。最后放入list.
	List<String> res=new ArrayList<>();
	String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; //定义电话数组
	
	public List<String> letterCombinations(String digits) { 
		if (digits.length()==0||digits==null) {
			return res;
		}
		getString("",digits);
		return res;
	}

	private void getString(String curStr, String digits) {
		if (curStr.length()==digits.length()) {
			res.add(curStr);
			return;
		}
		int curIndex=digits.charAt(curStr.length())-'0';//得到当前的遍历位置
		for (int i = 0; i < map[curIndex].length(); i++) {
			getString(curStr+map[curIndex].charAt(i), digits);//类似于深度优先遍历
		}
	}
}
