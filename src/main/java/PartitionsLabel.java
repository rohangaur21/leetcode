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
    public List<Integer> partitionLabels(String str) {
        List<Integer> out = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        //Getting last index of each character
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), i);
        }
        System.out.println(map);

        int begin = 0, end = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            int val = map.get(str.charAt(idx));
            if (val > end) {
                end = val;
            }
            if (idx == end) {
                out.add(end - begin + 1);
                begin = idx + 1;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("\n" + new PartitionsLabel().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
