package com.mjzf.bloggers.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "reader")
public class Reader {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "reader", fetch = FetchType.LAZY)
    private List<BlogReader> blogReaders;

}
