package LeetCode;

//��ʹ��+ -�������ʵ���������ļӼ�
/**
 * ��������a, b; a ^ b���޽�λ����ӣ� a&b�õ�ÿһλ�Ľ�λ�� 
 * ���޽�λ��ӵĽ�����λ���ϵ���� ֱ����λΪ0��
 * ʹ��λ����
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
		sum=a^b;//������ӵ��ǲ����ֽ�λ
		carry=(a&b)<<1;
		if (carry!=0) {
			return getSum(sum, carry);
		}
		return sum;

	}
}
