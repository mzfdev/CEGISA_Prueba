package com.mjzf.bloggers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjzf.bloggers.models.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long>{

}
