/**
 * 
 */
package com.lyngon.demo.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Himanshu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
	
	  
	    @NotBlank
	    @Size(min=4,max=100)
		private String name;
	    
		@Email(message ="Invalid Email format")
		private String email;
		
		@Min(18)
		@Max(99)
		private Integer age;
		
		@NotBlank
		@Pattern(regexp = "[0-9]*$",message = "Invalid mobile number format")
		@Size(min=6,max=14)
		private String phoneNumber;
	
	

}
