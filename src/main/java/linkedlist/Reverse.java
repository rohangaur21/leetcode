package linkedlist;

public class Reverse {
    //approach1
    static ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head; // last node or only one node
        ListNode newHeadNode = reverseList1(head.next);
        head.next.next = head; // change references for middle chain
        head.next = null;
        return newHeadNode;// send back new head node in every recursion
    }

    //approach2
    static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode next;          //reference next will stay until the end of the method
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //approach3
    static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;    //get second node
        head.next = null;//set first's next to be null
        ListNode rest = reverseList3(second);
        second.next = head;
        return rest;
    }


    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.printNodes();
        System.out.println("----");
        reverseList3(list.head);
        ListNode ln = reverseList3(list.head);
        ln.print();
        list.printNodes();
    }
}
