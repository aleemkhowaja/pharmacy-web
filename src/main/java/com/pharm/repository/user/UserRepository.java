package com.pharm.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pharm.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	/**
	 * find By Username for login
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}
