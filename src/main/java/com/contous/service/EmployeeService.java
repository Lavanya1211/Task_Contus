package com.contous.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.contous.dao.EmployeeDao;
import com.contous.dto.EmployeeDto;
import com.contous.model.Employee;
import com.google.gson.JsonObject;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ModelMapper mapper;

	public List<EmployeeDto> getEmployees() {
		List<EmployeeDto> employeeList = new ArrayList<>();
		for(Employee e: employeeDao.getEmployees()) {
			EmployeeDto employeeDto = mapper.map(e, EmployeeDto.class);
			employeeList.add(employeeDto);
		}
		
		return employeeList;
	}
	
	public EmployeeDto findByName(String name) {
		
		Employee employee = employeeDao.findByName(name);
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
		String deptName = employee.getDepartment().getName();
		employeeDto.setDepartmentName(deptName);
		return employeeDto;
		
	}
	
	public Employee createEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		return employeeDao.createEmployee(employee);
	}
	
	public List<EmployeeDto> getEmployeesOrderByCreatedAt() {
		List<EmployeeDto> employeeList = new ArrayList<>();
		for(Employee e: employeeDao.getEmployeesOrderbyCreatedAt()) {
			EmployeeDto employeeDto = mapper.map(e, EmployeeDto.class);
			employeeList.add(employeeDto);
		}
		
		return employeeList;
	}
	
	public List<EmployeeDto> findByDepartmentId(int id) {
		List<EmployeeDto> employeeList = new ArrayList<>();
		for(Employee e: employeeDao.findByDepartmentId(id)) {
			EmployeeDto employeeDto = mapper.map(e, EmployeeDto.class);
			employeeList.add(employeeDto);
		}
		
		return employeeList;
	}
	
	public List<EmployeeDto> getRequiredColumns() {
		SqlRowSet data =  employeeDao.getRequiredColumns();
		List<EmployeeDto> employeeList = new ArrayList<>();
		

		while (data.next()) {
			EmployeeDto employeeDto = new EmployeeDto();
			int id = data.getInt("id");
			String employeeName = data.getString("name");
			String departmentName = data.getString("DEPTNAME");

			employeeDto.setId(id);
			employeeDto.setName(employeeName);
			employeeDto.setDepartmentName(departmentName);
			
			employeeList.add(employeeDto);
		}
		return employeeList;
	}
	
}
