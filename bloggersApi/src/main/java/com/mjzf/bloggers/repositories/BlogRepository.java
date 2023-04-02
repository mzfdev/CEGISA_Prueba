package com.mjzf.bloggers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjzf.bloggers.models.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
