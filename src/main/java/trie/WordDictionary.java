package trie;
import java.util.*;
public class WordDictionary {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
    private final TrieNode root;
    public WordDictionary() { root = new TrieNode(); }
    public void addWords(String[] words) {
        for (String word : words) {
            if (word == null || word.isEmpty()) continue;
            TrieNode node = root;
            for (char c : word.toCharArray())
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.isWord = true;
        }
    }
    public boolean search(String word) {
        return word != null && !word.isEmpty() && match(Collections.singletonList(root), word, 0);
    }
    private boolean match(List<TrieNode> list, String word, int index) {
        char c = word.charAt(index);
        if (index == word.length() - 1) {
            for (TrieNode node : list)
                if (c == '.' || node.children.containsKey(c))
                    for (TrieNode child : node.children.values())
                        if (child.isWord) return true;
            return false;
        }
        List<TrieNode> newList = new ArrayList<>();
        for (TrieNode node : list) {
            if (c == '.') newList.addAll(node.children.values());
            else if (node.children.containsKey(c)) newList.add(node.children.get(c));
        }
        return !newList.isEmpty() && match(newList, word, index + 1);
    }
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWords(new String[]{"ran", "rune", "runner", "runs", "add", "adds", "adder", "addee"});
        System.out.println(wd.search("..n."));
    }
}
