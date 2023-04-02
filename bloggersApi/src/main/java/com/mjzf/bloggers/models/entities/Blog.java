package com.mjzf.bloggers.models.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "blog")
public class Blog {
	
	//Atributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<BlogReader> blogReaders;

	//Constructors
	
	public Blog(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Blog() {
		super();
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BlogReader> getBlogReaders() {
		return blogReaders;
	}

	public void setBlogReaders(List<BlogReader> blogReaders) {
		this.blogReaders = blogReaders;
	}
}
