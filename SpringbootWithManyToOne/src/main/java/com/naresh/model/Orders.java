package com.naresh.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@NoArgsConstructor
@Setter
@Getter
public class Orders {
	
	@Id
	private Integer orderId;
	private String  itemName;
	private Double  price;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	public Orders(Integer orderId, String itemName, Double price) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.price = price;
	}
	
	
	

}
