package com.bluegarden.entities;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.bluegarden.security.AppRole;
import com.google.appengine.api.datastore.Key;
import javax.jdo.PersistenceManager;

import org.hibernate.validator.constraints.NotEmpty;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class GaeUser implements Serializable {

	private static final long serialVersionUID = 8400119267246143168L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String userName;
	// @NotEmpty
	@Persistent
	private String password;
	@Persistent
	private Set<AppRole> authorities;
	@Persistent
	private String googleId;
	// @NotEmpty
	@Persistent
	private String blueGardenNickName;

	public GaeUser() {

	}

	public GaeUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public GaeUser(String userName, Set<AppRole> authorities, String googleId) {
		this.userName = userName;
		this.authorities = authorities;
		this.googleId = googleId;
	}

	public GaeUser(String userName, String password, Set<AppRole> authorities,
			String googleId, String blueGardenNickName) {
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
		this.googleId = googleId;
		this.blueGardenNickName = blueGardenNickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<AppRole> getAuthorities() {
		return authorities;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getBlueGardenNickName() {
		return blueGardenNickName;
	}

	public void setBlueGardenNickName(String blueGardenNickName) {
		this.blueGardenNickName = blueGardenNickName;
	}

}
