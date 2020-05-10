package com.naresh.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Passport {

	@Id
	private  Integer passportId;
	
	@Temporal(TemporalType.DATE)
	private  Date    expireDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id_fk",unique = true, nullable = true)
	private Person person;
}
