package linkedlist;/*
* Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6*/


import java.util.Map;
import java.util.TreeMap;

public class iMergeKSortedList {
    class ListNode {
        int val;
        iMergeKSortedList.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (ListNode ln : lists) {
            while (ln != null) {
                int count = map.getOrDefault(ln.val, 0);
                map.put(ln.val, ++count);
                ln = ln.next;
            }
        }
        System.out.println(map);
        ListNode ln = new ListNode(0);
        ListNode curr = ln;
        for (Map.Entry entry : map.entrySet()) {
            for (int j = 0; j < (Integer) entry.getValue(); j++) {
                curr.next = new ListNode((Integer) entry.getKey());
                curr = curr.next;
            }
        }
        return ln.next;
    }
}
