package com.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ProjectConfig {
	
	
	@Bean
	public Cloudinary getCloudinary()
	{
		Map map=new HashMap();
		map.put("cloud_name","dqg87xvqe");
		map.put("api_key","885775179382469");
		map.put("api_secret","5v48EbzSkTn1xvVhruhH5-kabEM");
		map.put("secure",true);
		
		return new Cloudinary(map);
	}

}
