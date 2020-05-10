package com.naresh.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.model.Employee;
import com.naresh.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeData;
	
	@ApiOperation(value="Getting List of All Employees")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees()
	{
		return employeeData.findAll();
	}
	
	@GetMapping(value="/allEmployees/V1",produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@ApiOperation(value="Getting List Of Employees in xml format")
	public List<Employee> getAllEmployessXml(){
		return employeeData.findAll();
	}
	
	@GetMapping(value="/getEmployeId/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved  Employee"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@ApiOperation(value="Getting Employee By Id")
	public Optional<Employee> getEmployeeById(@PathVariable long id )
	{
		Optional<Employee> emp= employeeData.findById(id);
		if(emp.isPresent())
		{
			return emp;
		}else {
			return Optional.empty();
		}
	}
	
	@PostMapping("/employeesave")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully Employee Saved"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@ApiOperation(value="Employee Object Saved Successfully")
	public Employee newEmployeeAdd( @RequestBody Employee emp) {
		return employeeData.save(emp);
		
	}
	
	@ApiOperation(value="List of Dempartment  of Home in custome sql Queries")
	@GetMapping(value="/dept",produces=MediaType.APPLICATION_XML_VALUE)
	public List<Employee> getDeptDetails() {
		return employeeData.getDeptDetails();
	}
	
	
	
	
	
	

}
