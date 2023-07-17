package com.lyngon.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lyngon.demo.entity.Employee;
import com.lyngon.demo.repo.EmployeeRepository;
import com.lyngon.demo.service.EmployeeServiceImpl;

@SpringBootTest
class LyngonDemoApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	
	
	
	@Test
	public void test_getEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "testuser1", "test1@gmail.com", 23, "11313232"));
		employees.add(new Employee(2, "testuser2", "test2@gmail.com", 25, "113144232"));
		when(employeeRepository.findAll()).thenReturn(employees);
		
		
		assertEquals(2, employeeService.getEmployees().size());
	}

	
	
	@Test
	public void test_getEmployeeById() {
		
		Integer id = 1;
		Optional<Employee> employee = Optional.ofNullable(new Employee(1,"testuser1", "test1@gmail.com", 23, "11313232"));
		
		when(employeeRepository.existsById(id)).thenReturn(true);
		when(employeeRepository.findById(id)).thenReturn(employee);
		
		assertEquals(1, employeeService.getEmployeebyId(id).getId());
	}
	
	
	@Test
	public void test_addEmployee() {
		
		Employee employee = new Employee(1,"testuser3", "test3@gmail.com", 27, "113135232");
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.addEmployee(employee));
	}
	
	
	@Test
	public void test_updateEmployee() {
		
		Employee employee = new Employee(1,"testuser3", "test3updated@gmail.com", 27, "113135232");
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals("test3updated@gmail.com", employeeService.addEmployee(employee).getEmail());
	}
	
	@Test
	public void test_deleteEmployee() {
		
		Employee employee = new Employee(1,"testuser3", "test3updated@gmail.com", 27, "113135232");
		when(employeeRepository.existsById(isA(Integer.class))).thenReturn(true);
		
		doNothing().when(employeeRepository).deleteById(isA(Integer.class));
		   
		employeeService.deleteEmployee(employee.getId());
		verify(employeeRepository, times(1)).deleteById(isA(Integer.class)) ;
		
	}
	
}
