package com.config;

import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.entity.User;
import com.repo.userRepo;
import com.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationSuccess implements AuthenticationSuccessHandler {

	@Autowired
	private userRepo  userrepo;
	
	@Autowired
	private UserService userService;
	@Override
	
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {


		OAuth2AuthenticationToken authenticationToken=(OAuth2AuthenticationToken)authentication;
		String authorizeClientId =authenticationToken.getAuthorizedClientRegistrationId();
		DefaultOAuth2User user=(DefaultOAuth2User)authentication.getPrincipal();

		if(authorizeClientId.equals("google"))
		{

			// To fetch user data
			String email=user.getAttribute("email").toString();
			String name=user.getAttribute("name").toString();
			String picture=user.getAttribute("picture").toString();

			// to save data
			User user1=new User();
			user1.setName(name);
			user1.setEmail(email);
			user1.setProfile(picture);
			user1.setNumber("");
			user1.setGender("male");
			user1.setEmailVerified(true);
			user1.setProvider("Google");
			user1.setPassword(UUID.randomUUID().toString());
			user1.setuId(UUID.randomUUID().toString());
			user1.setEnabled(true);
			User user2=userrepo.findByEmail(email);
			if(user2==null)
			{
				userService.saveUser(user1);
			}
		}
		else if(authorizeClientId.equals("github"))
		{

			// To fetch user data
			String email=user.getAttribute("email")!=null?user.getAttribute("gmail").toString():user.getAttribute("login").toString().toLowerCase()+"@gmail.com";
			String name=user.getAttribute("login").toString();
			String picture=user.getAttribute("avatar_url").toString();

			// to save data
			User user1=new User();
			user1.setName(name);
			user1.setEmail(email);
			user1.setProfile(picture);
			user1.setNumber("");
			user1.setGender("male");
			user1.setProvider("Github");
			user1.setEmailVerified(true);
			user1.setPassword(UUID.randomUUID().toString());
			user1.setuId(UUID.randomUUID().toString());
			user1.setEnabled(true);
			User user2=userrepo.findByEmail(email);
			if(user2==null)
			{
				userService.saveUser(user1);
			}			
		}
			response.sendRedirect("/");
	}

}
