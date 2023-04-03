package com.mjzf.bloggers.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjzf.bloggers.models.dtos.BlogDTO;
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

	@Override
	public Blog createBlog(BlogDTO blogDTO) throws Exception {
		Blog new_blog = new Blog();
		
		new_blog.setTitle(blogDTO.getTitle());
		new_blog.setDescription(blogDTO.getDescription());
		
		return blogRepository.save(new_blog);
	}

	@Override
	public Blog UpdateBlog(Long id, BlogDTO blogdetails) throws Exception {
		Blog blog1 = blogRepository.getById(id);
		
		blog1.setTitle(blogdetails.getTitle());
		blog1.setDescription(blogdetails.getDescription());
		
		return blogRepository.save(blog1);
	}

	@Override
	public void deleteBlog(Blog blog) throws Exception {
		
		blogRepository.delete(blog);
	}
	
	
}

