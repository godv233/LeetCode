package LeetCode;

//���������
public class LeetCode67 {
	public String addBinary(String a, String b) {
		StringBuffer reStringBuffer = new StringBuffer();
		int x = 0;
		int y = 0;
		int c = 0;// ��λ
		int sum = 0;// x+y+c
		while (a.length() != b.length()) {// ǰ�油0������һ��
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
		if (c == 1) {// ����н�λ
			reStringBuffer.append(1);
		}

		return reStringBuffer.reverse().toString();

	}
}
