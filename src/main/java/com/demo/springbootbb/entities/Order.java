package com.demo.springbootbb.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="orders")
public class Order extends RepresentationModel<Order> {
	
	@Id
	@GeneratedValue
	@JsonView(Views.Internal.class)
	private long orderId;
	//@JsonView(Views.Internal.class)
	private String orderDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)   //multiple Orders can be associated to one user. ALSO // this is going to be a bidirectional relation
	@JsonIgnore    
	private User user;                
	
	
	
	

	public Order() {
		super();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}
