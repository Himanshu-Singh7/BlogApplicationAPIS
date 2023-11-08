package com.blogs.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogs.apis.entites.User;


public interface UserRepo extends JpaRepository<User, Integer> {

}
