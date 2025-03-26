package linkedlist;

public class HasCycle {
    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node walker = head;
        Node runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
