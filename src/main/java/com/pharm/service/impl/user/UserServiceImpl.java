package com.pharm.service.impl.user;

import com.pharm.model.User;
import com.pharm.repository.user.UserRepository;
import com.pharm.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserDetailsService, UserService {

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

	@Override
	public List<User> findAll() {
		return userRepository.findAllByRole("manager");
	}

	@Override
	public User findById(Long id) {
		return null;
	}

	@Override
	public User create(User user) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public User delete(User user) {
		return null;
	}

	@Override
	public User findByUsername(final String username) {
		return userRepository.findByUsername(username);
	}
}
