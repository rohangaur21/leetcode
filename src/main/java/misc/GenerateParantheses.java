package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateParantheses {
    public static List<String> generateParenthesis(int n) {
        return gen(n * 2, 0, new StringBuilder());
    }

    public static List<String> gen(int n, int diff, StringBuilder sb) {
        if (diff < 0 || diff > n) return Collections.emptyList();
        else if (sb.length() == n) {
            if (diff == 0) return Arrays.asList(sb.toString());
            else return Collections.emptyList();
        } else {
            List<String> res = new ArrayList<>();

            sb.append('(');
            res.addAll(gen(n, diff + 1, sb));
            sb.deleteCharAt(sb.length() - 1);

            sb.append(')');
            res.addAll(gen(n, diff - 1, sb));
            sb.deleteCharAt(sb.length() - 1);

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
