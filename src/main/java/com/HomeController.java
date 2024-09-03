package com;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.helper.Message;
import com.entity.User;
import com.entity.Video;
import com.forms.UserForm;
import com.helper.FileUploadHelper;
import com.service.UserService;
import com.service.videoService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private videoService videoService;
	
	
	@GetMapping("/")
	public String home(HttpSession session)
	{
		List<Video> video=videoService.getAllVideo();
		session.setAttribute("Video", video);
		return "home";
	}
	

	@PostMapping("/")
	public String hom()
	{
		return "home";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session)
	{
		Message message=new Message("You are Logout Successfully","alert-danger");
		session.setAttribute("log", message);
		return "login";
	}
	
	
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@PostMapping("/saveUser")
	public String saveUser( @Valid @ModelAttribute UserForm userform,Model model,HttpSession session,BindingResult result) throws IOException
	{
		if(result.hasErrors())
		{
			Message message=new Message("Please provide valid information","alert-danger");
			session.setAttribute("message", message);
			return "redirect:/signup";
		}
		User user=new User();
		String userId=UUID.randomUUID().toString();
		user.setuId(userId);
		user.setName(userform.getName());
		user.setEmail(userform.getEmail());
		user.setGender(userform.getGender());
		user.setNumber(userform.getNumber());
		user.setProvider("SELF");
		user.setPassword(passwordEncoder.encode(userform.getPassword()));
		// To save file
		MultipartFile file=userform.getProfile();
		user.setProfile(file.getOriginalFilename().toString());
		FileUploadHelper fileUpload=new FileUploadHelper();
		fileUpload.SaveFile(file.getInputStream(),file.getOriginalFilename().toString());
		try 
		{
			userService.saveUser(user);
		}
		catch(Exception e)
		{
			Message message=new Message("Please provide valid information","alert-danger");
			session.setAttribute("message", message);
			return "redirect:/signup";	
		}
		return "redirect:/login";
	}
	
	@GetMapping("/error")
	public String error()
	{
		
		return "error";
	}
	
}
