package com.mjzf.bloggers.services;

import java.util.List;

import com.mjzf.bloggers.models.dtos.BlogDTO;
import com.mjzf.bloggers.models.entities.Blog;

public interface BlogService {
	List<Blog> findAll();
	Blog findOneById(Long id)  throws Exception;
	Blog createBlog(BlogDTO blogDTO) throws Exception;
	Blog UpdateBlog(Long id, BlogDTO blog)  throws Exception;
	void deleteBlog (Blog blog)  throws Exception;
}
