package com.javaforge.validators;

import java.util.regex.Pattern;

public final class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_+&*%~-]+(?:\\.[a-zA-Z0-9_+&*%~-]+)*@" +
        "(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,63}$"
    );

    private EmailValidator() {}

    public static boolean isValid(String email) {
        if (email == null || email.isBlank() || email.length() > 254) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
