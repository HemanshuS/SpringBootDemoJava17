/**
 * 
 */
package com.lyngon.demo.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author Himanshu
 *
 */
//@EnableWebSecurity
//public class SecurityWithCsrfCookieConfig extends WebSecurityConfiguration{
//	protected void configure(HttpSecurity http) throws Exception{
//        http.cors().and().csrf().disable();
//    }
//    
//   
//   
//
//}

@Configuration
//@EnableWebSecurity
public class SecurityWithCsrfCookieConfig //extends GlobalAuthenticationConfigurerAdapter
// extends SecurityConfigurerAdapter 
// WebSecurityConfigurerAdapter
{
	
	
//	  @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests()
//	                .anyRequest().authenticated()
//	                .and()
//	            .httpBasic()
//	                .and()
//	            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//	    }
//	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http
//	      .csrf().disable();
//	    return http.build();
//	}

	
//	 @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        http
//	          .csrf()
//	          .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//	        return http.build();
//	    }
	
//	@EnableWebSecurity
//	public class WebSecurityConfig extends
//	WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//				.csrf().disable();
//		}
//	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().antMatchers("/register").permitAll().antMatchers("/welcome")
//				.hasAnyRole("USER", "ADMIN").antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
//				.antMatchers("/addNewEmployee").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
//				.loginPage("/login").permitAll().and().logout().permitAll();
//
//
//}
}
