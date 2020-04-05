package com.github.throyer.helloemail.validation.constraints;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.github.throyer.helloemail.validation.validators.EmailListValidator;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailListValidator.class)
public @interface IsEmailList {

    String message() default "Por favor, foneça uma lista com emails validos.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}