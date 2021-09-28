package com.audriuskumpis.service.impl;

import com.audriuskumpis.service.PasswordChecker;

import java.util.Arrays;
import java.util.Objects;

public class PasswordCheckerImpl implements PasswordChecker {

    private static final String DEFAULT_SPECIAL_CHARS = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private String[] specialChars;

    /**
     * Password checker constructor. Takes a String array of special characters.<br>
     * If <code>specialChars</code> param is empty, default values are used:<code> !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~</code><br>
     * @param specialChars Special characters to be checked in a password
     * @throws NullPointerException if <code>specialChars</code> is null.
     */
    public PasswordCheckerImpl(String[] specialChars) {
        Objects.requireNonNull(specialChars);
        this.specialChars = specialChars;
        if (specialChars.length == 0) {
            this.specialChars = DEFAULT_SPECIAL_CHARS.split("");
        }
    }

    /**
     * Default constructor with default special symbols list, that contains:
     * <code>  !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~</code>
     */
    public PasswordCheckerImpl() {
        this.specialChars = DEFAULT_SPECIAL_CHARS.split("");
    }

    @Override
    public boolean CheckPasswordLength(String password, int length)
    {
        Objects.requireNonNull(password);
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive number.");
        }
        return validateLength(password, length);
    }

    @Override
    public boolean CheckUppercase(String password)
    {
        Objects.requireNonNull(password);
        return hasUppercase(password);
    }

    @Override
    public boolean CheckSpecialSymbol(String password)
    {
        Objects.requireNonNull(password);
        return hasSpecialChar(password);
    }

    @Override
    public String[] getSpecialChars() {
        return specialChars;
    }

    @Override
    public void setSpecialChars(String[] specialChars) {
        Objects.requireNonNull(specialChars);
        this.specialChars = specialChars;
    }

    private boolean validateLength(String password, int length) {
        return password.length() >= length;
    }

    private boolean hasUppercase(String password) {
        return !password.toLowerCase().equals(password);
    }

    private boolean hasSpecialChar(String password) {
        return Arrays.stream(specialChars).anyMatch(password::contains);
    }

    @Override
    public String toString() {
        String specialCharsString = String.join("", specialChars);
        return "PasswordChecker:[specialChars: " + specialCharsString + "]";
    }
}
