package com.naresh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@XmlRootElement(name="Employee")
@JacksonXmlRootElement(localName = "Employee")
@ApiModel(description = "All details about the Employee. ")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@XmlElement
	@JacksonXmlProperty(isAttribute = true)
	@ApiModelProperty(notes = "The database generated employee ID")
	private long id;
	@XmlElement
	@JacksonXmlProperty
	@ApiModelProperty(notes = "The employee  name")
	private String name;
	@XmlElement
	@JacksonXmlProperty
	@ApiModelProperty(notes = "The employee department name")
	private String dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public Employee() {}

}