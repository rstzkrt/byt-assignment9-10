package com.group14.billetsystem.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final String GOOD_NAME = "Bolo";
    private static final String GOOD_SURNAME = "Test";
    private static final LocalDate GOOD_BIRTHDATE = LocalDate.of(1995, 8, 9);
    private static final String GOOD_EMAIL = "bolo.test@testMail.com";


    @Test
    public void shouldCreatePerson() {
        Optional<User> person = User.createPerson(GOOD_NAME, GOOD_SURNAME, GOOD_BIRTHDATE, GOOD_EMAIL, Status.NORMAL);
        assertTrue(person.isPresent());
        User p = person.get();
        assertEquals(p.getName(), GOOD_NAME);
        assertEquals(p.getSurname(), GOOD_SURNAME);
        assertEquals(p.getBirthdate(), GOOD_BIRTHDATE);
        assertEquals(p.getEmail().toString(), GOOD_EMAIL);
        assertEquals(p.getStatus(), Status.NORMAL);
    }

    @Test
    public void shouldNotCreatePersonWithBadName() {
        String nullName = null;
        Optional<User> person = createPersonWithCustomName(nullName);
        assertFalse(person.isPresent());

        String emptyName = "";
        person = createPersonWithCustomName(emptyName);
        assertFalse(person.isPresent());

        String badLetters = "Tąę";
        person = createPersonWithCustomName(badLetters);
        assertFalse(person.isPresent());

        String toShort = "T";
        person = createPersonWithCustomName(toShort);
        assertFalse(person.isPresent());

        String toLong = "Tttttttttttqwerrrrrrrrrrrqwerqwreqwerqwerqwerqwerqwer";
        person = createPersonWithCustomName(toLong);
        assertFalse(person.isPresent());

        String smallFirstLetter = "test";
        person = createPersonWithCustomName(smallFirstLetter);
        assertFalse(person.isPresent());

    }

    @Test
    public void shouldNotCreatePersonWithSurname() {
        String nullName = null;
        Optional<User> person = createPersonWithCustomSurname(nullName);
        assertFalse(person.isPresent());

        String emptyName = "";
        person = createPersonWithCustomSurname(emptyName);
        assertFalse(person.isPresent());

        String badLetters = "Tąę";
        person = createPersonWithCustomSurname(badLetters);
        assertFalse(person.isPresent());

        String toShort = "T";
        person = createPersonWithCustomSurname(toShort);
        assertFalse(person.isPresent());

        String toLong = "Tttttttttttqwerrrrrrrrrrrqwerqwreqwerqwerqwerqwerqwer";
        person = createPersonWithCustomSurname(toLong);
        assertFalse(person.isPresent());

        String smallFirstLetter = "test";
        person = createPersonWithCustomSurname(smallFirstLetter);
        assertFalse(person.isPresent());
    }

    @Test
    public void shouldNotCreatePersonWithBadBirtDate() {
        LocalDate toOld = LocalDate.now().minus(91, ChronoUnit.YEARS);
        Optional<User> person = createPersonWithCustomBirthdate(toOld);
        assertFalse(person.isPresent());
        LocalDate toYoung = LocalDate.now().minus(6, ChronoUnit.YEARS);
        person = createPersonWithCustomBirthdate(toYoung);
        assertFalse(person.isPresent());
        LocalDate now = LocalDate.now();
        person = createPersonWithCustomBirthdate(now);
        assertFalse(person.isPresent());
    }


    private static Optional<User> createPersonWithCustomName(String name) {
        return User.createPerson(name, GOOD_SURNAME, GOOD_BIRTHDATE, GOOD_EMAIL, Status.NORMAL);
    }

    private static Optional<User> createPersonWithCustomSurname(String surname) {
        return User.createPerson(GOOD_NAME, surname, GOOD_BIRTHDATE, GOOD_EMAIL, Status.NORMAL);
    }

    private static Optional<User> createPersonWithCustomBirthdate(LocalDate localDate) {
        return User.createPerson(GOOD_NAME, GOOD_SURNAME, localDate, GOOD_EMAIL, Status.NORMAL);
    }
}