package com.tatsuowatanabe.postalcodetutorial.validator.annotation;

import java.lang.annotation.*;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tatsuowatanabe.postalcodetutorial.validator.MemoValidator;

@Documented
@Constraint(validatedBy = MemoValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Memo {
	String message() default "Please input a memo.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}