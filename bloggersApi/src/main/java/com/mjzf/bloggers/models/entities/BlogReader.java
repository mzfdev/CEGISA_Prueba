package com.mjzf.bloggers.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "blog_reader")
public class BlogReader {
	@Id
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "B_ID")
    private Blog blog;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "R_ID")
    private Reader reader;
	
}
