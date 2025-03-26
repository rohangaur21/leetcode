package trie;
import java.util.*;
public class WordSearchInMatrix {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray())
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, result);
        return result;
    }
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || !node.children.containsKey(c)) return;
        node = node.children.get(c);
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length)
                dfs(board, newRow, newCol, node, result);
        }
        board[i][j] = c;
        if (node.children.isEmpty()) node.children = null;
    }
    public static void main(String[] args) {
        WordSearchInMatrix solver = new WordSearchInMatrix();
        char[][] matrix = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solver.findWords(matrix, words));
    }
}
