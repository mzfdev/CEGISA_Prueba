package com.mjzf.bloggers.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjzf.bloggers.models.dtos.UserInfo;
import com.mjzf.bloggers.models.entities.User;
import com.mjzf.bloggers.repositories.UserRepository;
import com.mjzf.bloggers.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void register(UserInfo userInfo) throws Exception {
		User user = new User();
		
		String encryptedPassword = passEncoder.encode(userInfo.getPassword());
		
		user.setUsername(userInfo.getUsername());
		user.setEmail(userInfo.getEmail());
		user.setPassword(encryptedPassword);
		user.setName(userInfo.getName());
		
		userRepository.save(user);
	}

	@Override
	public User findOneById(Long id) throws Exception {
		User foundUser = userRepository
				.findById(id)
				.orElse(null);
		
		return foundUser;
	}

	@Override
	public User findOneByIdentifier(String identifier) throws Exception {
		
		User foundUser = userRepository
				.findOneByUsernameOrEmail(identifier, identifier);
		
		return foundUser;
	}

	@Override
	public List<User> findAll() throws Exception{
		return userRepository.findAll();
	}

	@Override
	public Boolean comparePassword(User user, String passToCompare) throws Exception {
		return passEncoder.matches(passToCompare, user.getPassword());
	}

}
