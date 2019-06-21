public class DivideTwoInteger {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isPositive = (dividend < 0 && divisor < 0) ||
                (dividend > 0 && divisor > 0);
        if (isPositive)
            return (int) _divide(Math.abs((long) dividend), Math.abs((long) divisor));
        else
            return (int) (0L - _divide(Math.abs((long) dividend), Math.abs((long) divisor)));
    }

    private static long _divide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long offset = 1;
        long newDivisor = divisor;
        while (dividend - newDivisor >= newDivisor) {
            newDivisor = newDivisor << 1;
            offset = offset << 1;
        }
        return offset + _divide(dividend - newDivisor, divisor);
    }

    private static long _divide1(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        int offset = 0;
        while (dividend - divisor >= 0) {
            dividend = dividend - divisor;
            offset++;
        }
        return offset ;
    }

    public static void main(String[] args) {
//        System.out.println(divide(7, 3));
//        System.out.println(divide(-7, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(-7,-3));

//        System.out.println(divide(10,3));
//        System.out.println(divide(3,10));
        System.out.println(divide(-2147483648,2));
    }
}
