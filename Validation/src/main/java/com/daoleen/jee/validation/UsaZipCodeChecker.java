package com.daoleen.jee.validation;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */

@USA
public class UsaZipCodeChecker implements ZipCodeChecker {
    @Override
    public boolean isZipCodeValid(String zipCode) {
        return zipCode.startsWith("220-");
    }
}
