package com.naresh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class Customer {
	
	@Id
	@Column(name = "cust_id")
	private Integer custId;
	public Customer(Integer custId, String custName, Long custMobile) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custMobile = custMobile;
	}

	private String  custName;
	private Long custMobile;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
	private Set<Orders> orders;

}
