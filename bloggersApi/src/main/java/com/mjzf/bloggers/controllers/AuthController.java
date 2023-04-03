package com.mjzf.bloggers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjzf.bloggers.models.dtos.LoginDTO;
import com.mjzf.bloggers.models.dtos.MessageDTO;
import com.mjzf.bloggers.models.dtos.UserInfo;
import com.mjzf.bloggers.models.entities.User;
import com.mjzf.bloggers.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<MessageDTO> registerUser(@Valid UserInfo userInfo, BindingResult result) {
		try {
			
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				
				return new ResponseEntity<>(
						new MessageDTO("Hay algun error" + errors),
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

	@PostMapping("/signin")
	private ResponseEntity<MessageDTO> login(LoginDTO loginInfo, BindingResult result) {
		try {
			
			if(result.hasErrors()) {
				return new ResponseEntity<>(
						new MessageDTO("Ha ocurrido un error"),
						HttpStatus.BAD_REQUEST
					);
			}
			
			User user = userService.findOneByIdentifier(loginInfo.getIdentifier());
			
			if(!userService.comparePassword(user, loginInfo.getPassword())) {
				return new ResponseEntity<>(
						new MessageDTO("Datos No coinciden"),
						HttpStatus.UNAUTHORIZED
					);
			}
		 	
			
				return new ResponseEntity<>(
						new MessageDTO("Usuario Correcto"),
						HttpStatus.OK
					);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
				);
		}
	}

}
