package com.bluegarden.controllers;

import java.util.EnumSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluegarden.entities.GaeUser;
import com.bluegarden.security.AppRole;
import com.bluegarden.security.GaeDatastoreUserRegistry;
import com.bluegarden.security.GaeUserAuthentication;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping(value = "login")
public class LoginController {
	private final GaeDatastoreUserRegistry userRegistry;


	public LoginController(GaeDatastoreUserRegistry userRegistry) {
		this.userRegistry = userRegistry;
	}

	@RequestMapping(method= RequestMethod.GET)
	public String getLogIn(ModelMap map) {
		map.addAttribute("user",new GaeUser());
		return "index";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Valid GaeUser user, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		GaeUser currentUser = (GaeUser) authentication.getPrincipal();
		Set<AppRole> roles = EnumSet.of(AppRole.USER);

		if (UserServiceFactory.getUserService().isUserAdmin()) {
			roles.add(AppRole.ADMIN);
		}
		
		GaeUser gaeUser = new GaeUser(currentUser.getUserName(),user.getPassword(),roles,currentUser.getGoogleId(),user.getBlueGardenNickName());
		userRegistry.registerUser(gaeUser);
		
		// Update the context with the full authentication
		SecurityContextHolder.getContext().setAuthentication(new GaeUserAuthentication(gaeUser, authentication.getDetails()));
		return "redirect:http://www.google.com";
	}

}
