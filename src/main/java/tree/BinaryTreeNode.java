package tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode {
    Integer data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static BinaryTreeNode initBinaryTree(List<Integer> values) {
        BinaryTreeNode root = null;
        if (values == null || values.isEmpty()) return root;
        Iterator<Integer> iter = values.iterator();
        root = new BinaryTreeNode(iter.next());
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (!iter.hasNext()) return root;
            node.left = new BinaryTreeNode(iter.next());
            queue.add(node.left);
            if (!iter.hasNext()) return root;
            node.right = new BinaryTreeNode(iter.next());
            queue.add(node.right);
        }
        return root;
    }

    public static void printData(String prefix , BinaryTreeNode node) {
        if (node == null) System.out.println(prefix + " => data (null)");
        else
            System.out.println(prefix + " => data (" + node.data + ") left (" + (node.left == null ? null : node.left.data) + ") right (" + (node.right == null ? null : node.right.data)+")");

    }
}