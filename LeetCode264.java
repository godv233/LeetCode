package LeetCode;

/**
 * @author GODV
 * @date 2019年5月22日上午10:24:32
 * @description:第N个丑数
 */
public class LeetCode264 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
		System.out.println(nthUglyNumber1(10));
	}

	// 暴力解法
	public static int nthUglyNumber(int n) {
		int j = 1;
		int num = 0;
		int res = 0;
		while (num != n) {
			int i = j;
			while (i % 2 == 0 || i % 5 == 0 || i % 3 == 0) {
				if (i % 2 == 0) {
					i = i / 2;
				}
				if (i % 3 == 0) {
					i = i / 3;
				}
				if (i % 5 == 0) {
					i = i / 5;
				}

			}
			if (i == 1) {
				num++;
				res = j;
			}
			j++;
		}
		return res;
	}

	// 使用三指针的方法，因为在暴力解法中，我们对每个值判断。时间复杂度极高。我么可以使用空间换时间的三指针方法
	public static int nthUglyNumber1(int n) {
		if (n < 1) {
			return 0;
		}
		int[] res = new int[n];// 创建结果数组
		res[0] = 1;
		int min = 0;
		int s2 = 0;
		int s3 = 0;
		int s5 = 0;// 三个标志指针
		
		for (int i = 1; i < n; i++) {
			min = Math.min(Math.min(res[s2] * 2, res[s3] * 3), res[s5] * 5);// 得到三个中的最小值
			if (min == res[s2] * 2) {
				s2++;
			}
			if (min == res[s3] * 3) {
				s3++;
			}
			if (min == res[s5] * 5) {
				s5++;
			}
			res[i] = min;
		}

		return res[n - 1];
	}
}
