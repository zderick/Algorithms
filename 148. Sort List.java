/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

public ListNode sortList(ListNode head) {
if(head == null || head.next == null) return head;

    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;
    while(fast != null && fast.next != null){
    	prev = slow;
    	slow = slow.next;
    	fast = fast.next.next;
    }

    prev.next = null;

    ListNode firstHalf = sortList(head);
    ListNode secondHalf = sortList(slow);
    return mergeTwoLists(firstHalf, secondHalf);
}

public ListNode mergeTwoLists(ListNode a, ListNode b){
	if(a == null) return b;
	if(b == null) return a;
	if(a.val < b.val){
		a.next = mergeTwoLists(a.next, b);
		return a;
	}
	else{
		b.next = mergeTwoLists(a, b.next);
		return b;
	}
}

