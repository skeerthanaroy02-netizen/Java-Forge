package com.javaforge.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {

    @Test
    void acceptsStandardEmail() {
        assertTrue(EmailValidator.isValid("user@example.com"));
        assertTrue(EmailValidator.isValid("john.doe@example.com"));
    }

    @Test
    void acceptsSubdomain() {
        assertTrue(EmailValidator.isValid("user@mail.server.example.com"));
    }

    @Test
    void acceptsSpecialCharactersInLocalPart() {
        assertTrue(EmailValidator.isValid("user+tag@example.co.uk"));
        assertTrue(EmailValidator.isValid("user_name@example.org"));
        assertTrue(EmailValidator.isValid("user-name@example.net"));
        assertTrue(EmailValidator.isValid("user%tag@example.io"));
        assertTrue(EmailValidator.isValid("1234567890@example.com"));
    }

    @Test
    void acceptsCaseInsensitiveEmail() {
        assertTrue(EmailValidator.isValid("USER@EXAMPLE.COM"));
        assertTrue(EmailValidator.isValid("John.Doe@Example.Com"));
    }

    @Test
    void acceptsLongTopLevelDomain() {
        assertTrue(EmailValidator.isValid("user@example.photography"));
        assertTrue(EmailValidator.isValid("user@example.international"));
    }

    @Test
    void rejectsNull() {
        assertFalse(EmailValidator.isValid(null));
    }

    @Test
    void rejectsEmptyOrWhitespace() {
        assertFalse(EmailValidator.isValid(""));
        assertFalse(EmailValidator.isValid("   "));
        assertFalse(EmailValidator.isValid("\t"));
        assertFalse(EmailValidator.isValid("\n"));
    }

    @Test
    void rejectsSurroundingWhitespace() {
        assertFalse(EmailValidator.isValid(" user@example.com"));
        assertFalse(EmailValidator.isValid("user@example.com "));
        assertFalse(EmailValidator.isValid(" user@example.com "));
    }

    @Test
    void rejectsInternalWhitespace() {
        assertFalse(EmailValidator.isValid("user name@example.com"));
        assertFalse(EmailValidator.isValid("user@exam ple.com"));
    }

    @Test
    void rejectsMissingAtSign() {
        assertFalse(EmailValidator.isValid("plainaddress"));
        assertFalse(EmailValidator.isValid("userexample.com"));
    }

    @Test
    void rejectsMissingLocalPart() {
        assertFalse(EmailValidator.isValid("@example.com"));
    }

    @Test
    void rejectsMissingDomainOrTld() {
        assertFalse(EmailValidator.isValid("user@"));
        assertFalse(EmailValidator.isValid("user@example"));
        assertFalse(EmailValidator.isValid("user@example."));
    }

    @Test
    void rejectsInvalidDotsInLocalPart() {
        assertFalse(EmailValidator.isValid(".user@example.com"));
        assertFalse(EmailValidator.isValid("user.@example.com"));
        assertFalse(EmailValidator.isValid("user..name@example.com"));
    }

    @Test
    void rejectsInvalidDotsInDomain() {
        assertFalse(EmailValidator.isValid("user@.example.com"));
        assertFalse(EmailValidator.isValid("user@example..com"));
    }

    @Test
    void rejectsInvalidHyphensInDomain() {
        assertFalse(EmailValidator.isValid("user@-example.com"));
        assertFalse(EmailValidator.isValid("user@example-.com"));
    }

    @Test
    void rejectsInvalidTopLevelDomain() {
        assertFalse(EmailValidator.isValid("user@example.c"));
        assertFalse(EmailValidator.isValid("user@example.123"));
        assertFalse(EmailValidator.isValid("user@example." + "a".repeat(64)));
    }

    @Test
    void rejectsExceedingMaxLength() {
        String longLocal = "a".repeat(250);
        assertFalse(EmailValidator.isValid(longLocal + "@example.com"));
    }
}
