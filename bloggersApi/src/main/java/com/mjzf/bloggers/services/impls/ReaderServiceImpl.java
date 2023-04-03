package com.mjzf.bloggers.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjzf.bloggers.models.dtos.ReaderDTO;
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

	@Override
	public Reader createReader(ReaderDTO readerDTO) {
		Reader new_reader = new Reader();
		
		new_reader.setName(readerDTO.getName());
		
		return readerRepository.save(new_reader);
	}

	@Override
	public Reader UpdateBlog(Long id, ReaderDTO reader) throws Exception {
		Reader reader1 = readerRepository.getById(id);
		
		reader1.setName(reader.getName());
		
		return readerRepository.save(reader1);
	}

	@Override
	public void deleteBlog(Reader reader) throws Exception {
		readerRepository.delete(reader);
	}

}
