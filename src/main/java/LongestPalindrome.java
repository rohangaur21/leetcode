/*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
* */

public class LongestPalindrome {
    public String longestPalindrome(String s) {

        String palin = "";
        String sub = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    if (palin.length() < sub.length()) {
                        palin = sub;
                    }
                }
            }
        }
        return palin;
    }

    public boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        int i = 0;
        while (i < mid) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
