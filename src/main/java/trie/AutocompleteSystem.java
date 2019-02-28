package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutocompleteSystem {
    class TrieNode {
        int deg;

        Map<Character, TrieNode> children;
        boolean isSentence;

        TrieNode() {
            deg = 0;
            children = new HashMap();
            isSentence = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insertSentence(String word, int deg) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (t.children.get(c) == null) {
                t.children.put(c, new TrieNode());
            }
            t = t.children.get(c);
        }
        t.isSentence = true;
        t.deg = deg;
    }


    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insertSentence(sentences[i], times[i]);
        }
    }


    StringBuilder sb = new StringBuilder();
    List<String> searchHist = new ArrayList<>();

    public List<String> input(char c) {
        if (c == '#') {
            if (sb.length() != 0) {
                searchHist.add(sb.toString());
                sb.replace(0, sb.length() - 1, "");
            }
            return Collections.emptyList();
        } else {
            sb.append(c);
        }


        TrieNode t = root;
        for (char cc : sb.toString().toCharArray()) {
            if (t.children.get(cc) != null) {
                t = t.children.get(cc);
                continue;
            } else {
                return Collections.emptyList();
            }
        }

        Map<String, Integer> results = new HashMap<>();
        DFS(results, new StringBuilder(), null, t);

        List<String> ans = new ArrayList<>();
        System.out.println(sb.toString());

        Map<String, Integer> r = new TreeMap<>(new MyComp(results));
        r.putAll(results);

        for (Map.Entry<String, Integer> entry : r.entrySet()) {
            ans.add(sb.toString() + entry.getKey());
        }
        return ans;
    }

    public void DFS(Map<String, Integer> results, StringBuilder sb, Character c, TrieNode t) {
        if (c != null) sb.append(c);

        if (t.isSentence) results.put(sb.toString(), t.deg);

        if (t.children.size() == 0) return;

        String s = "";
        for (Map.Entry<Character, TrieNode> entry : t.children.entrySet()) {
            s = sb.toString();
            DFS(results, sb, entry.getKey(), entry.getValue());
            sb = new StringBuilder(s);
        }
    }

    class MyComp implements Comparator<String> {
        Map<String, Integer> map;

        MyComp(Map<String, Integer> map) {
            this.map = map;

        }

        @Override
        public int compare(String s1, String s2) {
            return map.get(s2) >= map.get(s1) ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"Hello Test!!", "Hello !!", "Hello Friend!!","He ss"};
        int[] times = {1, 2, 3,2};

        AutocompleteSystem obj = new AutocompleteSystem(strings, times);

        System.out.println(obj.input('#'));
        System.out.println(obj.searchHist);
        System.out.println(obj.input('H'));
        System.out.println(obj.input('e'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('#'));
        System.out.println(obj.searchHist);
        System.out.println(obj.input('H'));
        System.out.println(obj.input('#'));
        System.out.println(obj.searchHist);

    }
}
