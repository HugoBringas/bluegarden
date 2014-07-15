package com.bluegarden.security;

import org.springframework.security.core.GrantedAuthority;

public enum AppRole implements GrantedAuthority {
	ADMIN(0), NEW_USER(1), USER(2);

	private int bit;

	AppRole(int bit) {
		this.bit = bit;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return toString();
	}

}
