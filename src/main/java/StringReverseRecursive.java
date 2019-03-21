public class StringReverseRecursive {
    public static void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    public static void helper(char[] s, int i, int j) {
        if (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            helper(s, ++i, --j);
        }
    }

    public static void main(String[] args) {
        char[] s = "01".toCharArray();
        reverseString(s);
        System.out.println(s);
    }
}
