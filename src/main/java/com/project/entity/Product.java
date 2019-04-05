package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Component
public class Product {
	
	  	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="PRODUCT_ID")
		private Long id;
	  	
	  	@Column(name="PRODUCT_NAME")
	  	private String name;
	  	
	  	@JsonBackReference
	  	@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="CAT_ID")
		private Category category;
	  	
	  	@Column(name="PRODUCT_PRICE")
	  	private Double price;

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
		

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + "]";
		}
	  	
	  	

}
