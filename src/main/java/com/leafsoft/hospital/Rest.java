package com.leafsoft.hospital;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

	@RequestMapping("/auth")
	public Object user() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
