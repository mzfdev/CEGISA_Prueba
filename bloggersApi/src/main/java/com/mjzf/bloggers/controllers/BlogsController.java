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
import com.mjzf.bloggers.models.entities.Blog;
import com.mjzf.bloggers.services.BlogService;

@RestController
@RequestMapping("/Blogs")
public class BlogsController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/Blogs_view")
	public ResponseEntity<List<Blog>> findAllBlogs(){
		try {
			List<Blog> blogs = blogService.findAll();
			return new ResponseEntity<>(
					blogs,
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
	public ResponseEntity<MessageDTO> createBlog(BlogDTO blogDTO, BindingResult result){
		try {
			
			blogService.createBlog(blogDTO);
			
			return new ResponseEntity<>(
						new MessageDTO("Registrado"),
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
