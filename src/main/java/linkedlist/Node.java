package linkedlist;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> next;

    public Node(T data) {
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
            Node<T> curr = this;
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


