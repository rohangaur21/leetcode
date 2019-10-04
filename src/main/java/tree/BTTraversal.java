package tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BTTraversal {
    public static void main(String[] args) {
        BTTraversal opt = new BTTraversal();
        BinaryTreeNode root = BinaryTreeNode.initBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));

        System.out.println("\nBFS ---- ");
        opt.breadthFirst(root);

        System.out.println("\nDFS PreOrder ---- ");
        opt.depthFirstPreOrder(root);
        System.out.println("\nDFS InOrder ---- ");
        opt.depthFirstInOrder(root);
        System.out.println("\nDFS PostOrder ---- ");
        opt.depthFirstPostOrder(root);
    }

    public void breadthFirst(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(" => " + node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public void depthFirstPreOrder(BinaryTreeNode root) {
        if (root == null) return;
        System.out.print(" => " + root.data);
        depthFirstPreOrder(root.left);
        depthFirstPreOrder(root.right);
    }

    public void depthFirstInOrder(BinaryTreeNode root) {
        if (root == null) return;
        depthFirstInOrder(root.left);
        System.out.print(" => " + root.data);
        depthFirstInOrder(root.right);
    }

    public void depthFirstPostOrder(BinaryTreeNode root) {
        if (root == null) return;
        depthFirstPostOrder(root.left);
        depthFirstPostOrder(root.right);
        System.out.print(" => " + root.data);
    }
}
