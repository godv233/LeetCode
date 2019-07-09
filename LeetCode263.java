package LeetCode;

/**
 * �жϳ���
 * 
 * @author GODV
 * @date 2019��6��25������6:35:46
 * @description:
 */
public class LeetCode263 {
	//ѭ���ⷨ
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
	//�ݹ�ⷨ
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
