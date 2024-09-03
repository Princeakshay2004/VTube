package com.forms;

import org.springframework.web.multipart.MultipartFile;

public class VideoForm {
	
	private String Title;
	private MultipartFile video;
	private String Description;
	private String Category;
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public MultipartFile getVideo() {
		return video;
	}
	public void setVideo(MultipartFile video) {
		this.video = video;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	public VideoForm(String title, MultipartFile video, String description, String category) {
		super();
		Title = title;
		this.video = video;
		Description = description;
		Category = category;
	}
	public VideoForm() {
		super();
	}
	
	
	

}
