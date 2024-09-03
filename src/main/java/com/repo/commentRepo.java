package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.Comments;
import com.entity.Video;

import java.util.List;



@Repository
public interface commentRepo extends JpaRepository<Comments, String>{
	
	 List<Comments> findByVideo(Video video);
}
