package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchInMatrix {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode t = root;
            for (char c : word.toCharArray()) {
                if (t.children.get(c) == null) t.children.put(c, new TrieNode());
                t = t.children.get(c);
            }
            t.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode t, List<String> res) {
        char c = board[i][j];

        if (c == '#' || t.children.get(c) == null) return;
        t = t.children.get(c);

        if (t.word != null) {
            res.add(t.word);
            t.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, t, res);
        if (j > 0) dfs(board, i, j - 1, t, res);
        if (i < board.length - 1) dfs(board, i + 1, j, t, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, t, res);
        board[i][j] = c;
    }

    public static void main(String[] args) {
        WordSearchInMatrix wd = new WordSearchInMatrix();
        char[][] matrix = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(wd.findWords(matrix, words));
    }
}
