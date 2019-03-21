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

public class StringLongestPalindrome {
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
        int slen = s.length();
        int index = 0;
        while (index < (slen / 2)) {
            if (s.charAt(index) != s.charAt(slen - index - 1)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
