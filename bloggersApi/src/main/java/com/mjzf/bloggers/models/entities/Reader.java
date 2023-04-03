package com.mjzf.bloggers.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "reader")
public class Reader {
	
	//Atributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "reader", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<BlogReader> blogReaders;

	//Constructors
	
	public Reader(String name) {
		super();
		this.name = name;
	}

	public Reader() {
		super();
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BlogReader> getBlogReaders() {
		return blogReaders;
	}

	public void setBlogReaders(List<BlogReader> blogReaders) {
		this.blogReaders = blogReaders;
	}

	
}
