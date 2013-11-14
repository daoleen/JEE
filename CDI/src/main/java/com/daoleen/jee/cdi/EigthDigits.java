package com.daoleen.jee.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Qualifier
@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
public @interface EigthDigits { }