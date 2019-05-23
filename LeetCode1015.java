package LeetCode;

/**
 * 
 * @author GODV
 * @date 2019��5��22������10:13:24
 * @description:���������� K������Ҫ�ҳ����Ա� K �����ġ����������� 1 ����С������ N��
 * ������Ĺؼ����ڣ�ֻҪK���ܱ�2��5��������ô�ͱػ��н⡣ѭ��������
 */
public class LeetCode1015 {
	 int smallestRepunitDivByK(int K) {
		    if (K%2 == 0 || K%5 == 0)
		        return -1;
		    int i = 1;
		    for(int n = 1; n % K != 0; i++) {
		        n %= K;
		        n = n * 10 + 1;
		    }
		    return i;
		}
}
