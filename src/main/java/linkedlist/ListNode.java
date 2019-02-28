package linkedlist;

public class ListNode<T extends Comparable<T>> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}


