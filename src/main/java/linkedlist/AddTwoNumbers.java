package linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkList<Integer> l1 = new LinkList<>();
        l1.addNode(3);
        l1.addNode(4);
        l1.addNode(5);
        l1.printNodes();
        System.out.println("----");
        LinkList<Integer> l2 = new LinkList<>();
        l2.addNode(6);
        l2.addNode(7);
        l2.addNode(8);
        l2.addNode(9);
        l2.printNodes();
        System.out.println("----");
        LinkList l = addNumbers(l1, l2);
        l.printNodes();
    }

    static LinkList addNumbers(LinkList h1, LinkList h2) {

        int len1 = h1.countNodes();
        int len2 = h2.countNodes();
        LinkList h3 = new LinkList();
        helper(h3, h1.head, len1, h2.head, len2, 0);
        return h3;
    }

    static int helper(LinkList<Integer> l, ListNode<Integer> l1, int len1, ListNode<Integer> l2, int len2, int sum) {
        if (l1 == null && l2 == null) {
            return 0;
        }
        int carry;
        if (len1 > len2) {
            carry = helper(l, l1.next, len1 - 1, l2, len2, sum);
            sum = sum * 10 + l1.data + carry;
        } else if (len1 < len2) {
            carry = helper(l, l1, len1, l2.next, len2 - 1, sum);
            sum = sum * 10 + l2.data + carry;
        } else {
            carry = helper(l, l1.next, len1 - 1, l2.next, len2 - 1, sum);
            sum = sum * 10 + l1.data + l2.data + carry;
        }
        l.insertNth(0, sum % 10);
        return sum / 10;

    }
}