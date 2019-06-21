package linkedlist;
class MergeTwoSorted {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;
        while (l1 != null) {
            while (l2 != null && l2.data.compareTo(l1.data)<0) {
                curr.next = new ListNode(l2.data);
                l2 = l2.next;
                curr = curr.next;
            }
            curr.next = new ListNode(l1.data);
            l1 = l1.next;
            curr = curr.next;
        }
        curr.next = l2;
        return l3.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;
        while (true) {
            if(l1==null){
                curr.next=l2;
                break;
            }else if(l2==null){
                curr.next=l1;
                break;
            }else{
                if(l1.data.compareTo(l2.data)<0){
                    curr.next = new ListNode(l1.data);
                    l1=l1.next;
                    curr=curr.next;
                }else{
                    curr.next = new ListNode(l2.data);
                    l2=l2.next;
                    curr=curr.next;
                }
            }
        }
        return l3.next;
    }

    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        l1.addNode(1);
        l1.addNode(2);
        l1.addNode(3);
        l1.printNodes();
        LinkList l2 = new LinkList();
        l2.addNode(1);
        l2.addNode(3);
        l2.addNode(4);
        l2.printNodes();
        ListNode l = mergeTwoLists(l1.head, l2.head);
        l.print();
    }
}
/*
* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
