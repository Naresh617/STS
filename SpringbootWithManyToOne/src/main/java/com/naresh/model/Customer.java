package com.naresh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class Customer {
	
	@Id
	@Column(name = "cust_id")
	private Integer custId;
	private String  custName;
	private Long custMobile;
	
	public Customer(Integer custId, String custName, Long custMobile) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custMobile = custMobile;
	}

	
	

}
