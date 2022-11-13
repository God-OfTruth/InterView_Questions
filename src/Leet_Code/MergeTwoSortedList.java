package Leet_Code;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		ListNode node1 = new ListNode(2, node);
		ListNode listNode = new ListNode(1, node1);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3, node4);
		ListNode listNode2 = new ListNode(1, node3);

		System.out.println(mergeTwoLists(listNode, listNode2));
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		ListNode head;
		ListNode temp;
		if (list1.val < list2.val) {
			temp = head = new ListNode(list1.val);
			list1 = list1.next;
		} else {
			temp = head = new ListNode(list2.val);
			list2 = list2.next;
		}
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				temp.next = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				temp.next = new ListNode(list2.val);
				list2 = list2.next;
			}
			temp = temp.next;
		}
		while (list1 != null) {
			temp.next = new ListNode(list1.val);
			list1 = list1.next;
			temp = temp.next;
		}
		while (list2 != null) {
			temp.next = new ListNode(list2.val);
			list2 = list2.next;
			temp = temp.next;
		}
		return head;
	}
};

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
};