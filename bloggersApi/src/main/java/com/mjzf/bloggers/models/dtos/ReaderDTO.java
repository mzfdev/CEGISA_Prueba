package com.mjzf.bloggers.models.dtos;

public class ReaderDTO {
	
	private String name;
	
	public ReaderDTO(String name) {
		super();
		this.name = name;
	}

	public ReaderDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
