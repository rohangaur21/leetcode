package tree;

import java.util.Arrays;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        LeastCommonAncestor opt = new LeastCommonAncestor();
        BinaryTreeNode root = BinaryTreeNode.initBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        System.out.println("\nLeast Common Ancestor (5,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BinaryTreeNode(5), new BinaryTreeNode(0)).data);
        System.out.println("\nLeast Common Ancestor (6,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BinaryTreeNode(6), new BinaryTreeNode(0)).data);
    }

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null)
            return null;
        if (root.data == p.data || root.data == q.data)
            return root;
        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return left == null ? right : left;
    }


}
