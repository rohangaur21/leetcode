package string;

public class ZigZagString {

    public int reverse(int x) {
        return helper(x, 0);
    }

    public int helper(int n, int pow){
        System.out.println(n +" "+pow);
        if(n < 10){
            return (int) (n * Math.pow(10,pow));
        }
        return n%10 * 10^pow + helper(n/10, ++pow);
    }

    public static void main(String[] args) {


    }
}
