package string;

import java.util.*;

public class WordLadderII {
    private class Node {
        String word;
        int level;

        Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 0));

        Set<String> checked = new HashSet<String>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.word.equals(endWord))
                return node.level + 1;
            for (String w : wordList) {
                if (!checked.contains(w) && hasOneLetterDiff(node.word, w)) {
                    queue.add(new Node(w, node.level + 1));
                    checked.add(w);
                }
            }
        }
        return 0;
    }

    private boolean hasOneLetterDiff(String current, String destination) {
        if (current.length() != destination.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != destination.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
