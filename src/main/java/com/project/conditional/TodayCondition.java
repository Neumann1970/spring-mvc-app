package com.project.conditional;

import java.util.Calendar;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TodayCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		 Calendar cal = Calendar.getInstance();
		    if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
		      return true;
		    }
		return false;
	}
}
