/**
 * 
 */
package com.lyngon.demo.aop;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyngon.demo.exception.ApplicaionException;

/**
 * @author Himanshu
 *
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> invalidArgumentHandler( MethodArgumentNotValidException ex ) throws JsonProcessingException{
		
		Map<String, String> errorMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error ->
		
				{
					errorMap.put(error.getField(), error.getDefaultMessage());
					
				});
		
		String json = new ObjectMapper().writeValueAsString(errorMap);
		
		logger.error("MethodArgumentNotValidException {}", json);
		
		return errorMap;
		
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ApplicaionException.class)
	public Map<String, String> applicationExceptionHandler(ApplicaionException ex){
		
		
       Map<String, String> errorMap = new HashMap<>();
		
		errorMap.put("Error Message", ex.getMessage());
		
		logger.error("ApplicaionException: {}", ex.getMessage());
		
		return errorMap;
		
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Map<String, String> applicationExceptionHandler(Exception ex){
		
		
       Map<String, String> errorMap = new HashMap<>();
		
		errorMap.put("Error Message", "Internal Server Error");
		
		logger.error("Exception occured at server end {}", ex.getMessage());
		
		return errorMap;
		
	}
	
	
	

}
