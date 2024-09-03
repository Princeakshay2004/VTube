package com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails {

	@Id 
	private String uId;
	private String Name;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String number;
	private String profile;
	private String gender;
	private String password;
	private String provider;
	private boolean enabled;
	private boolean emailVerified;
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Video>video= new ArrayList<Video>();

	public User(String uId, String name, String email, String number, String profile, String gender, String password,
			boolean enabled, boolean emailVerified, List<Video> video,String provider) {
		super();
		this.uId = uId;
		Name = name;
		this.email = email;
		this.number = number;
		this.profile = profile;
		this.gender = gender;
		this.password = password;
		this.provider = provider;
		this.enabled = enabled;
		this.emailVerified = emailVerified;
		this.video = video;
	}

	public User() {
		super();
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	
	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	public boolean isEnabled() {
		return true;
	}
	
	
	public String profileurl(User user)
	{
		if(user.getProfile().equals(""))
		{
			return "/img/default.png";
		}
		else {
			if(user.getProvider().equals("SELF"))
			{
				return "/img/"+user.getProfile();
			}
			else {
				return user.getProfile();
			}
		}
	}
	
	
	
  
	
	
	
	
	
}
