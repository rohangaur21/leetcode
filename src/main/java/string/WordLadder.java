package string;

import java.util.*;

public class WordLadder {
    Set<String> wordSet;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet(wordList);
        Map<String, List<String>> parentMap = new HashMap();
        for (String str : wordList) {
            parentMap.put(str, new ArrayList<String>());
        }
        Map<String, Integer> distance = new HashMap();
        List<List<String>> result = new ArrayList();
        if (!bfs(beginWord, endWord, parentMap, distance)) {
            return result;
        }
        dfs(endWord, beginWord, parentMap, result, new ArrayList<String>());
        return result;
    }

    public boolean bfs(String beginWord, String endWord, Map<String, List<String>> parentMap, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        boolean found = false;
        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s > 0) {
                String parent = queue.poll();
                int level = distance.get(parent);
                List<String> neigh = findNeighbours(parent);
                for (String str : neigh) {
                    if (str.equals(endWord)) found = true;
                    if (!distance.containsKey(str)) {
                        distance.put(str, level + 1);
                        parentMap.get(str).add(parent);
                        queue.add(str);
                    } else if (distance.get(str) == level + 1) {
                        parentMap.get(str).add(parent);
                    }

                }
                s--;
            }
        }
        return found;
    }

    public void dfs(String curr, String beginWord, Map<String, List<String>> parentMap, List<List<String>> result, List<String> path) {
        if (curr.equals(beginWord)) {
            List<String> tmp = new ArrayList(path);
            tmp.add(beginWord);
            Collections.reverse(tmp);
            result.add(tmp);
        } else {
            path.add(curr);
            for (String par : parentMap.get(curr)) {
                dfs(par, beginWord, parentMap, result, path);
            }
            path.remove(path.size() - 1);
        }
    }

    public List<String> findNeighbours(String word) {
        int n = word.length();
        char[] chArr = word.toCharArray();
        List<String> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            char temp = chArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chArr[i] = c;
                String wrd = new String(chArr);
                if (wordSet.contains(wrd)) {
                    result.add(wrd);
                }
            }
            chArr[i] = temp;
        }
        return result;
    }
}
