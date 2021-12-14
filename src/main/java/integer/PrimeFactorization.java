package integer;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        int n = 315;
        for (Integer i : primeFactors(n)) {
            System.out.println(i);
        }
    }

    static List<Integer> primeFactors(int n) {
        List<Integer> prime = new ArrayList<>();
        while (n / 2 == 0) {
            prime.add(2);
            n = n / 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                prime.add(i);
                n = n/i;
            }
        }
        if (n > 2) {
            prime.add(n);
        }
        return prime;
    }
}
