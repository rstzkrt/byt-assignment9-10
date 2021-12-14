package com.group14.billetsystem.person;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final String email;

    private Email(String email) {
        this.email = email;
    }

    public static Optional<Email> getInstance(String email) {
        if (validate(email)) {
            return Optional.of(new Email(email));
        }
        return Optional.empty();

    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public String toString() {
        return  email;
    }
}
