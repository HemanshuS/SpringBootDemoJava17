/**
 * 
 */
package com.lyngon.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Himanshu
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	
    public Employee(String name, String email, Integer age, String phoneNumber) {
		
    	this.name = name;
    	this.email = email;
    	this.age = age;
    	this.phoneNumber = phoneNumber;
    	
    	
	}
    
	@GeneratedValue
	@Id private Integer id;
    
	private String name;
	
	private String email;
	
	
	private Integer age;
	
	
	private String phoneNumber;

}
