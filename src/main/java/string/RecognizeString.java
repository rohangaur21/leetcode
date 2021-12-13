package string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * <p>
 * Return any possible rearrangement of s or return "" if not possible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: s = "aaab"
 * Output: ""
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class RecognizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }


    static String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char a : s.toCharArray()) {
            int cnt = charFrequency.getOrDefault(a, 0) + 1;
            if (cnt > (s.length() + 1) / 2) {
                return "";
            }
            charFrequency.put(a, cnt);
        }
        //add in PQ with decreasing order of freq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char a : charFrequency.keySet()) {
            pq.add(new int[]{a, charFrequency.get(a)});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || (char) first[0] != sb.charAt(sb.length() - 1)) {
                extracted(pq, sb, first);
            } else {
                int[] second = pq.poll();
                extracted(pq, sb, second);
            }
        }
        return sb.toString();
    }

    private static void extracted(PriorityQueue<int[]> pq, StringBuilder sb, int[] arr) {
        sb.append((char) arr[0]);
        if (--arr[1] > 0) {
            pq.add(arr);
        }
    }
}
