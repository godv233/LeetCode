package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个链表
 * 
 * @author GODV
 * @date 2019年7月7日下午10:06:05
 * @description:
 */
public class LeetCode23 {
	/**
	 * 优先级队列法
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		//创建一个优先级队列
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val<o2.val) {
					return -1;
				}else if (o1.val>o2.val) {
					return 1;
				}
				return 0;
			}
		});
		ListNode root=new ListNode(0);
		ListNode p=root;
		//加入优先级队列
		for (ListNode listNode : lists) {
			if (listNode!=null) {
				queue.add(listNode);
			}
		}
		while (!queue.isEmpty()) {
			p.next=queue.poll();//按照定制的优先级出队列。最小的先出。
			p=p.next;
			if (p.next!=null) {
				queue.add(p.next);
			}
		}
		return root.next;
	}
	/**
	 * 分治法：分，处理，合并
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return merge(lists,0,lists.length-1);
		
	}
	private ListNode merge(ListNode[] lists, int left, int right) {
		if (left>=right) {//结束条件
			return lists[left];
		}
		//分割
		int mid=(left+right)/2;
		ListNode l1=merge(lists, left, mid);
		ListNode l2=merge(lists, mid+1, right);
		//合并
		return mergeTwoLists(l1,l2);
	}
	//合并函数：就是合并两个排序链表
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(0);
		ListNode root = prehead; 
		while (l1 != null && l2 != null) { 
			if (l1.val <= l2.val) {
				root.next = l1;
                l1 = l1.next; 
				} else {
					root.next = l2; 
					l2 = l2.next; 
					} 
			root = root.next; 
			} 
        if(l1==null){
            root.next=l2;
        }else{
            root.next=l1;
        }
		return prehead.next; 
	}

}
