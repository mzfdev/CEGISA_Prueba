package com.mjzf.bloggers.models.dtos;

public class BlogDTO {
	private String title;
	private String description;
	
	public BlogDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public BlogDTO() {
		super();
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
	
	
}
