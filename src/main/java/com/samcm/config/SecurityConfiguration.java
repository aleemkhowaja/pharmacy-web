package com.samcm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter  {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		System.out.println("configureGlobalSecurity Method Call--------------");
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		  http.csrf().disable();
		  
		   	http.authorizeRequests()
		    .antMatchers("/api/**").access("hasRole('admin') or hasRole('employee')")
		    .antMatchers("/views/**").access("hasRole('admin') or hasRole('employee')")
			.antMatchers("/login.htm").permitAll()
			.and()
		    .formLogin().loginPage("/login.htm").loginProcessingUrl("/login.htm").failureUrl("/login.htm?error")
		    .defaultSuccessUrl("/dashboard.htm")
		    .usernameParameter("username").passwordParameter("password")
		    .and().logout().logoutSuccessUrl("/login.htm?logout")
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .and().csrf().disable();
	  }

		  
}
