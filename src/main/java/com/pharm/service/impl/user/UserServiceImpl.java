package com.pharm.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pharm.model.User;
import com.pharm.repository.user.UserRepository;

import javax.persistence.Cacheable;

@Service
public class UserServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/**
		 * retrieve username from user table
		 * This method will execute while login
		 */
		 User user =  userRepository.findByUsername(username);
		 
		 if (user == null) throw new UsernameNotFoundException(username);
		 
		 /**
		  * Add Roles for Grant  Permissions
		  */
		 List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		 GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_admin");
		 grantList.add(grantedAuthority);
		 
		 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);
	}
	
}
