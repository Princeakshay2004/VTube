package com.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.entity.User;
import com.entity.Video;
import com.repo.videoRepo;
import com.service.videoService;

@Service
public class videoServiceImpl implements videoService{
	
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private videoRepo videoRepo;
	
	@Override
	public Video saveVideo(Video video) {
		return videoRepo.save(video);
	}

	@Override
	public Video getVideoById(String id) {
		return videoRepo.findById(id).orElse(null);
		
	}

	@Override
	public void deleteVideo(String id) {
		Video video=videoRepo.findByVid(id);
			videoRepo.delete(video);
	}

	@Override
	public List<Video> getAllVideo() {
		return videoRepo.findAll();
	}

	@Override
	public Video getVideoByUser(User user) {
		
		return null;
	}

	@Override
	public List <Video> searchBytitle(String name, String name1) {
		return  videoRepo.findByvTitleContainingOrVideoCategoryContaining(name,name1);
	}


	// To upload video at cloudinary
	@Override
	@Async
	public String uploadVideo(MultipartFile videoFile) {		
		try {	
			Map uploadResult = cloudinary.uploader().upload(videoFile.getBytes(),
	                ObjectUtils.asMap("resource_type","video","public_id",videoFile.getOriginalFilename()));
	       return uploadResult.get("url").toString();
	       
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}

//	@Override
//	public String getURLfromPublicId(String publicId) {
//		// TODO Auto-generated method stub
//		return cloudinary.url().transformation(new Transformation<>()).generate(publicId);
//	}

}
