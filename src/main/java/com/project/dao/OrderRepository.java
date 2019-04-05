package com.project.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {
	
	@Query(value="select * from Orders where ORDERS_COOKIE = ?1", nativeQuery = true)
	public Iterable<Orders> findByOrderByJsession(String cookie);
	
	@Modifying
	@Query(value="update orders set ORDERS_STATUS = ?2 where ORDERS_ID = ?1", nativeQuery = true)
	public void setOrderStatus(Long orderId, String status);

}
