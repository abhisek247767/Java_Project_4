package com.first.demo.user;

//import com.first.demo.user.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	  
	  User findByUsername(String username);
	  

}
