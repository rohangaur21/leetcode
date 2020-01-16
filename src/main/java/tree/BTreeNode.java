package tree;

import java.util.*;

class BTreeNode {
    Integer data;
    BTreeNode left;
    BTreeNode right;

    public BTreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static BTreeNode initBinaryTree(List<Integer> values) {
        BTreeNode root = null;
        if (values == null || values.isEmpty())
            return root;

        Iterator<Integer> iter = values.iterator();
        root = new BTreeNode(iter.next());
        Queue<BTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BTreeNode node = queue.poll();
            if (!iter.hasNext()) {
                return root;
            }
            node.left = new BTreeNode(iter.next());
            queue.add(node.left);
            if (!iter.hasNext()) {
                return root;
            }
            node.right = new BTreeNode(iter.next());
            queue.add(node.right);
        }
        return root;
    }

    public static void printData(String prefix, BTreeNode node) {
        if (node == null)
            System.out.println(prefix + " => data (null)");
        else
            System.out.println(prefix + " => data (" + node.data + ") left (" + (node.left == null ? null : node.left.data) + ") right (" + (node.right == null ? null : node.right.data) + ")");
    }

    public static void main(String[] args) {
        BTreeNode root = BTreeNode.initBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        BTreePrinter.printNode(root);
    }
}