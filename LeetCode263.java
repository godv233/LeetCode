package LeetCode;

/**
 * 判断丑数
 * 
 * @author GODV
 * @date 2019年6月25日下午6:35:46
 * @description:
 */
public class LeetCode263 {
	//循环解法
	public boolean isUgly(int num) {
		if (num==0) {
			return false;
		}
		while(num%2==0||num%3==0||num%5==0) {
			if (num%2==0) {
				num=num/2;
			}
			if (num%3==0) {
				num=num/3;
			}
			if (num%5==0) {
				num=num/5;
			}
		}
		return num==1?true:false;

	}
	//递归解法
	public boolean isUgly2(int num) {
		if (num==0) {
			return false;
		}
		if (num==1) {
			return true;
		}
		if (num%2==0) {
			return isUgly2(num/2);
		}
		if (num%3==0) {
			return isUgly2(num/3);
		}
		if (num%5==0) {
			return isUgly2(num/5);
		}
		return false;
		
	}
}
