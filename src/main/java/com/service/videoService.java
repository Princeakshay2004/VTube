package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.entity.User;
import com.entity.Video;

public interface videoService {

	Video saveVideo(Video video);
	String uploadVideo(MultipartFile multipartFile);
//	String getURLfromPublicId(String publicId);
	Video getVideoById(String id);
	void deleteVideo(String id);
	List<Video> getAllVideo();
	Video getVideoByUser(User user);
	List <Video> searchBytitle(String name,String name1);
}
