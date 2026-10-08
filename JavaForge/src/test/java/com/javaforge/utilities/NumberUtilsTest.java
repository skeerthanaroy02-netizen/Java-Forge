package com.javaforge.utilities;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.javaforge.utilities.NumberUtils.isPrime;
import static com.javaforge.utilities.NumberUtils.getFibonacci;

class NumberUtilsTest {

    @Test void identifiesPrimes() {
        assertTrue(isPrime(2));
        assertTrue(isPrime(97));
    }

    @Test void rejectsNonPrimes() {
        assertFalse(isPrime(-7));
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
        assertFalse(isPrime(100));
    }

    @Test void rejectsNegativeFibonacciIndices() {
        assertThrows(IllegalArgumentException.class, () -> getFibonacci(-1));
        assertThrows(IllegalArgumentException.class, () -> getFibonacci(Integer.MIN_VALUE));
    }

    @Test void returnsFibonacciBaseCasesAndNormalValues() {
        assertEquals(BigInteger.ZERO, getFibonacci(0));
        assertEquals(BigInteger.ONE, getFibonacci(1));
        assertEquals(BigInteger.ONE, getFibonacci(2));
        assertEquals(BigInteger.valueOf(5), getFibonacci(5));
        assertEquals(BigInteger.valueOf(55), getFibonacci(10));
    }

    @Test void returnsValuesLargerThanIntWithoutOverflow() {
        assertEquals(new BigInteger("1836311903"), getFibonacci(46));
        assertEquals(new BigInteger("2971215073"), getFibonacci(47));
        assertEquals(new BigInteger("354224848179261915075"), getFibonacci(100));
    }
}
