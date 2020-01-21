package string;

public class MinMovesWO3SameLetters {

    int solution(String s) {
        int res = 0, index = 0, len = s.length();
        while (index < len) {
            int next = index + 1;
            while (next < len && s.charAt(index) == s.charAt(next))
                next++;
            res += (next - index) / 3;
            index = next;
        }
        return res;
    }

    public static void main(String[] args) {
        MinMovesWO3SameLetters o = new MinMovesWO3SameLetters();
        System.out.println(o.solution("baaab"));
        System.out.println(o.solution("baaaab"));
        System.out.println(o.solution("baaaaab"));
        System.out.println(o.solution("baaaaaab"));
        System.out.println(o.solution("baaaaaaaaaab"));
    }
}
