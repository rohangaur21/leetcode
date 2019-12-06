package string;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || !s.contains(" "))
            return s;
        String[] sArr = s.split(" ");
        StringBuilder result = new StringBuilder();
        int i = sArr.length;
        while (i > 0) {
            if (sArr[i - 1] != null && !sArr[i - 1].trim().equals(""))
                result.append(" ").append(sArr[i - 1].trim());
            i--;
        }
        return result.substring(1);
    }

    public String reverseWords2(String s) {
        if (s == null || !s.contains(" "))
            return s;
        return dfs(s, 0, "");
    }

    private String dfs(String s, int start, String res) {
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res += dfs(s.substring(i), i+1, res);
            }
//            else{
//                res += s.charAt(i);
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " ss";
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
//        System.out.println("-"+new ReverseWords().reverseWords(s)+"-");
//        System.out.println("-"+new ReverseWords().reverseWords(s1)+"-");
//        System.out.println("-"+new ReverseWords().reverseWords(s2)+"-");
//        System.out.println("-"+new ReverseWords().reverseWords(s3)+"-");


        System.out.println("-" + new ReverseWords().reverseWords2(s) + "-");
//        System.out.println("-"+new ReverseWords().reverseWords(s1)+"-");
//        System.out.println("-"+new ReverseWords().reverseWords(s2)+"-");
//        System.out.println("-"+new ReverseWords().reverseWords(s3)+"-");
    }
}
