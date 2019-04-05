package com.project.controller;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Item;
import com.project.entity.Orders;
import com.project.entity.Owner;
import com.project.pojo.Cart;
import com.project.service.OrderService;


@RestController
public class CartController {
	
	  @Autowired
	  private Cart cart;
	  
	  @Autowired
	  private OrderService orderService;
	  
	  @RequestMapping(value="/cart", method=RequestMethod.GET)
	  public ResponseEntity<Set<Item>> getCart( @CookieValue(value="JSESSIONID", defaultValue="nullableValue") String myCookie) {  

		  	System.out.println("myCookie: "+myCookie);	  
			Set<Item> forReturn = cart.getSetOfItem();		
			nullableClear(forReturn);
			
			System.out.println(orderPriceCalculate(forReturn));
			return new ResponseEntity<>(forReturn, HttpStatus.OK);
		}
	
	  @RequestMapping(value="/cart", method=RequestMethod.POST)
	  public ResponseEntity<Set<Item>> addItemInCart(@RequestBody Item item) {
		  
		  	Double itemPrice = item.getQuantity()*item.getProductPrice();
		  	item.setItemPrice(itemPrice);
		  	
			Set<Item> forReturn = cart.getSetOfItem();	
			forReturn.add(item);
			
			//System.out.println(orderPriceCalculate(forReturn));
			return new ResponseEntity<>(forReturn, HttpStatus.OK);
		}
	  
	  
	  
	  @RequestMapping(value="/cart/commit", method=RequestMethod.POST)
	  public ResponseEntity<Orders> cartCommit(@CookieValue(value="JSESSIONID", defaultValue="nullableValue") String myCookie,
			  @RequestBody Owner owner) {
		  Set<Item> currentCart = cart.getSetOfItem(); 
		  
		  Orders orderForCreate = new Orders();
		  
		  orderForCreate.setStatus("NEW");
		  orderForCreate.setTotalPrice(orderPriceCalculate(currentCart));
		  orderForCreate.setJsession(myCookie);
		  orderForCreate.setItems(currentCart);
		  orderForCreate.setOwner(owner);
		  
		  orderService.createOrder(orderForCreate);
		  
		  return new ResponseEntity<>(orderForCreate, HttpStatus.OK);
		  
	  }
	  
	  
	  
	  public Set<Item> nullableClear(Set<Item> items){
		  Iterator<Item> iter = items.iterator();
		  
		  while(iter.hasNext()) {
			  if(iter.next().getProductName()==null) {
				  iter.remove();
				  System.out.println("Found nullable");
				  System.out.println("And delete it!!!");
			  }	  
		  }
		  return items;  
	  }
	  
	  
	  public Double orderPriceCalculate(Set<Item> items) {
		 double totalPrice = 0;
		  Iterator<Item> iter = items.iterator();
		  while(iter.hasNext()) {
			  totalPrice+= iter.next().getItemPrice();
			  System.out.println(totalPrice);   
		  }
		  return totalPrice;
	  }
	  
	  
}
