
package com.javaforge.utilities;

import java.math.BigInteger;

/** Common numeric operations. */
public final class NumberUtils {
    private NumberUtils() {}

    /** Returns true if n is a prime number. */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int divisor = 3; divisor <= n / divisor; divisor += 2) {
            if (n % divisor == 0) return false;
        }
        return true;
    }

    /** Returns the n-th Fibonacci number. */
    public static BigInteger getFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                "Cannot get Fibonacci number of negative index!");
        }

        if (n < 2) return BigInteger.valueOf(n);

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }

        return current;
    }

    /** Calculates the greatest common divisor of two integers. */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
