package com.group14.billetsystem.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;
    private final String surname;
    private final LocalDate birthdate;
    private Email email;
    private Status status;

    public Person(String name, String surname, LocalDate birthdate, Email email, Status status) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Optional<Person> createPerson(String name, String surname, LocalDate birthdate, String email, Status status) {
        if (validateName(name) && validateName(surname) && validateDate(birthdate) && validateEmail(email)){
            return Optional.of(new Person(name,surname,birthdate,Email.getInstance(email).get(),status));
        }
        return Optional.empty();
    }

    private static boolean validateName(String name){
        return name != null && name.matches("[A-Z][a-z]{2,30}");
    }

    /**
     * Only persons older than 7 and younger than 90
     * @param birthdate
     * @return
     */
    private static boolean validateDate(LocalDate birthdate){
        final long years = birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
        return years >= 7 && years <= 90;
    }

    private static boolean validateEmail(String email){
        return Email.validate(email);
    }
}
