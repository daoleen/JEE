package com.daoleen.jee.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */

@Constraint(validatedBy = { ZipCodeValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
    String message() default "{com.daoleen.jee.validation.ZipCode.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ZipCode[] value();
    }
}
