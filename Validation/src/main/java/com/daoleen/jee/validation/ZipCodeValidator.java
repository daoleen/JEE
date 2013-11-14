package com.daoleen.jee.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    @Inject @USA
    private ZipCodeChecker checker;
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode zipCode) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.isEmpty()) {
            return true;
        }

        Matcher m = zipPattern.matcher(s);
        if(!m.matches()) {
            return false;
        }

        return checker.isZipCodeValid(s);
    }
}
