package LeetCode;

import java.lang.Thread.State;

/**
 * 有效的完全平方数：判断是不是完全平方数
 * 
 * @author GODV
 * @date 2019年5月22日下午1:45:37
 * @description:
 */
public class LeetCode367 {
	public static void main(String[] args) {

	}

	// 暴力解法：太复杂
	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		for (int i = 0; i <= num / 2 + 1; i++) {
			if (i * i == num) {
				return true;
			}
		}
		return false;

	}

	// 二分法
	public boolean isPerfectSquare1(int num) {
		int start = 1;
		int end = num;
		int mid = (start + end) / 2;
		while (start <= end) {
			if (mid * mid > num) {
				end = mid - 1;
			} else if (mid * mid < num) {
				start = mid + 1;
			} else
				return true;
			mid=(end-start)/2+start;
		}
		return false;
	}
	//公式法 因为一个完全平方数是他的前N个奇数之和
	public boolean isPerfectSquare2(int num) {
		int i=1;
		while (num>0) {
			num=num-i;
			i=i+2;
		}
		return num==0;
		
	}
	
	
	
}
