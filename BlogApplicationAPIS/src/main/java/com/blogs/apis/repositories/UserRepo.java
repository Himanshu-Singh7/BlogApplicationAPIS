package com.blogs.apis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogs.apis.entites.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	
	Optional<User> findByEmail(String email);
}
