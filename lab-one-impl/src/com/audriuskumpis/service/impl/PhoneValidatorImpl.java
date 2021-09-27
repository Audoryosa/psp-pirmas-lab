package com.audriuskumpis.service.impl;

import com.audriuskumpis.service.PhoneValidator;

public class PhoneValidatorImpl implements PhoneValidator {

    private String phoneNumberPrefix;
    private int phoneNumberLength;

    /**
     * Creates a phone number validation class with default
     * phone number prefix of "+370" (Lithuanian)
     * and length of a phone number of 12.
     */
    public PhoneValidatorImpl() {
        this.phoneNumberPrefix = "+370";
        this.phoneNumberLength = 12;
    }

    @Override
    public boolean CheckNumbers(String phone)
    {
        if (phone.startsWith("+")) {
            phone = phone.substring(1);
        }
        try {
            // if parsing fails, it means that string is not a number.
            long parsedNumber = Long.parseLong(phone);
        } catch (NumberFormatException e) {
            return false;
        }
        if (("+" + phone).length() != phoneNumberLength) {
            System.err.println("Phone number has bad length of " + ("+" + phone).length());
            return false;
        }
        return true;
    }

    @Override
    public String ChangeStart(String phone)
    {
        if (phone.startsWith("8")) {
            phone = phone.substring(1);
            phone = phoneNumberPrefix + phone;
        }
        return phone;
    }

    @Override
    public String AddNewValidationRule(String Prefix, int length)
    {
        this.phoneNumberPrefix = Prefix;
        this.phoneNumberLength = length;
        return "";
    }

    @Override
    public String getPhoneNumberPrefix() {
        return phoneNumberPrefix;
    }

    @Override
    public void setPhoneNumberPrefix(String phoneNumberPrefix) {
        this.phoneNumberPrefix = phoneNumberPrefix;
    }

    @Override
    public int getPhoneNumberLength() {
        return phoneNumberLength;
    }

    @Override
    public void setPhoneNumberLength(int phoneNumberLength) {
        this.phoneNumberLength = phoneNumberLength;
    }
}
