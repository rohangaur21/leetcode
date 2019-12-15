package tree;

import java.util.*;

public class BTAllNodesDistanceK {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    Map<TreeNode, TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap();
        dfs(root);
        List<Integer> ans = new ArrayList();
        Set<TreeNode> visited = new HashSet();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(target);
        int depth = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.remove();
                if (depth == K) {
                    ans.add(node.val);
                    continue;
                }
                TreeNode parent = map.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                }
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                }
                visited.add(node);
            }
            depth++;
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            map.put(root.left, root);
        if (root.right != null)
            map.put(root.right, root);
        dfs(root.left);
        dfs(root.right);
    }
}
