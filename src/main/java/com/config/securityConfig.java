package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpSession;

@Configuration
public class securityConfig {
	
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private AuthenticationFail authenticationFail;
	@Autowired
	private AuthenticationSuccess authenticationSuccess;
	// step1
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setUserDetailsService(userDetailService);
		dap.setPasswordEncoder(passwordEncoder());
		return dap;
	}	
	//step2
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSession session,HttpSecurity httpSecurity) throws Exception
	{
		// To customize security
		httpSecurity.authorizeHttpRequests(authorize->{
			authorize.requestMatchers("/").authenticated();
			authorize.requestMatchers("/video/**").authenticated();
			authorize.anyRequest().permitAll();

		});
		httpSecurity.csrf(AbstractHttpConfigurer::disable);
		// login from customize
		httpSecurity.formLogin(formLogin->{
			formLogin.loginPage("/login");
			formLogin.loginProcessingUrl("/do_login");
			formLogin.usernameParameter("email");
			formLogin.passwordParameter("password");
			formLogin.defaultSuccessUrl("/");
			formLogin.failureHandler(authenticationFail);
		});
		// for logout
		httpSecurity.logout(logoutform->
		{
			logoutform.logoutUrl("/logout");
			logoutform.logoutSuccessUrl("/login?logout=true");
		});
		//oauth configuration for google
			httpSecurity.oauth2Login(oauth->{
				oauth.loginPage("/login");
				oauth.successHandler(authenticationSuccess);
			});
		return httpSecurity.build();
	}
	//step3
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
