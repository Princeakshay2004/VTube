package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {

	@Id
	private String id;
	@ManyToOne
	@JsonIgnore
	private Video video;
	private String Comments;
	
	public Comments(String id, Video video, String comments) {
		super();
		this.id = id;
		this.video = video;
		Comments = comments;
	}
	
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", video=" + video + ", Comments=" + Comments + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	
	
	
	
	
	
}
