package com.mjzf.bloggers.services;

import java.util.List;

import com.mjzf.bloggers.models.entities.Blog;

public interface BlogService {
	List<Blog> findAll();
	Blog findOneById(Long id);
}
