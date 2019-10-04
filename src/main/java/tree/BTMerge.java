package tree;

import java.util.Arrays;

public class BTMerge {
    public static void main(String[] args) {
        BTTraversal t = new BTTraversal();

        System.out.println(System.lineSeparator());
        BinaryTreeNode b1 = BinaryTreeNode.initBinaryTree(Arrays.asList(1, 3, 2, 5));
        t.breadthFirst(b1);

        System.out.println(System.lineSeparator());
        BinaryTreeNode b2 = BinaryTreeNode.initBinaryTree(Arrays.asList(2, 1, 3, null, 4, null, 7));
        t.breadthFirst(b2);

        System.out.println(System.lineSeparator());
        BinaryTreeNode mergeBT = merge(b1, b2);
        t.breadthFirst(mergeBT);
    }

    private static BinaryTreeNode merge(BinaryTreeNode b1, BinaryTreeNode b2) {
        if (b1 == null && b2 == null) return null;
        if (b1 == null) return b2;
        if (b2 == null) return b1;
        BinaryTreeNode merge = new BinaryTreeNode((b1.data == null ? 0 : b1.data) + (b2.data == null ? 0 : b2.data));
        merge.left = merge(b1.left, b2.left);
        merge.right = merge(b1.right, b2.right);
        return merge;
    }

}
