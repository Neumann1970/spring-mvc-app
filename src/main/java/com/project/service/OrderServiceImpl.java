package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.OrderRepository;
import com.project.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderRepository orderRepository;

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public Orders createOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public Iterable<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	
	@Transactional
	@Override
	public Iterable<Orders> getOrderByCookie(String cookie) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderByJsession(cookie) ;
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public void deleteOrderById(Long orderId) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderId);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public void setOrderStatus(Long orderId,String value) {
		orderRepository.setOrderStatus(orderId, value);
	}

}
