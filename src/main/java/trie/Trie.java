package trie;


public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode tNode = root;
        for (char c : word.toCharArray()) {
            if (tNode.children[c - 'a'] == null) {
                tNode.children[c - 'a'] = new TrieNode(c);
            }
            tNode = tNode.children[c - 'a'];
        }
        tNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode tNode = root;
        for (char c : word.toCharArray()) {
            if (tNode.children[c - 'a'] == null || tNode.children[c - 'a'].val != c) return false;
            tNode = tNode.children[c - 'a'];
        }
        return tNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode tNode = root;
        for (char c : prefix.toCharArray()) {
            if (tNode.children[c - 'a'] == null || tNode.children[c - 'a'].val != c) return false;
            tNode = tNode.children[c - 'a'];
        }
        return true;
    }


    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        TrieNode() {
        }

        TrieNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
        System.out.println(trie.search("a"));
    }
}
