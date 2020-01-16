package tree;

import java.util.Arrays;

public class LargestBSTInBinaryTree {
    class MinMax {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isBST = true;
        int size = 0;
    }

    private MinMax largest(BTreeNode root) {
        if (root == null) {
            return new MinMax();
        }
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax = largest(root.right);
        MinMax m = new MinMax();
        if (!leftMinMax.isBST || !rightMinMax.isBST || leftMinMax.max > root.data || rightMinMax.min <= root.data) {
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
        m.min = root.left != null ? leftMinMax.min : root.data;
        m.max = root.right != null ? rightMinMax.max : root.data;
        return m;
    }

    public static void main(String args[]) {
        LargestBSTInBinaryTree obj = new LargestBSTInBinaryTree();
        BTreeNode root = BTreeNode.initBinaryTree(Arrays.asList(-7, -6, -5, -4, -3, -2, 1, 2, 3, 16, 6, 10, 11, 12, 14));
        System.out.println("Size of largest BST  is " + obj.largest(root).size);
        root = BTreeNode.initBinaryTree(Arrays.asList(3, -2, -3, -4, -5, -6, -7, 1, 2, 16, 10, 6, 12, 11, 14));
        System.out.println("Size of largest BST  is " + obj.largest(root).size);
    }
}

