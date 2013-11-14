package com.daoleen.jee.validation.test;

import com.daoleen.jee.validation.Address;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */

public class AddressIT {

    @Test
    public void shouldAddressZipCodeFailValidation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Address address = new Address();
        address.setStreet1("Vileyka");
        address.setCity("Minsk");
        address.setZipCode("110-InvalidZipCode");

        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(1, violations.size());
        assertEquals("110-InvalidZipCode", violations.iterator().next().getInvalidValue());
        assertEquals("{com.daoleen.jee.validation.ZipCode.message}", violations.iterator().next().getMessageTemplate());
//        assertEquals("Введен неверный ZipCode", violations.iterator().next().getMessage());

        validatorFactory.close();
    }

}
