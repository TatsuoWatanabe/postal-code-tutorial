package com.tatsuowatanabe.postalcodetutorial.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tatsuowatanabe.postalcodetutorial.validator.annotation.Memo;

public class MemoValidator implements ConstraintValidator<Memo, String> {

	@Override
	public void initialize(Memo memo) {
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext con) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		if (input.matches("^[0-9]*$")) {
			return false;
		}
		return true;
	}
}
