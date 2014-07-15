package com.bluegarden.security;

import java.util.EnumSet;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.bluegarden.entities.GaeUser;
import com.google.appengine.api.users.User;

public class GoogleAccountsAuthenticationProvider implements
		AuthenticationProvider {
	private final UserRegistry userRegistry;

	public GoogleAccountsAuthenticationProvider(UserRegistry userRegistry) {
		this.userRegistry = userRegistry;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		User googleUser = (User) authentication.getPrincipal();

		GaeUser gaeUser = userRegistry.findUser(googleUser.getUserId());

		if (gaeUser == null) {
			//is new user
			gaeUser =  new GaeUser(googleUser.getNickname(), EnumSet.of(AppRole.NEW_USER), googleUser.getUserId());
		}
		
		return new GaeUserAuthentication(gaeUser, authentication.getDetails());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
