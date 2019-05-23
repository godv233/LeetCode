package LeetCode;

import java.lang.Thread.State;

/**
 * ��Ч����ȫƽ�������ж��ǲ�����ȫƽ����
 * 
 * @author GODV
 * @date 2019��5��22������1:45:37
 * @description:
 */
public class LeetCode367 {
	public static void main(String[] args) {

	}

	// �����ⷨ��̫����
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

	// ���ַ�
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
	//��ʽ�� ��Ϊһ����ȫƽ����������ǰN������֮��
	public boolean isPerfectSquare2(int num) {
		int i=1;
		while (num>0) {
			num=num-i;
			i=i+2;
		}
		return num==0;
		
	}
	
	
	
}
