package trie;

import java.util.*;

class TriePrefixInStringArray {
    public static String solution(String[] strings) {
        if (strings == null) return null;
        TrieNode root = new TrieNode(' ');
        for (String string : strings) {
            insertWords(root, string);
        }
        return getPrefix(root, strings[0]);
    }

    public static String getPrefix(TrieNode root, String string) {
        String result = "";
        for (char c : string.toCharArray()) {
            if (root.children.size() == 1) {
                result += c;
                root = root.children.get(c);
            }
        }
        return result;
    }

    public static void insertWords(TrieNode root, String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null)
                t.children.put(c, new TrieNode(c));
            t = t.children.get(c);
        }
    }

    static class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();

        TrieNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abcdef", "abcghi", "abcabc"}));

    }
}