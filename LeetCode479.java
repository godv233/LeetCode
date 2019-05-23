package LeetCode;

/**
 * 最大的回文数乘积
 * 
 * @author GODV
 * @date 2019年5月23日下午8:52:21
 * @description:
 */
public class LeetCode479 {
	public int largestPalindrome(int n) {
		if (n==1) {
			return 9;
		}
		int max=(int) (Math.pow(10, n)-1);//得到N位数的最大值
		for (int i = max; i > max/10; i--) {
			long p=toPalindrome(i);//返回一个回文数
			for (int j = max; j > max/10; j--) {
				if (p/j>max) {
					break;
				}
				if (p%j==0) {
					return (int) (p%1337);
				}
			}
		}
		return -1;
		
	}
	//创建以i为一半的回文数
	public long toPalindrome(int i) {
		StringBuffer str = new StringBuffer();
		str.append(i + "");
		String a = str.reverse().toString();
		return Long.parseLong(i + "" + a);
	}

}
