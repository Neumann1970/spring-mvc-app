package com.project.service;

import com.project.entity.Orders;

public interface OrderService {
	
	Orders createOrder(Orders order);
	
	Iterable<Orders> getAllOrders();

	Iterable<Orders> getOrderByCookie(String cookie);

	void deleteOrderById(Long orderId);

	void setOrderStatus(Long orderId, String value);

}
