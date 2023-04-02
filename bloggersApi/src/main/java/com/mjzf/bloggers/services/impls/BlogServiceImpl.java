package com.mjzf.bloggers.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjzf.bloggers.models.entities.Blog;
import com.mjzf.bloggers.repositories.BlogRepository;
import com.mjzf.bloggers.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public List<Blog> findAll() {
		return blogRepository.findAll();
	}

	@Override
	public Blog findOneById(Long id) {
		return blogRepository.findById(id).orElse(null);
	}

}
