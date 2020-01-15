package integer;

public class CheckIfNumberPowerToN {
    public static void main(String[] args) {
        int num = 1000;
        int n = 10;
        System.out.println(isNumHasPowerToN(num, n));
    }

    public static boolean isNumHasPowerToN(int num, int n) {
        if (num == 1)
            return (n == 1);
        int pow = 1;
        while (pow < num) {
            pow *= n;
        }
        return (pow == num);

    }
}
