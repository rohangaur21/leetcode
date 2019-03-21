import java.util.ArrayList;
import java.util.List;

public class PhonePadCombination {
    public List<String> letterCombinations(String digits) {

        List<String> combination = new ArrayList<>();
        if (digits.equals("")) {
            return combination;
        }
        String[] s = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < s[Integer.parseInt(digits.charAt(0) + "")].length(); i++) {
            combination.add(s[Integer.parseInt(digits.charAt(0) + "")].charAt(i) + "");
        }

        System.out.println(combination);
        List<String> temp = new ArrayList<>();
        String ss = null;
        for (int i = 1; i < digits.length(); i++) {
            ss = s[Integer.parseInt(digits.charAt(i) + "")];
            temp.clear();
            for (String str : combination) {
                for (int j = 0; j < ss.length(); j++) {
                    temp.add(str + ss.charAt(j));
                }
            }
            combination.clear();
            combination.addAll(temp);
        }
        return combination;

    }

    public static void main(String[] args) {
        System.out.println(new PhonePadCombination().letterCombinations("56"));
    }
}
