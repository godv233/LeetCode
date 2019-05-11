package LeetCode;

//不使用+ -运算符来实现两个数的加减
/**
 * 两个整数a, b; a ^ b是无进位的相加； a&b得到每一位的进位； 
 * 让无进位相加的结果与进位不断的异或， 直到进位为0；
 * 使用位运算
 * @author GODV
 *
 */
public class LeetCode371 {
	public static void main(String[] args) {
		System.out.println(getSum(13,16));
	}

	public  static int getSum(int a, int b) {
		int sum=0;
		int carry=0;
		sum=a^b;//看作相加但是不体现进位
		carry=(a&b)<<1;
		if (carry!=0) {
			return getSum(sum, carry);
		}
		return sum;

	}
}
