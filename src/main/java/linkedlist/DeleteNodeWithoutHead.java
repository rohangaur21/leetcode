package linkedlist;

public class DeleteNodeWithoutHead {
    public static void removeNode(Node node) {
        if (node == null) return; /* if no node return null */
        if (node.next == null) { /* if only 1 node then delete node */
            node = null;
            return;
        }
        node.data = node.next.data; /* copy next node data to this node */
        Node second = node.next.next;     /* store the next next node */
        node.next = second; /* set the copied node as next */
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
        removeNode(list.head.next);
        list.printNodes();
    }
}
