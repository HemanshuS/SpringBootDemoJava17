/**
 * 
 */
package com.lyngon.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

public class EmployeeSignUpDto {
	
    public EmployeeSignUpDto(String name, String email) {
		
    	this.name = name;
    	this.email = email;
	}
    
    @NotNull
	private Integer id;
    @NotBlank
	private String name;
	@Email(message ="Invalid Email format")
	private String email;
	
	@Min(18)
	@Max(99)
	private Integer age;
	
	@NotBlank
	@Pattern(regexp = "[0-9]*$",message = "Invalid mobile number format")
	private String phoneNumber;
	

}
