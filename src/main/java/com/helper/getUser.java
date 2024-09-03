package com.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.entity.User;
import com.service.UserService;

@ControllerAdvice
public class getUser {

	@Autowired
	private UserService userService;
	public static String getemailOfLoggerUser(Authentication authentication) 
	{
		if (authentication instanceof OAuth2AuthenticationToken) 
		{
			OAuth2User user = (OAuth2User) authentication.getPrincipal();
			OAuth2AuthenticationToken oauth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
			var cid = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
			if (cid.equals("google"))
			{
				String email = user.getAttribute("email").toString();
				return email;
			} 
			else if (cid.equals("github"))
			{
				String email = user.getAttribute("email") != null ? user.getAttribute("email").toString()
						: user.getAttribute("login").toString().toLowerCase() + "@gmail.com";
				return email;
			}
		}
		else 
		{
			return authentication.getName();
		}
		return "";
	}
	
    @ModelAttribute
		public void getLoggedUserInfo(Authentication authentication,Model model)
		{
			if(authentication==null)
			{
				return;
			}
			else
			{
			String username=this.getemailOfLoggerUser(authentication);
			User user=userService.getUserByEmail(username);
			if(user==null)
			{
				model.addAttribute("CurrentUser",null);
			}
			else
			{

				model.addAttribute("CurrentUser",user);
			}
			}
		}
	
	
}
