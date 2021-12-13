package algorithm.linkedlist;

import linkedlist.ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;        // Ref walker to head
        ListNode runner = head;        // Ref runner to head
        while (runner.next != null && runner.next.next != null) {   // Loop until we get walker.next or runner.next.next as null
            walker = walker.next;    // walker walks one.
            runner = runner.next.next;      // runner walks two
            if (walker == runner) return true;  // if walker == runner then cycle is present
        }
        return false;
    }
}