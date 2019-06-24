package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NthNodeParentTrie {
    static class TrieNode {
        Integer data;
        List<TrieNode> children = new ArrayList<>();

        TrieNode(Integer c) {
            this.data = c;
        }
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode(1);
        System.out.println("ANS " + findParent(root, 6));

    }

    public static int findParent(TrieNode t, int child) {
        int pid = t.data;
        int tot = t.children.size();
        for ( int i = 0; i <=t.data; i++ ) {
            System.out.println(pid + "=" + t.children.size());
            int count = 1;
            while (count <= t.data) {
                pid = pid + 1;
                if (pid == child) {
                    return t.data;
                }
                t.children.add(new TrieNode(pid));
                count++;
                print(t, pid);
                if (t.children.size() == 10) {
                    return 0;
                }
            }
            t=t.children.get(0);
            System.out.println(t.data+" "+t.children.size());
            print(t, pid);
        }
        return 0;
    }

    public static void print(TrieNode t, int pid) {

        System.out.print("pid="+pid + "---> ");
        for ( TrieNode tt : t.children ) {
            System.out.print(tt.data+", ");
        }
        System.out.println("\n");
    }
}
