package com.project.pojo;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.project.entity.Item;


@Component
@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
	
	@Autowired
	Set<Item> SetOfItem;

	public Set<Item> getSetOfItem() {
		return SetOfItem;
	}

	public void setSetOfItem(Set<Item> SetOfItem) {
		this.SetOfItem = SetOfItem;
	}
	
	

}
