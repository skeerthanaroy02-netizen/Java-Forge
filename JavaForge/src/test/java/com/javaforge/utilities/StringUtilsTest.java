package com.javaforge.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Nested
    @DisplayName("Tests for reverse method")
    class ReverseTests {

        @Test
        @DisplayName("Should return null when input is null")
        void shouldReturnNullWhenInputIsNull() {
            assertNull(StringUtils.reverse(null));
        }

        @Test
        @DisplayName("Should return empty string when input is empty")
        void shouldReturnEmptyStringWhenInputIsEmpty() {
            assertEquals("", StringUtils.reverse(""));
        }

        @Test
        @DisplayName("Should return the same single character string")
        void shouldReturnSameCharacterForSingleCharString() {
            assertEquals("a", StringUtils.reverse("a"));
        }

        @Test
        @DisplayName("Should reverse standard words and sentences")
        void shouldReverseStandardStrings() {
            assertEquals("avaJ", StringUtils.reverse("Java"));
            assertEquals("egroFavaJ", StringUtils.reverse("JavaForge"));
            assertEquals("edoc gnidliub", StringUtils.reverse("building code"));
        }

        @Test
        @DisplayName("Should reverse strings containing accented characters")
        void shouldReverseStringsWithAccents() {
            assertEquals("éfac", StringUtils.reverse("café"));
            assertEquals("oãçatnemucod", StringUtils.reverse("documentação"));
        }

        @Test
        @DisplayName("Should reverse Unicode code points including emojis without corrupting surrogate pairs")
        void shouldReverseUnicodeCodePointsAndSurrogatePairs() {
            assertEquals("🚀 avaJ", StringUtils.reverse("Java 🚀"));
            assertEquals("🔥⚡", StringUtils.reverse("⚡🔥"));
        }
    }

    @Nested
    @DisplayName("Tests for isPalindrome method")
    class IsPalindromeTests {

        @Test
        @DisplayName("Should return false when input is null")
        void shouldReturnFalseWhenInputIsNull() {
            assertFalse(StringUtils.isPalindrome(null));
        }

        @Test
        @DisplayName("Should return true for empty string")
        void shouldReturnTrueForEmptyString() {
            assertTrue(StringUtils.isPalindrome(""));
        }

        @Test
        @DisplayName("Should return true for single character string")
        void shouldReturnTrueForSingleCharacter() {
            assertTrue(StringUtils.isPalindrome("x"));
            assertTrue(StringUtils.isPalindrome("7"));
        }

        @Test
        @DisplayName("Should identify standard lowercase palindromes")
        void shouldIdentifyStandardPalindromes() {
            assertTrue(StringUtils.isPalindrome("arara"));
            assertTrue(StringUtils.isPalindrome("radar"));
        }
    }
}