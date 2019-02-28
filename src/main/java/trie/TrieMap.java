package trie;

import java.util.HashMap;
import java.util.Map;


public class TrieMap {
    TrieNode root;

    TrieMap() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null) {
                t.children.put(c, new TrieNode());
            }
            t = t.children.get(c);
        }
        t.isWord = true;

    }

    public boolean search(String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null) return false;
            t = t.children.get(c);
        }
        return t.isWord;
    }

    public boolean startsWith(String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null) return false;
            t = t.children.get(c);
        }
        return true;
    }

    class TrieNode {
        Character c;
        Map<Character, TrieNode> children = new HashMap<>();
        Boolean isWord;

        TrieNode() {
        }

        TrieNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        TrieMap trie = new TrieMap();
//        trie.insert("apple");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("xx"));
    }
}
