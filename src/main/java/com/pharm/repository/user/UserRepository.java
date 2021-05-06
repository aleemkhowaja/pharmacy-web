package com.pharm.repository.user;

import com.pharm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * find By Username for login
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	List<User> findAllByRole(final String role);
}
