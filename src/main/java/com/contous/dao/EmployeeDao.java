package com.contous.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.contous.model.Employee;
import com.contous.repo.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	public Employee findByName(String name) {
		return employeeRepo.findByName(name);
	}

	public List<Employee> getEmployeesOrderbyCreatedAt() {
		return employeeRepo.findAllByOrderByCreatedAtAsc();
	}

	public List<Employee> findByDepartmentId(int id) {
		return employeeRepo.findByDepartmentId(id);
	}

	public SqlRowSet getRequiredColumns() {
		return jdbcTemplate.queryForRowSet(
				"select e.id as id, e.name as name, d.name as deptname from employee e inner join department d on(e.department_id = d.id)");

	}

}
