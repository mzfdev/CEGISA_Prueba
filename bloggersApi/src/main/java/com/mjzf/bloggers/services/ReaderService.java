package com.mjzf.bloggers.services;

import java.util.List;

import com.mjzf.bloggers.models.entities.Reader;

public interface ReaderService {
	List<Reader> findAll();
	Reader findOneById(Long id);
}
