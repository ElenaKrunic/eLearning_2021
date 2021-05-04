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

import ftn.tseo.eEducation.service.DatabaseUserDetailPasswordService;
import ftn.tseo.eEducation.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService udService;
	
	@Autowired
	private UserDetailsServiceImpl databaseUserDetailsService; 
	
	@Autowired
	private DatabaseUserDetailPasswordService databaseUserDetailPasswordService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf()
			.disable()
			.sessionManagement()	
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()	
			.antMatchers("/index.html", "/api/login", "/api/register")
			.permitAll()  
			//.antMatchers(HttpMethod.POST, "/api/**") ==> radi testiranja svojih POST metoda sam onemogucila da test mora uraditi ADMIN  ELENA 
			//.hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic(); //radi 
		
			//httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class); //ne radi
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	 @Bean
	  public AuthenticationProvider daoAuthenticationProvider() {
	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	    provider.setPasswordEncoder(passwordEncoder());
	    provider.setUserDetailsPasswordService(
	                this.databaseUserDetailPasswordService);
	    provider.setUserDetailsService(this.databaseUserDetailsService);
	    return provider;
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(10);
	  }
	
	@Autowired
	public void configureAuthentication(
			AuthenticationManagerBuilder authenticationManagerBuilder)
			throws Exception {
		
		authenticationManagerBuilder
				.userDetailsService(this.udService).passwordEncoder(
						passwordEncoder());
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}
	/*
<<<<<<< HEAD
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()
				.antMatchers("/index.html", "/api/login", "/api/register","/styles.css","/runtime.js","/polyfills.js","/vendor.js","/main.js","/favicon.ico").permitAll() 
				.antMatchers(HttpMethod.POST, "/api/**")
				.hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated();
				 
			httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}
	

	
	

=======
>>>>>>> 7de1852878a84583f0ad5fc35a72a04557f4bc1f
*/
}
