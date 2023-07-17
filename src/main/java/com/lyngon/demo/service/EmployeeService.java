/**
 * 
 */
package com.lyngon.demo.service;

import java.util.List;

import com.lyngon.demo.entity.Employee;

/**
 * @author Himanshu
 *
 */

public interface EmployeeService {
	
	
	
	List<Employee> getEmployees();
	
	Employee getEmployeebyId(Integer Id);
	
	Employee addEmployee(Employee employee);
	
   boolean deleteEmployee(Integer Id);
	
   Employee updateEmployee(Employee employee);
   
	


}
