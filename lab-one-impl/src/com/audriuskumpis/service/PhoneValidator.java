package com.audriuskumpis.service;

public interface PhoneValidator {

    /**
     * Chekcs if given string contains only numbers (except prefix of '+' if present).
     * @param phone Phone number to check.
     * @return <code>true</code> if phone number contains only numbers, <code>false</code> otherwise.
     */
    public boolean CheckNumbers(String phone);

    /**
     * Changes the prefix of phone number from "8" to "+370".
     * @param phone Phone number to modify.
     * @return A phone number starting with "+370".
     */
    public String ChangeStart(String phone);

    /**
     * Adds new prefix and phone number length to validate against.
     * @param Prefix A new prefix of a phone number.
     * @param length A new length of a phone number.
     * @return returns an empty string (not my idea).
     */
    public String AddNewValidationRule(String Prefix, int length);

    /**
     * Returns the currently used phone number prefix. Default is "+370".
     * @return The phone number prefix.
     */
    public String getPhoneNumberPrefix();

    /**
     * Sets the prefix to be used in phone number transformations and validations.
     * @param phoneNumberPrefix A prefix in the format "+123"
     */
    public void setPhoneNumberPrefix(String phoneNumberPrefix);

    /**
     * Returns currently defined phone number length to be used in validations. Default is 12 (long format).
     * @return The length of currently used phone number length.
     */
    public int getPhoneNumberLength();

    /**
     * Sets a new custom phone number length to be used in verifications.
     * @param phoneNumberLength An integer length.
     */
    public void setPhoneNumberLength(int phoneNumberLength);
}
