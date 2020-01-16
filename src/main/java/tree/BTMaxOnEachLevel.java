package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BTMaxOnEachLevel {
    public static void main(String[] args) {
        BTMaxOnEachLevel opt = new BTMaxOnEachLevel();
        BTreeNode root = BTreeNode.initBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, 5, 6, 7, 4));
        System.out.println(opt.getMaxOnEachLevel(root));
    }


    public List<Integer> getMaxOnEachLevel(BTreeNode root) {
        if (root == null) return Collections.emptyList();


        List<Integer> results = new ArrayList<>();
        int max;
        List<BTreeNode> list = new ArrayList<BTreeNode>();
        List<BTreeNode> newlist = new ArrayList<BTreeNode>();
        newlist.add(root);
        while (true) {
            max = Integer.MIN_VALUE;
            System.out.println(list);
            for (BTreeNode n : list) {
                if (max <= n.data) {
                    max = n.data;
                }
                if (n.right != null) {
                    newlist.add(n.right);
                }
                if (n.left != null)
                    newlist.add(n.left);
            }
            results.add(max);
            if (newlist.isEmpty()) {
                break;
            }
            list = newlist;
            newlist = new ArrayList<>();
        }
        return results;
    }
}