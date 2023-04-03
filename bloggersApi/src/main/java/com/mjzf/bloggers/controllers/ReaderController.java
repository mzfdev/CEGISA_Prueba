package com.mjzf.bloggers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjzf.bloggers.models.dtos.BlogDTO;
import com.mjzf.bloggers.models.dtos.MessageDTO;
import com.mjzf.bloggers.models.dtos.ReaderDTO;
import com.mjzf.bloggers.models.entities.Reader;
import com.mjzf.bloggers.services.ReaderService;

@RestController
@RequestMapping("/Readers")
public class ReaderController {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/Readers_view")
	public ResponseEntity<List<Reader>> findAllReaders(){
		try {
			List<Reader> readers = readerService.findAll();
			return new ResponseEntity<>(
					readers,
					HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<MessageDTO> createReader(ReaderDTO readerDTO, BindingResult result){
		try {
			
			readerService.createReader(readerDTO);
			
			return new ResponseEntity<>(
						new MessageDTO("Creado"),
						HttpStatus.CREATED
					);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
}
