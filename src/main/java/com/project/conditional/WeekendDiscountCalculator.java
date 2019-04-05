package com.project.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(WeekendCondition.class)
public class WeekendDiscountCalculator implements DiscountCalculator {

	@Override
	public double applyDiscount(double price) {
		// TODO Auto-generated method stub
		return 0.90 * price;
	}
}
