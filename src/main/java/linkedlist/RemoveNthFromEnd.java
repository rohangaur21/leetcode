package linkedlist;

public class RemoveNthFromEnd {


    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p2.next != null) {
            if (count < n) {
                p2 = p2.next;
                count++;
            } else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        if (count < n) { //Used when total nodes = n, otherwise it removes last node
            head = head.next;
        } else {
            p1.next = p1.next.next;
        }
        return head;
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
        Node h = removeNthFromEnd(list.head, 5);
        h.print();
    }
}
