package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.User;
import java.util.List;


@Repository
public interface userRepo extends JpaRepository<User, String> {

	User findByEmail(String email);
	
}
