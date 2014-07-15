package com.bluegarden.controllers;

import java.util.EnumSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluegarden.entities.GaeUser;
import com.bluegarden.security.AppRole;
import com.bluegarden.security.GaeDatastoreUserRegistry;

@Controller
@RequestMapping(value="login")
public class LoginController {
	private final GaeDatastoreUserRegistry userRegistry;

	public LoginController(GaeDatastoreUserRegistry userRegistry) {
		this.userRegistry = userRegistry;
	}
	
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String register(@Valid GaeUser user, BindingResult result){
		if(result.hasErrors()){
			return  null;
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GaeUser gaeUser = (GaeUser) authentication.getPrincipal();
		Set<AppRole> roles = EnumSet.of(AppRole.ADMIN);
		
		return "";
	}

}
