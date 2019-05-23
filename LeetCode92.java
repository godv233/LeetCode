package LeetCode;

/**
 * ��ת����Ҫ��һ��ɨ�� Ҫ��m��nλ��ȫ����ת ֱ����m��n�м䴦�����ε���˳��
 * 
 * @author GODV
 * @date 2019��5��22������2:32:40
 * @description:
 */
public class LeetCode92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}
		head = pre.next;
		for (int i = m; i < n; i++) {
			ListNode nex = head.next;
			head.next = nex.next;
			pre.next = nex;
			nex.next = head;
		}
		return dummy.next;

	}
}
