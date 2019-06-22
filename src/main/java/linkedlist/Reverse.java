package linkedlist;

public class Reverse {
    static ListNode reverse(ListNode head) {
        if(head == null) {
            return head;
        }

        // last node or only one node
        if(head.next == null) {
            return head;
        }

        ListNode newHeadNode = reverse(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }

    public static void main(String[] args) {
//        LinkList<Integer> list = new LinkList<>();
//        list.addNode(3);
//        list.addNode(4);
//        list.addNode(5);
//        list.addNode(6);
//        list.addNode(7);
//        list.printNodes();
//        System.out.println("----");
//        reverse(list.head);
//
//        list.printNodes();
    }
}
