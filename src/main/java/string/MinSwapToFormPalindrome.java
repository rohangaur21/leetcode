package string;

public class MinSwapToFormPalindrome {

    public static int minSwapPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (!canFormPalindrome(s)) return -1;

        int n = s.length(), swaps = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n / 2; i++) {
            boolean found = false;
            for (int j = n - i - 1; j > i; j--) {
                System.out.println(i + ":" + j);
                if (sb.charAt(j) == sb.charAt(i)) {
                    found = true;
                    for (int k = j; k < n - i - 1; k++) {
                        System.out.println(sb.toString()+" : Swapped 1 = > "+sb.charAt(k)+" with "+sb.charAt(k+1)+" - "+swaps);
                        swap(sb, k, k + 1);
                        swaps++;
                    }
                    break;
                }
            }

            if (!found && n % 2 != 0) {
                for (int k = i; k < n / 2; k++) {
                    System.out.println(sb.toString()+" : Swapped 2 = > "+sb.charAt(k)+" with "+sb.charAt(k+1)+" - "+swaps);
                    swap(sb, k, k + 1);
                    swaps++;
                }
            }
        }

        return swaps;
    }

    private static void swap(StringBuilder sb, int i, int j) {
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }


    private static boolean canFormPalindrome(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray())
            counts[c - 'a']++;

        boolean hasOdd = false;
        for (int count : counts) {
            if (count % 2 == 0) continue;
            else {
                if (hasOdd)
                    return false;
                hasOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("mamad   "+minSwapPalindrome("mamad"));
//        System.out.println(minSwapPalindrome("asflkj"));
//        System.out.println(minSwapPalindrome("aabb"));
        System.out.println("ntiin  "+ minSwapPalindrome("ntiin"));
    }
}
