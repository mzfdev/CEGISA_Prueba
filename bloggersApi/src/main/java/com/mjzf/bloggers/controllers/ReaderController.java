package com.mjzf.bloggers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
