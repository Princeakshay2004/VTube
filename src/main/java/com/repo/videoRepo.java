package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Video;

@Repository
public interface videoRepo extends JpaRepository<Video, String>{
	
	Video findByVid(String id);
	List <Video> findByvTitleContainingOrVideoCategoryContaining(String name,String name1);
	
	
}
