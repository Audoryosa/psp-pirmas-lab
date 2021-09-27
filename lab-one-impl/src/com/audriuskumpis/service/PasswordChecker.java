package com.audriuskumpis.service;

public interface PasswordChecker {
    /**
     * Checks password to be at least as long as a given parameter.
     * @param password A password to be checked.
     * @param length A desired length of a passowrd.
     * @return <code>true</code> if password is not too short, <code>false</code> otherwise.
     */
    public boolean CheckPasswordLength(String password, int length);

    /**
     * Checks if a password contains upper case characters.
     * @param password A Password to be checked.
     * @return <code>true</code> if password contains uppercase, <code>false</code> otherwise.
     */
    public boolean CheckUppercase(String password);

    /**
     * Checks if a password contains as least one special characters.
     * @param password A Password to be checked.
     * @return <code>true</code> if password contains at least one special character, <code>false</code> otherwise
     */
    public boolean CheckSpecialSymbol(String password);

    /**
     * Get the current special characters array.
     * @return An array of used special characters.
     */
    public String[] getSpecialChars();

    /**
     * Define custom array of special symbols that will be used for password verification.
     * @param specialChars An array of custom special characters.
     */
    public void setSpecialChars(String[] specialChars);

}
