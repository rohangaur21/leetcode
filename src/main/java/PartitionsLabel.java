import java.util.*;

/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each
letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

*/
public class PartitionsLabel {
    public List<Integer> partitionLabels(String S) {
        List<Integer> out = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        //Getting last index of each character
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        Integer end = 0, begin = 0;
        System.out.print(map);
        for (int i = 0; i < S.length(); i++) {
            Integer index = map.get(S.charAt(i));
            if (index.intValue() > end.intValue()) {
                end = index;
            }
            if (i == end.intValue()) {
                out.add(end.intValue() - begin.intValue() + 1);
                begin = i + 1;
            }
        }
        return out;
    }
}
