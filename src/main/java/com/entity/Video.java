package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Video {

	@Id
	private String vid;
	@Column(nullable = false)
	private String vTitle;
	@Column(length = 2000)
	private String vDescription;
	private String videoCategory;
	private String video;
	@ManyToOne
	@JsonIgnore
	private User user;
	@OneToMany(mappedBy = "video",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Comments>comments= new ArrayList<Comments>();
	
	public Video(String vid, String vTitle, String vDescription, String videoCategory, String video, User user) {
		super();
		this.vid = vid;
		this.vTitle = vTitle;
		this.vDescription = vDescription;
		this.videoCategory = videoCategory;
		this.video = video;
		this.user = user;
	}
	
	public Video() {
		super();
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getvTitle() {
		return vTitle;
	}
	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}
	public String getvDescription() {
		return vDescription;
	}
	public void setvDescription(String vDescription) {
		this.vDescription = vDescription;
	}
	public String getVideoCategory() {
		return videoCategory;
	}
	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
// To cut String for 10 words
	public String get10Words(String Desc)
	{
		String[] obj=Desc.split(" ");
		if(obj.length>=20)
		{
			String res="";
			for(int i=0;i<=20;i++)
			{
				res=res+obj[i]+" ";
				i++;
			}
			return res+" ...";
		}
		else
		{
			return Desc+" ...";
		}		
	}

	public String get20Words(String Desc)
	{
		String[] obj=Desc.split(" ");
		if(obj.length>=15)
		{
			String res="";
			for(int i=0;i<=15;i++)
			{
				res=res+obj[i]+" ";
				i++;
			}
			return res+" ...";
		}
		else
		{
			return Desc+" ...";
		}		
	}
	

}
