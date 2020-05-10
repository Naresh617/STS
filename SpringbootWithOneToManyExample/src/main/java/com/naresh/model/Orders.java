package com.naresh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Orders {
	
	public Orders(Integer orderId, String itemName, Double price) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.price = price;
	}
	@Id
	private Integer orderId;
	private String  itemName;
	private Double  price;
	@Column(name = "cust_id")
	private Integer custId;
	
	

}
