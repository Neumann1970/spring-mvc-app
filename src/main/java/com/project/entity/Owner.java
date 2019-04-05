package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Owner {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="OWNER_ID")
	private Long id;
	
    @Column(name="OWNER_NAME")
	private String name;
	
    @Column(name="OWNER_EMAIL")
	private String email;
	
    @Column(name="OWNER_PHONE")
	private String phone;
	
	@JsonBackReference
  	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ORDER_ID")
	private Orders order;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	

}
