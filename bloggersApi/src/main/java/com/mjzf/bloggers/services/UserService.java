package com.mjzf.bloggers.services;

import java.util.List;

import com.mjzf.bloggers.models.dtos.UserInfo;
import com.mjzf.bloggers.models.entities.User;

public interface UserService {
	void register(UserInfo userInfo) throws Exception;
	User findOneById(Long id) throws Exception ;
	User findOneByIdentifier(String identifier) throws Exception;
	List<User> findAll() throws Exception;
	Boolean comparePassword(User user, String passToCompare) throws Exception;
}
