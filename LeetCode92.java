package LeetCode;

/**
 * 反转链表：要求一趟扫描 要求m到n位置全部反转 直接在m和n中间处。依次调换顺序
 * 
 * @author GODV
 * @date 2019年5月22日下午2:32:40
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
