package string;

import java.util.*;

public class WordBreakII {
    private Map<String, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return bfs(s, wordDict);
    }

    private List<String> bfs(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                List<String> subList = bfs(s.substring(w.length()), wordDict);
                for (String sub : subList) {
                    res.add(w + (sub == "" ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
