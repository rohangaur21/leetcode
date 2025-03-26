package linkedlist;

public class Reverse {
    //approach1
    static Node reverseList1(Node head) {
        if (head == null) return head;
        if (head.next == null) return head; // last node or only one node
        Node newHeadNode = reverseList1(head.next);
        head.next.next = head; // change references for middle chain
        head.next = null;
        return newHeadNode;// send back new head node in every recursion
    }

    //approach2
    static Node reverseList2(Node head) {
        Node prev = null;
        Node next;          //reference next will stay until the end of the method
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //approach3
    static Node reverseList3(Node head) {
        if (head == null || head.next == null) return head;
        Node second = head.next;    //get second node
        head.next = null;//set first's next to be null

        System.out.println("BF :"+ head.data +" - "+second.data);
        Node rest = reverseList3(second);
        System.out.println("----AF :"+ head.data +" - "+second.data);
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
        Node ln = reverseList3(list.head);
        ln.print();
    }
}
