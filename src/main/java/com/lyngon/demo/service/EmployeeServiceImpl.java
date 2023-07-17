/**
 * 
 */
package com.lyngon.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyngon.demo.entity.Employee;
import com.lyngon.demo.repo.EmployeeRepository;

/**
 * @author Himanshu
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(Integer Id) {

		
		if (!employeeRepository.existsById(Id)) {
			
			return null;
		}
		
		return employeeRepository.findById(Id).get();
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	@Transactional
	public boolean deleteEmployee(Integer Id) {
		
		
		if (employeeRepository.existsById(Id)) {
			
			employeeRepository.deleteById(Id);
			
			return true;
		}
		
		return false;
		
		//throw new Application

	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {

		if (!employeeRepository.existsById(employee.getId()))
			{
			  return null; //ResponseEntity.notFound().build();

			}
		return employeeRepository.saveAndFlush(employee);

		//return ResponseEntity.noContent().build();
	}
	
	

}
