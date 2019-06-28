package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NthNodeParentTrie {

    static public TrieNode root;
    static int pid = 1;

    static class TrieNode {
        Integer data;
        Map<Integer, TrieNode> children;

        TrieNode(Integer c) {
            this.data = c;
            this.children = new HashMap<>(c + 1);

        }
    }

    public static int helper(List<TrieNode> tns, int pid_end) {
        List<TrieNode> list = new ArrayList<>();
        for (TrieNode tn : tns) {
            for (int i = 0; i < tn.data; i++) {
                if (pid_end - pid == 1) {
                    return tn.data;
                }
                TrieNode t = new TrieNode(++pid);
                tn.children.put(pid, t);
                list.add(t);
            }
            print(new ArrayList<>(tn.children.values()));
        }
        return helper(list, pid_end);
    }


    public static void print(List<TrieNode> list) {
        System.out.print("child --> ");
        for (TrieNode t : list) {
            System.out.print(t.data + ",");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        root = new TrieNode(1);
        System.out.println("ANS " + helper(Arrays.asList(root), 6));

    }

}
