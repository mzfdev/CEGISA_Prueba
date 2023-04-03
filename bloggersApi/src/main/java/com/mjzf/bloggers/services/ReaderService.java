package com.mjzf.bloggers.services;

import java.util.List;

import com.mjzf.bloggers.models.dtos.ReaderDTO;
import com.mjzf.bloggers.models.entities.Reader;

public interface ReaderService {
	List<Reader> findAll();
	Reader findOneById(Long id)  throws Exception;
	Reader createReader(ReaderDTO readerDTO); 
	Reader UpdateBlog(Long id, ReaderDTO reader)  throws Exception;
	void deleteBlog (Reader reader)  throws Exception;
}
