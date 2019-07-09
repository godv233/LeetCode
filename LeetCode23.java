package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * �ϲ�k������
 * 
 * @author GODV
 * @date 2019��7��7������10:06:05
 * @description:
 */
public class LeetCode23 {
	/**
	 * ���ȼ����з�
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		//����һ�����ȼ�����
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
		//�������ȼ�����
		for (ListNode listNode : lists) {
			if (listNode!=null) {
				queue.add(listNode);
			}
		}
		while (!queue.isEmpty()) {
			p.next=queue.poll();//���ն��Ƶ����ȼ������С���С���ȳ���
			p=p.next;
			if (p.next!=null) {
				queue.add(p.next);
			}
		}
		return root.next;
	}
	/**
	 * ���η����֣������ϲ�
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
		if (left>=right) {//��������
			return lists[left];
		}
		//�ָ�
		int mid=(left+right)/2;
		ListNode l1=merge(lists, left, mid);
		ListNode l2=merge(lists, mid+1, right);
		//�ϲ�
		return mergeTwoLists(l1,l2);
	}
	//�ϲ����������Ǻϲ�������������
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
