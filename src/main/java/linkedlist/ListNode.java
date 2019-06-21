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


    public void print() {
        if (this == null) {
            System.out.println("There is no node");
        } else {
            ListNode<T> curr = this;
            int i = 1;
            while (curr != null) {
                System.out.print(i + "(" + curr.toString() + ") -> ");
                curr = curr.next;
                i++;
            }
            System.out.print("\n");
        }
    }

}


