package com.project.conditional;

import org.springframework.stereotype.Component;

@Component
public class WeekdayDiscountCalculator implements DiscountCalculator {

	@Override
	public double applyDiscount(double price) {
		// TODO Auto-generated method stub
		return price;
	}
}
