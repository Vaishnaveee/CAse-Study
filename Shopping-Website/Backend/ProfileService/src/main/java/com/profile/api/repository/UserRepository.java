
package com.profile.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.profile.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);


	//@Query("select u from User u where u.mobilenumber=?1")
	//User findByMobilenumber(String mobilenumber);

}
