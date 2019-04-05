package com.project.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Orders {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ORDERS_ID")
	private Long id;
	

	@Column(name="ORDERS_STATUS")
	private String status;
	
	@Column(name="ORDERS_PRICE")
	private Double totalPrice;
	
	@Column(name="ORDERS_COOKIE")
	private String jsession;
	
	@JsonManagedReference
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="ORDERS_ID")
	@OrderBy
	private Set<Item> items = new HashSet<>();
	
	@JsonManagedReference
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="ORDERS_ID")
	@OrderBy
	private Owner owner;
	
	
	

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getJsession() {
		return jsession;
	}

	public void setJsession(String jsession) {
		this.jsession = jsession;
	}
	
}
