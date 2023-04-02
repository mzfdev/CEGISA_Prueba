package com.mjzf.bloggers.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjzf.bloggers.models.entities.Reader;
import com.mjzf.bloggers.repositories.ReaderRepository;
import com.mjzf.bloggers.services.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService{
	
	@Autowired
	public ReaderRepository readerRepository;

	@Override
	public List<Reader> findAll() {
		return readerRepository.findAll();
	}

	@Override
	public Reader findOneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
