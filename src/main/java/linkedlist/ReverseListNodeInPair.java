package linkedlist;

public class ReverseListNodeInPair {
    public ListNode swapPairsWData(ListNode node) {
        if (node != null && node.next != null) {
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            swapPairsWData(node.next.next);
        }
        return node;
    }

    public void swapPairsWOData(ListNode node) {
        if (node != null && node.next != null) {
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            swapPairsWOData(node.next.next);
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
