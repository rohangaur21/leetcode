package linkedlist;
/*
* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/


class MergeTwoSorted {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;
        while (l1 != null) {
            while (l2 != null && l2.val < l1.val) {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
                curr = curr.next;
            }
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
            System.out.println(curr.val);
        }
        curr.next = l2;
        return l3.next;
    }
}