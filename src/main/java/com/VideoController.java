package com;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Comments;
import com.entity.User;
import com.entity.Video;
import com.forms.UserForm;
import com.forms.VideoForm;
import com.forms.commentForm;
import com.helper.Message;
import com.helper.getUser;
import com.repo.videoRepo;
import com.service.UserService;
import com.service.commentService;
import com.service.videoService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private videoService videoService;
	@Autowired
	private UserService userService;
	@Autowired
	private commentService commentService;
	
	@PostMapping("/upload")
	public String uploadVideo(@ModelAttribute VideoForm videoForm,HttpSession session,Authentication authentication) throws IOException
	{
		
		String username=getUser.getemailOfLoggerUser(authentication);
		User user=userService.getUserByEmail(username);
				
		Video video=new Video();
		String Id=UUID.randomUUID().toString();
		video.setVid(Id);
		video.setvTitle(videoForm.getTitle());
		video.setUser(user);
		video.setVideoCategory(videoForm.getCategory());
		video.setvDescription(videoForm.getDescription());
		MultipartFile file=videoForm.getVideo();
		video.setVideo(file.getOriginalFilename().toString());
		videoService.uploadVideo(file);
		

		try {
			videoService.saveVideo(video);
			Message msg=new Message("Your video uploaded Successfully !","alert-success");
			session.setAttribute("videoUpload", msg);
		}
		catch(Exception e)
		{
			Message msg=new Message("Somthing went wrong!","alert-danger");
			session.setAttribute("videoUpload", msg);
		}	
		return "redirect:/";
	}
	
	@GetMapping("/view/{Id}")
	public String view(@PathVariable String Id ,HttpSession session)
	{
		
		
		Video video=videoService.getVideoById(Id);
		session.setAttribute("Videoview",video);
		
		List<Video> video1=videoService.getAllVideo();
		session.setAttribute("Video", video1);
		
		List <Comments> comments1=commentService.getByVid(video);
		session.setAttribute("Comments", comments1);
		
		
		return "viewVideo";
	}
	
	@GetMapping("/result")
	public String Result(@RequestParam("search") String search ,HttpSession session)
	{
		List<Video> video=videoService.searchBytitle(search, search);
		session.setAttribute("SearchResult", video);
		return "Result";
	}
	
	@PostMapping("/comment/{Id}")
	public String saveComment(@ModelAttribute commentForm commentForm,@PathVariable String Id,HttpSession session,Model model) {
		Video video=videoService.getVideoById(Id);		
		Comments comment1=new Comments();
		String id=UUID.randomUUID().toString();
		comment1.setId(id);
		comment1.setComments(commentForm.getComment());
		comment1.setVideo(video);
		commentService.savecomments(comment1);
		List<Comments> comments=commentService.getAllComments();
		session.setAttribute("Comments", comments);
		return "redirect:/video/view/"+Id;
	}
	
	
	
	
}
