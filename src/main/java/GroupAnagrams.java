import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] s) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char[] c = s[i].toCharArray();
            Arrays.sort(c);
            String ss = new String(c);
            if (map.containsKey(ss)) {
                List<String> list = new ArrayList(map.get(ss));
                list.add(s[i]);
                map.put(ss, list);
            } else {
                map.put(ss, Arrays.asList(s[i]));
            }
        }
        return new ArrayList(map.values());
    }
}
