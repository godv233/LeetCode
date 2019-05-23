package LeetCode;

/**
 * @author GODV
 * @date 2019��5��22������10:24:32
 * @description:��N������
 */
public class LeetCode264 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
		System.out.println(nthUglyNumber1(10));
	}

	// �����ⷨ
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

	// ʹ����ָ��ķ�������Ϊ�ڱ����ⷨ�У����Ƕ�ÿ��ֵ�жϡ�ʱ�临�Ӷȼ��ߡ���ô����ʹ�ÿռ任ʱ�����ָ�뷽��
	public static int nthUglyNumber1(int n) {
		if (n < 1) {
			return 0;
		}
		int[] res = new int[n];// �����������
		res[0] = 1;
		int min = 0;
		int s2 = 0;
		int s3 = 0;
		int s5 = 0;// ������־ָ��
		
		for (int i = 1; i < n; i++) {
			min = Math.min(Math.min(res[s2] * 2, res[s3] * 3), res[s5] * 5);// �õ������е���Сֵ
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
