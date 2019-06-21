package linkedlist;


import java.util.ArrayList;
import java.util.List;

public class LinkList<T extends Comparable<T>> implements Cloneable {
    public ListNode<T> head = null;

    public LinkList() {
    }

    public void addNode(T data) {
        if (head == null) {
            head = new ListNode<T>(data);
        } else {
            ListNode<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode<T>(data);
        }
    }

    /**
     * Print all the nodes in the linked list.
     */
    public void printNodes() {
        if (head == null) {
            System.out.println("There is no node in the linked list");
        } else {
            ListNode<T> curr = head;
            int i = 1;
            while (curr != null) {
                System.out.print(i+"("+curr.toString()+") -> ");
                curr = curr.next;
                i++;
            }
            System.out.print("\n");
        }
    }

    public void printNodes(ListNode node) {
        if (node == null) {
            System.out.println("There is no node in the linked list");
        } else {
            ListNode<T> curr = node;
            int i = 1;
            while (curr != null) {
                System.out.print(i+"("+curr.toString()+") -> ");
                curr = curr.next;
                i++;
            }
            System.out.print("\n");
        }
    }

    /**
     * Count the number of nodes in the linked list.
     */
    public int countNodes() {
        if (head == null) {
            return 0;
        } else {
            ListNode<T> curr = head;
            int count = 0;
            while (curr != null) {
                curr = curr.next;
                count++;
            }
            return count;
        }
    }

    /**
     * Return the first element in the linked list.
     */
    public T popElement() {
        if (head != null) {
            T topElement = head.data;
            head = head.next;
            return topElement;
        }
        return null;
    }

    /**
     * Delete all the elements in the linked list.
     */
    public void deleteLinkedList() {
        // This is the easiest code every written in Java, no clean up
        // required. Java's garbage collector will clean up the memory
        // for all the elements being used in this linked list if
        // they are no longer referenced in the program.
        head = null;
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insertNth(int n, T data) {
        if (n > countNodes()) {
            return;
        }

        if (n == 0) {
            // To insert at the 0th position update the head itself.
            ListNode<T> nextNode = head;
            head = new ListNode<>(data);
            head.next = nextNode;
        } else {
            // Move the curr node to one before the position where we
            // want to insert the element and adjust the pointers accordingly.
            int i = 0;
            ListNode<T> curr = head;
            while (i < n - 1) {
                curr = curr.next;
                i++;
            }
            ListNode<T> next = curr.next;
            curr.next = new ListNode<T>(data);
            curr.next.next = next;
        }
    }

    /**
     * Insert the data into the correct position in a sorted list. Assume
     * that the list is sorted in ascending order.
     */
    public void insertSorted(T data) {
        if (countNodes() == 0 || head.data.compareTo(data) > 0) {
            ListNode<T> next = head;
            head = new ListNode<T>(data);
            head.next = next;
        } else {
            ListNode<T> curr = head;
            while (curr.next != null && curr.next.data.compareTo(data) < 0) {
                curr = curr.next;
            }
            ListNode<T> next = curr.next;
            curr.next = new ListNode<T>(data);
            curr.next.next = next;
        }
    }

    /**
     * Append the nodes of the other list to the end of the curren list.
     */
    public void appendList(LinkList<T> ll) {
        if (ll.head == null) {
            return;
        } else {
            ListNode<T> curr = ll.head;
            while (curr != null) {
                addNode((T) curr.data);
                curr = curr.next;
            }
        }
    }

    /**
     * Split a linked list into 2 equal parts. If there are an odd number of
     * elements, the extra element should be in the first list.
     */
    public List<ListNode<T>> frontBackSplit() {
        ListNode<T> front = null;
        ListNode<T> back = null;

        // A 0 element list means both the front list and back
        // list will both be null.
        if (head == null) {
            front = null;
            back = null;
        } else if (head.next == null) {
            // For a one element list, include the first element in the
            // front list.
            front = head;
            back = null;
        } else {
            // Move one pointer twice as fast as another.
            ListNode<T> slow = head;
            ListNode<T> fast = head;
            while (fast != null) {
                fast = fast.next;
                if (fast == null) {
                    break;
                }
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                }
            }
            front = head;
            back = slow.next;
            slow.next = null;
        }
        List<ListNode<T>> list = new ArrayList<>();
        list.add(front);
        list.add(back);
        return list;
    }

    /**
     * Remove duplicates in a sorted list.
     */
    public void removeDuplicates() {
        int count = countNodes();
        if (count == 0 || count == 1) {
            return;
        } else {
            ListNode<T> curr = head;
            do {
                if (curr.next.data.compareTo(curr.data) == 0) {
                    // Skip over the duplicate node. It will be garbage collected
                    // by Java.
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            } while (curr.next != null);
        }
    }

    /**
     * Move the head element or the first element from this list to
     * the destination linked list as the destination's new head node.
     */
    public void changeHead(LinkList<T> destinationList) {
        T currHead = popElement();
        if (destinationList.head == null) {
            // If this is the first element in the destination list , simply
            // add it to the list.
            destinationList.addNode(currHead);
        } else {
            ListNode<T> next = destinationList.head;
            destinationList.head = new ListNode<T>(currHead);
            destinationList.head.next = next;
        }
    }

    /**
     * Create a new sorted list which is the merged from two original sorted lists.
     * Assume the lists are sorted in ascending order.
     */
    public LinkList<T> sortedMergeList(LinkList otherList) {
        if (otherList == null) {
            return this;
        } else if (head == null) {
            return otherList;
        } else {
            ListNode<T> curr1 = otherList.head;
            ListNode<T> curr2 = head;
            LinkList<T> sortedList = new LinkList<T>();

            while (curr1 != null || curr2 != null) {
                if (curr2 == null ||
                        (curr1 != null && curr1.data.compareTo(curr2.data) < 0)) {
                    sortedList.addNode(curr1.data);
                    curr1 = curr1.next;
                } else {
                    sortedList.addNode(curr2.data);
                    curr2 = curr2.next;
                }
            }
            return sortedList;
        }
    }

    /**
     * Reverse all the nodes in the linked list so that the last node
     * becomes the first node.
     */
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        ListNode<T> prev = null;
        ListNode<T> curr = head;
        while (curr != null) {
            ListNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}




