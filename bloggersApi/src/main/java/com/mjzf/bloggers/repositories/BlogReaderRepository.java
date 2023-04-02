package com.mjzf.bloggers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjzf.bloggers.models.entities.Blog;
import com.mjzf.bloggers.models.entities.BlogReader;
import com.mjzf.bloggers.models.entities.Reader;

public interface BlogReaderRepository extends JpaRepository<BlogReader, Long>{
	
	List<BlogReader> findAll(Reader reader);
	List<BlogReader> findByReader(Reader reader);
	List<BlogReader> findByBlog(Blog blog);
}
