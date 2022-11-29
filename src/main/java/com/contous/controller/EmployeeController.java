package com.contous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contous.dto.EmployeeDto;
import com.contous.model.Employee;
import com.contous.service.EmployeeService;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@PostMapping("/create")
	public ResponseEntity<Employee> createUser(@RequestBody EmployeeDto employeeDto) {
		Employee e = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<EmployeeDto>> findAll() {
		List<EmployeeDto> employeeList = employeeService.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	
	@GetMapping("/findbyname")
	public ResponseEntity<EmployeeDto> findByName(@RequestParam("name") String employeeName) {
		return  new ResponseEntity<>(employeeService.findByName(employeeName), HttpStatus.OK); 
	}
	
	@GetMapping("/orderbycreatedat")
	public ResponseEntity<List<EmployeeDto>> findAllOrderByCreatedAt() {
		return  new ResponseEntity<>(employeeService.getEmployeesOrderByCreatedAt(), HttpStatus.OK); 
	}
	
	@GetMapping("/find/dept/{id}")
	public ResponseEntity<List<EmployeeDto>> findByDepartmentId(@PathVariable int id) {
		return  new ResponseEntity<>(employeeService.findByDepartmentId(id), HttpStatus.OK); 
	}
	
	@GetMapping("/getcolumns")
	public ResponseEntity<Object> getRequiredColumns() {
		return new ResponseEntity<>(employeeService.getRequiredColumns(), HttpStatus.OK);
	}
}
