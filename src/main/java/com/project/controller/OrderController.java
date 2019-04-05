package com.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Orders;
import com.project.service.OrderService;
import com.project.validate.OrderValidator;



@RestController
public class OrderController {
	
	
	 @Autowired
	  private OrderService orderService;
	

	 	@RequestMapping(value="/orders/admin", method=RequestMethod.GET)
		public ResponseEntity<Iterable<Orders>> getAllOrder() {
	 			Iterable<Orders> allOrders = orderService.getAllOrders();
				return new ResponseEntity<>(allOrders, HttpStatus.OK);
	 	
		}

	 	@RequestMapping(value="/orders", method=RequestMethod.GET)
		public ResponseEntity<Iterable<Orders>> getUniqueOrder( @CookieValue(value="JSESSIONID", defaultValue="nullableValue") String myCookie) {
			
	 		if(myCookie != "nullableValue") {
	 			Iterable<Orders> allOrders = orderService.getOrderByCookie(myCookie);
				return new ResponseEntity<>(allOrders, HttpStatus.OK);
	 		}
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	
		 @RequestMapping(value="/orders", method=RequestMethod.POST) 
		 public ResponseEntity<?> createOrder(@RequestBody Orders order, BindingResult result){
			 
			 OrderValidator validator = new OrderValidator();
			 
			 validator.validate(order, result);
			 
			 if(result.hasErrors()) {
				 return new ResponseEntity<>(new String("Please login again!!"), HttpStatus.OK);
			 }
			 else {
				 
				 orderService.createOrder(order);
				 return new ResponseEntity<>(order, HttpStatus.OK);
				 
			 }
		 }
		 
		 
		 @RequestMapping(value="/orders/admin/{orderId}", method=RequestMethod.DELETE)
			public ResponseEntity<?> deleteOrderById(@PathVariable Long orderId) {
			 orderService.deleteOrderById(orderId);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		 
		 @RequestMapping(value="/orders/admin/{orderId}/status/{value}", method=RequestMethod.POST)
			public ResponseEntity<?> setStusOfOrder(@PathVariable Long orderId,@PathVariable String value) {
			 orderService.setOrderStatus(orderId,value);
				return new ResponseEntity<>(HttpStatus.OK);
			}
}
