package com.project.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.entity.Orders;

public class OrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Orders order = (Orders)target;
		
		if(order.getJsession().equalsIgnoreCase("erqwreqwerqwer")) {
			errors.rejectValue("jsession", "Please create session again!!!");
		}
		
	}

	
}
