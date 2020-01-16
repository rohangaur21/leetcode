package tree;

import java.util.Arrays;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        LeastCommonAncestor opt = new LeastCommonAncestor();
        BTreeNode root = BTreeNode.initBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        System.out.println("\nLeast Common Ancestor (5,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BTreeNode(5), new BTreeNode(0)).data);
        System.out.println("\nLeast Common Ancestor (6,0) ---- ");
        System.out.println(opt.lowestCommonAncestor(root, new BTreeNode(6), new BTreeNode(0)).data);
    }

    public BTreeNode lowestCommonAncestor(BTreeNode root, BTreeNode p, BTreeNode q) {
        if (root == null)
            return null;
        if (root.data == p.data || root.data == q.data)
            return root;
        BTreeNode left = lowestCommonAncestor(root.left, p, q);
        BTreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return left == null ? right : left;
    }


}
