package com.spring.demo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.UserInfo;

public class UserInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "帳號不可為空");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "密碼不可為空");
	}

}
