package com.service;

import java.util.List;

import com.entity.Comments;
import com.entity.Video;

public interface commentService {
	
	Comments savecomments(Comments comments);
	List<Comments>getAllComments();
	List<Comments> getByVid(Video video);
	
}
