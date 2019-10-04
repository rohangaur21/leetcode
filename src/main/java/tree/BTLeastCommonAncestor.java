package tree;

import java.util.Arrays;

public class BTLeastCommonAncestor {
    public static void main(String[] args) {
        BTLeastCommonAncestor opt = new BTLeastCommonAncestor();
        BinaryTreeNode root = BinaryTreeNode.initBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        System.out.println("\nLeast Common Ancestor (5,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BinaryTreeNode(5), new BinaryTreeNode(0)).data);
        System.out.println("\nLeast Common Ancestor (6,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BinaryTreeNode(6), new BinaryTreeNode(0)).data);
    }

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        System.out.println((root == null ? root : root.data) + " = " + (p == null ? p : p.data) + " = " + (q == null ? q : q.data));
        if (root == null || root.data == p.data || root.data == q.data) return root;
        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) {
            if (right != null) return root;
            return left;
        }
        return right;
    }
}
