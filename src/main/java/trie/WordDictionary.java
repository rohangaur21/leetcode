package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean isWord = false;

        TrieNode() {
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null) t.children.put(c, new TrieNode());
            t = t.children.get(c);
        }
        t.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        TrieNode t = root;
        return match(Collections.singletonList(t), word, 0);
    }

    public boolean match(List<TrieNode> list, String word, int index) {
        char cc = word.charAt(index);

        if (word.length() - index == 1) {
            for (TrieNode t : list) {
                if (cc == '.' || t.children.get(cc) != null) {
                    for (TrieNode tt : t.children.values()) {
                        if (tt.isWord) return true;
                    }
                }
            }
            return false;
        }
        List<TrieNode> newList = new ArrayList<>();
        for (TrieNode t : list) {
            if (cc == '.') {
                newList.addAll(t.children.values());
            } else if (t.children.get(cc) != null) {
                newList.add(t.children.get(cc));
            }
        }

        if (newList.isEmpty()) return false;
        return match(newList, word, ++index);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
//        wd.addWord("bad");
//        wd.addWord("dad");
//        wd.addWord("mad");
//        System.out.println(wd.search("pad"));
//        System.out.println(wd.search("bad"));
//        System.out.println(wd.search(".ad"));
//        System.out.println(wd.search("b.."));
        wd.addWord("ran");
        wd.addWord("rune");
        wd.addWord("runner");
        wd.addWord("runs");
        wd.addWord("add");
        wd.addWord("adds");
        wd.addWord("adder");
        wd.addWord("addee");
        System.out.println(wd.search("..n."));
    }

}
