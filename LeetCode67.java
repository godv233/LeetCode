package LeetCode;

//二进制求和
public class LeetCode67 {
	public String addBinary(String a, String b) {
		StringBuffer reStringBuffer = new StringBuffer();
		int x = 0;
		int y = 0;
		int c = 0;// 进位
		int sum = 0;// x+y+c
		while (a.length() != b.length()) {// 前面补0，保持一致
			if (a.length() > b.length()) {
				b = "0" + b;
			} else {
				a = "0" + a;
			}
		}
		for (int i = a.length() - 1; i >= 0; i--) {
			x = a.charAt(i)-'0';
			y = b.charAt(i)-'0';
			sum = x + y + c;
			if (sum > 1) {
				c = 1;
				reStringBuffer.append(sum - 2);
			} else {
				c = 0;
				reStringBuffer.append(sum);
			}

		}
		if (c == 1) {// 最后有进位
			reStringBuffer.append(1);
		}

		return reStringBuffer.reverse().toString();

	}
}
