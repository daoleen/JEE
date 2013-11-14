package com.daoleen.jee.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, METHOD})
public @interface ThirteenDigits { }
