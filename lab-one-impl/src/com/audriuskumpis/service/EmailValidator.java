package com.audriuskumpis.service;

public interface EmailValidator {

    /**
     * Checks if given email address contains '@' sign.
     * @param email Email to vheck.
     * @return <code>true</code> if there is an '@' in email, <code>false</code> otherwise.
     */
    public boolean HasAtSign(String email);

    /**
     * Checks given email if it starts with any of illegal characters. Those are:<br>
     *     <code> !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~</code>
     * @param email Email to check.
     * @return <code>true</code> if email does not start with any of illegal characters, <code>false</code> otherwise.
     */
    public boolean CheckForbiddenSymbols(String email);

    /**
     * Checks if a given email contains '@', has a top level domain and checks it's length (2 < length < 63)
     * and if TLD contains any of illegal characters, that are:<br>
     *     <code> !"#$%&'()*+,/:;<=>?@[\]^_`{|}~</code><br>
     * TLD may contain numbers.
     * @param email Email to check.
     * @return <code>true</code> if email's TLD is longer than 2 characters, and shorter than 63, and if TLD does not contain illegal characters,
     *         <code>false</code> if it has no '@' sign or disproves above mentioned rules.
     */
    public boolean CheckTLD(String email);

}
