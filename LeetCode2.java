package LeetCode;

import java.math.BigInteger;

//两数相加
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

	// 直接运算法： 不适用，可能会因为链表过长而引起溢出
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
		// 1.先将两个链表转化成数字
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
		// 2.相加
		int resnum = l1num + l2num;
		System.out.println(resnum);
		// 3.数字转链表
		ListNode root = new ListNode(0);
		ListNode res = root;
		String reString = String.valueOf(resnum);
		System.out.println(reString.length());
		for (int i = reString.length() - 1; i >= 0; i--) {
			ListNode listNode = new ListNode(0);// 创建节点
			BigInteger aInteger = new BigInteger(String.valueOf(reString.charAt(i)));
			listNode.val = aInteger.intValue();
			System.out.println(listNode.val);
			res.next = listNode;
			res = res.next;
		}
		return root.next;
	}

	// 方法2 ：直接使用链表来进行运算 将链表对齐 就像数字运算那样
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
		ListNode head = new ListNode(0);// 头节点
		ListNode current = head;
		int carry = 0;// 进位
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;// 得到链表的当前位置的值
			int sum = x + y + carry;// 求和
			carry = sum / 10;// 求进位
			current.next = new ListNode(sum % 10);// 设置链表
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
