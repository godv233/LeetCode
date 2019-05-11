package LeetCode;

import java.math.BigInteger;

//�������
public class LeetCode2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;
		addTwoNumbers2(l1, l4);
	}

	// ֱ�����㷨�� �����ã����ܻ���Ϊ����������������
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		if (l1.val == 0) {
			return l2;
		}
		if (l2.val == 0) {
			return l1;
		}
		// 1.�Ƚ���������ת��������
		int l1num = 0;
		int l2num = 0;
		int k = 1;
		while (l1 != null) {
			l1num += l1.val * k;
			k = k * 10;
			l1 = l1.next;
		}
		k = 1;
		while (l2 != null) {
			l2num += l2.val * k;
			k = k * 10;
			l2 = l2.next;
		}
		// 2.���
		int resnum = l1num + l2num;
		System.out.println(resnum);
		// 3.����ת����
		ListNode root = new ListNode(0);
		ListNode res = root;
		String reString = String.valueOf(resnum);
		System.out.println(reString.length());
		for (int i = reString.length() - 1; i >= 0; i--) {
			ListNode listNode = new ListNode(0);// �����ڵ�
			BigInteger aInteger = new BigInteger(String.valueOf(reString.charAt(i)));
			listNode.val = aInteger.intValue();
			System.out.println(listNode.val);
			res.next = listNode;
			res = res.next;
		}
		return root.next;
	}

	// ����2 ��ֱ��ʹ���������������� ��������� ����������������
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		if (l1.val == 0) {
			return l2;
		}
		if (l2.val == 0) {
			return l1;
		}
		ListNode head = new ListNode(0);// ͷ�ڵ�
		ListNode current = head;
		int carry = 0;// ��λ
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;// �õ�����ĵ�ǰλ�õ�ֵ
			int sum = x + y + carry;// ���
			carry = sum / 10;// ���λ
			current.next = new ListNode(sum % 10);// ��������
			System.out.println(sum%10);
			current = current.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return head.next;

	}
}
