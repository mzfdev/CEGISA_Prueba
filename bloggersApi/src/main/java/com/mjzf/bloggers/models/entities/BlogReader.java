package com.mjzf.bloggers.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "blog_reader")
public class BlogReader {

	//Atributes
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "B_ID")
    private Blog blog;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "R_ID")
    private Reader reader;

	//Constructors
    
	public BlogReader(Blog blog, Reader reader) {
		super();
		this.blog = blog;
		this.reader = reader;
	}

	public BlogReader() {
		super();
	}
	
	//Getters and Setters

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
    
}
