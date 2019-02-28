package trie;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    class TrieNode {
        Integer val;
        Map<Character, TrieNode> children;
        Boolean isWord;

        TrieNode() {
            val = 0;
            children = new HashMap();
            isWord = false;
        }
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode t = root;
        for (char k : key.toCharArray()) {
            if (t.children.get(k) == null) {
                t.children.put(k, new TrieNode());
            }
            t = t.children.get(k);
        }
        t.isWord = true;
        t.val = val;
    }

    public int sum(String prefix) {
        TrieNode t = root;
        for (char p : prefix.toCharArray()) {
            if (t.children.get(p) == null) return 0;
            t = t.children.get(p);
        }
        return dfs(t);
    }

    public int dfs(TrieNode n) {
        if (n == null) {
            return 0;
        }
        int sum = 0;
        for (TrieNode t : n.children.values()) {
            sum = sum + dfs(t);
        }
        return sum;
    }
}
