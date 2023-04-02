package com.mjzf.bloggers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjzf.bloggers.models.dtos.MessageDTO;
import com.mjzf.bloggers.models.dtos.UserInfo;
import com.mjzf.bloggers.models.entities.User;
import com.mjzf.bloggers.services.UserService;

import jakarta.validation.Valid;

@RestController(value = "/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<MessageDTO> registerUser(@Valid UserInfo userInfo, BindingResult result) {
		try {
			
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				
				return new ResponseEntity<>(
						new MessageDTO("Hay algun error"),
						HttpStatus.BAD_REQUEST
						);
			}
			
			User foundUser = userService
					.findOneByUsernameAndEmail(userInfo.getUsername(), userInfo.getEmail());
			
			if(foundUser != null) {
				return new ResponseEntity<>(
						new MessageDTO("El usuario ya existe"),
						HttpStatus.BAD_REQUEST
						);
			}
			
			userService.register(userInfo);
			
			return new ResponseEntity<>(
					new MessageDTO("Usuario Registrado"),
					HttpStatus.CREATED
					);
		}catch(Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
}
