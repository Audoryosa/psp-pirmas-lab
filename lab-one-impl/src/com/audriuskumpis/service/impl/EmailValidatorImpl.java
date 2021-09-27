package com.audriuskumpis.service.impl;

import com.audriuskumpis.service.EmailValidator;

import java.util.Arrays;
import java.util.Objects;

public class EmailValidatorImpl implements EmailValidator
{
    private static final String ILLEGAL_FIRST_CHARS = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String[] ILLEGAL_TLD_CHARS = " !\"#$%&'()*+,/:;<=>?@[\\]^_`{|}~".split("");

    public boolean HasAtSign(String email)
    {
        Objects.requireNonNull(email);
        return containsEta(email);
    }

    public boolean CheckForbiddenSymbols(String email) {
        Objects.requireNonNull(email);
        String firstChar = email.substring(0, 1);
        return !ILLEGAL_FIRST_CHARS.contains(firstChar);
    }

    // https://stackoverflow.com/questions/9238640/how-long-can-a-tld-possibly-be
    public boolean CheckTLD(String email)
    {
        Objects.requireNonNull(email);
        int indexOfEta = email.indexOf('@');
        if (indexOfEta == -1) {
            return false;
        }
        String afterEta = email.substring(indexOfEta + 1);
        long countOfDots = afterEta.chars().filter(chr -> chr == '.').count();
        if (countOfDots < 1) {
            return false;
        }
        String[] tlds = afterEta.split("\\.");

        for (String tld : tlds) {
            if (tld.length() < 2 || tld.length() > 63) {
                return false;
            }
            boolean hasIllegalChars = Arrays.stream(ILLEGAL_TLD_CHARS).anyMatch(tld::contains);
            if (hasIllegalChars) {
                return false;
            }
        }
        return true;
    }

    private boolean containsEta(String email) {
        return email.contains("@");
    }
}
