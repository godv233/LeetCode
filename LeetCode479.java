package LeetCode;

/**
 * ���Ļ������˻�
 * 
 * @author GODV
 * @date 2019��5��23������8:52:21
 * @description:
 */
public class LeetCode479 {
	public int largestPalindrome(int n) {
		if (n==1) {
			return 9;
		}
		int max=(int) (Math.pow(10, n)-1);//�õ�Nλ�������ֵ
		for (int i = max; i > max/10; i--) {
			long p=toPalindrome(i);//����һ��������
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
	//������iΪһ��Ļ�����
	public long toPalindrome(int i) {
		StringBuffer str = new StringBuffer();
		str.append(i + "");
		String a = str.reverse().toString();
		return Long.parseLong(i + "" + a);
	}

}
