package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Comments;
import com.entity.Video;
import com.repo.commentRepo;
import com.service.commentService;

@Service
public class commentServiceImpl implements commentService{

	@Autowired
	private commentRepo commentRepo;
	
	@Override
	public Comments savecomments(Comments comments) {
		return commentRepo.save(comments);
	}

	@Override
	public List<Comments> getAllComments() {
		return commentRepo.findAll();
	}

	@Override
	public List<Comments> getByVid(Video video) {
		return  commentRepo.findByVideo(video);
	}

	

	

}
