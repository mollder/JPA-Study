package org.ingue.jpa.presentation.member.support.validator;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ConstraintComposition(CompositionType.AND)
@Target({ METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNum {
    public abstract String message() default "must be enter only 10 or 11 digits number.";

    public abstract Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}