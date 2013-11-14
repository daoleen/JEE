package com.daoleen.jee.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Size(min = 7)
@Pattern(regexp = "[a-z]+@[a-z]+\\.[a-z]+")
@ReportAsSingleViolation
public @interface Email {
    String message() default "{com.daoleen.jee.validation.Email.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default{ };

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Email[] value();
    }
}
