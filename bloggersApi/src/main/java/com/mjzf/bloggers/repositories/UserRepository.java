package com.mjzf.bloggers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjzf.bloggers.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findOneByUsernameOrEmail(String username, String email);
	
}
