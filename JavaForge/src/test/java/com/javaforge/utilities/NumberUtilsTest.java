package com.javaforge.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {
    @Test void identifiesPrimes() {
        assertTrue(NumberUtils.isPrime(2));
        assertTrue(NumberUtils.isPrime(97));
    }
    @Test void rejectsNonPrimes() {
        assertFalse(NumberUtils.isPrime(-7));
        assertFalse(NumberUtils.isPrime(0));
        assertFalse(NumberUtils.isPrime(1));
        assertFalse(NumberUtils.isPrime(100));
    }
    @Test
void calculatesGcdForCommonValues() {
    assertEquals(4, NumberUtils.gcd(12, 8));
}

@Test
void calculatesGcdForCoprimeNumbers() {
    assertEquals(1, NumberUtils.gcd(7, 13));
}

@Test
void calculatesGcdForEqualNumbers() {
    assertEquals(9, NumberUtils.gcd(9, 9));
}

@Test
void handlesZeroInputs() {
    assertEquals(5, NumberUtils.gcd(0, 5));
    assertEquals(5, NumberUtils.gcd(5, 0));
    assertEquals(0, NumberUtils.gcd(0, 0));
}

@Test
void handlesNegativeInputs() {
    assertEquals(4, NumberUtils.gcd(-12, 8));
    assertEquals(4, NumberUtils.gcd(12, -8));
    assertEquals(4, NumberUtils.gcd(-12, -8));
}
}
