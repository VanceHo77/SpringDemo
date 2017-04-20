package com.spring.demo.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.UserInfo;

@Component
public class UserInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "empty.account");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password");
	}

}
