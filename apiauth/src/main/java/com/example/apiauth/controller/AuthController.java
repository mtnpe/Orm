package com.example.apiauth.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiauth.AppException;
import com.example.apiauth.entity.User;
import com.example.apiauth.form.LoginForm;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@DependsOn("securityFilterChain")
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private RememberMeServices rememberMeServices;
	
	 @PostMapping("/login")
	  public CurrentUser login(@Valid @RequestBody LoginForm form, BindingResult bindingResult,
	                           HttpServletRequest request, HttpServletResponse response) {

	    if (request.getUserPrincipal() != null) {
	      throw new AppException("Please logout first.");
	    }

	    if (bindingResult.hasErrors()) {
	      throw new AppException("Invalid username or password");
	    }

	    try {
	      request.login(form.getUsername(), form.getPassword());
	    } catch (ServletException e) {
	    	e.printStackTrace();
	      throw new AppException("Invalid username or password");
	    }

	    var auth = (Authentication) request.getUserPrincipal();
	    var user = (User) auth.getPrincipal();
	    log.info("User {} logged in.", user.getUsername());

	    rememberMeServices.loginSuccess(request, response, auth);
	    return new CurrentUser(user.getId(), user.getNickname());
	  }
	
	@PostMapping("/logout")
	public LogoutResponse logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return new LogoutResponse();
	}

	@GetMapping("/current-user")
	public CurrentUser getCurrentUser(@AuthenticationPrincipal User user) {
		return new CurrentUser(user.getId(), user.getNickname());
	}

	@GetMapping("/csrf")
	public CsrfResponse csrf(HttpServletRequest request) {
		var csrf = (CsrfToken) request.getAttribute("_csrf");
		return new CsrfResponse(csrf.getToken());
	}

	public record CurrentUser(Integer id, String nickname) {
	}

	public record LogoutResponse() {
	}

	public record CsrfResponse(String token) {
	}
}