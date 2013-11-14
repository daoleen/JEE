package com.daoleen.jee.validation.test;

import com.daoleen.jee.validation.Customer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */

public class CustomerIT {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void destroy() {
        validatorFactory.close();
    }


    @Test
    public void customerSuccessEmailValidation() {
        Customer customer = new Customer();
        customer.setFirstName("Misha");
        customer.setEmail("customer@myshop.com");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1998, 11, 27);
        customer.setDateOfBirth(calendar.getTime());

        Logger l  = Logger.getAnonymousLogger();
        Set<ConstraintViolation<Customer>> viols = validator.validate(customer);

        for(ConstraintViolation<Customer> c : viols) {
            l.info(c.getMessage());
        }

        assertEquals(0, viols.size());
    }


    @Test
    public void customerFailEmailValidation() {
        Customer customer = new Customer();
        customer.setFirstName("Misha");
        customer.setLastName("Kraevsky");
        customer.setEmail("My Invalid Email");

        Set<ConstraintViolation<Customer>> viols = validator.validate(customer);
        assertEquals(1, viols.size());
        //assertEquals("Неверный e-mail address", viols.iterator().next().getMessage());
        assertEquals("{com.daoleen.jee.validation.Email.message}", viols.iterator().next().getMessageTemplate());
        assertEquals("My Invalid Email", viols.iterator().next().getInvalidValue());
    }
}
