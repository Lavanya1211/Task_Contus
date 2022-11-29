package com.contous.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contous.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Employee findByName(String name);
	
	public List<Employee> findAllByOrderByCreatedAtAsc();
	
	public List<Employee> findByDepartmentId(int id);
	
}
