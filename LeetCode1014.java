package LeetCode;

//��ѹ۹����
/**
 * ��Ϊa[i]+a[j]+i-j�����ֵ ��ʵ����a[i]+i����� �ҳ�i a[j]-j�����ֵ �ҳ�j
 * 
 * @author GODV
 *
 */
public class LeetCode1014 {
	public static void main(String[] args) {
		int[] arr = { 8, 1, 5, 2, 6 };
		System.out.println(maxScoreSightseeingPair(arr));
	}

	// ��������
	public static int maxScoreSightseeingPair(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] + i - j > max) {
					max = a[i] + a[j] + i - j;
				}
			}
		}
		return max;
	}

	// ̰��˼�� ���ű������飬���Ƕ������ֺ�ȡ���ֵ��
	// ��������ǰ��ֵ���±��֮�ͱ�֮ǰ�������Ǿ͸���left���ֵ�ֵ���ɡ�
	public int maxScoreSightseeingPair2(int[] A) {
		int left = A[0], res = Integer.MIN_VALUE;
		for (int j = 1; j < A.length; j++) {

			res = Math.max(res, left + A[j] - j);
			left = Math.max(left, A[j] + j);
		}
		return res;
	}
}
