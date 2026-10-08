package com.javaforge.utilities;

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
    /**
 * Calculates the greatest common divisor of two integers.
 *
 * @param a the first integer
 * @param b the second integer
 * @return the greatest common divisor
 */
public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
        int remainder = a % b;
        a = b;
        b = remainder;
    }

    return a;
}
}
