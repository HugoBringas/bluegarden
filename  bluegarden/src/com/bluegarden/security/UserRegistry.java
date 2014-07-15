package com.bluegarden.security;

import com.bluegarden.entities.GaeUser;

public interface UserRegistry {
	GaeUser findUser(String userId);

	void registerUser(GaeUser newUser);

	void removeUser(String userId);
}