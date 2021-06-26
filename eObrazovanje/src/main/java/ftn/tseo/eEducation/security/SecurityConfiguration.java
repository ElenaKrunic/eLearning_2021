package ftn.tseo.eEducation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import ftn.tseo.eEducation.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService udService;
	
//	@Autowired
//	private UserDetailsServiceImpl databaseUserDetailsService; 
//	
//	@Autowired
//	private DatabaseUserDetailPasswordService databaseUserDetailPasswordService;
	
	
	@Autowired
	public void configureAuthentication(
			AuthenticationManagerBuilder authenticationManagerBuilder)
			throws Exception {
		
		authenticationManagerBuilder
				.userDetailsService(this.udService).passwordEncoder(
						passwordEncoder());
	}
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	 
	 @Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
	 

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//			.csrf()
//			.disable()
//			.sessionManagement()	
//			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//			.authorizeRequests()	
//			.antMatchers("/index.html", "/api/login", "/api/register")
//			.permitAll()  
//			//.antMatchers(HttpMethod.POST, "/api/**") ==> radi testiranja svojih POST metoda sam onemogucila da test mora uraditi ADMIN  ELENA 
//			//.hasAuthority("ROLE_ADMIN")
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic(); //radi 
//		
//			//httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class); //ne radi
//	}
	
	
//	 @Bean
//	  public AuthenticationProvider daoAuthenticationProvider() {
//	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	    provider.setPasswordEncoder(passwordEncoder());
//	    provider.setUserDetailsPasswordService(
//	                this.databaseUserDetailPasswordService);
//	    provider.setUserDetailsService(this.databaseUserDetailsService);
//	    return provider;
//	  }
	  
	 
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()
				.antMatchers( "/","/api/examPeriods/**","/api/financialCards/**", "/api/payments/**", "/api/login","/styles.css","/runtime.js","/polyfills.js","/vendor.js","/main.js","/favicon.ico","/styles.css.map","/runtime.js.map","/polyfills.js.map","/vendor.js.map","/main.js.map").permitAll() 
				.antMatchers(HttpMethod.POST, "/api/**")
				.hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated();
				 
			httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}
	

	
	

}
