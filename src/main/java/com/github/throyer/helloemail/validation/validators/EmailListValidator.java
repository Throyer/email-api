package com.github.throyer.helloemail.validation.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.throyer.helloemail.validation.constraints.IsEmailList;

public class EmailListValidator implements  ConstraintValidator<IsEmailList, List<String>> {

    private static final String REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    @Override
    public boolean isValid(List<String> emails, ConstraintValidatorContext context) {
        return emails.stream().allMatch(email -> email.matches(REGEX));
    }
}