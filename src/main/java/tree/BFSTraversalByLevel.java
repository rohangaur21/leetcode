package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSTraversalByLevel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> list = null;
        LinkedList<TreeNode> temp = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                list.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = new LinkedList<>(temp);
            ans.add(list);
        }
        return ans;
    }
}
