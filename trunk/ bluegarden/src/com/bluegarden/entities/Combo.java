package com.bluegarden.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Combo {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@NotEmpty
	@Persistent
	private String character;
	@NotEmpty
	@Persistent
	private String combo;
	@Digits(integer = 5, fraction = 0, message = "The value must be numeric and less than five digits")
	@Persistent
	private int damage;
	@Persistent
	private String additionalInfo;

	public Combo() {

	}

	public Combo(String character, String combo, int damage,
			String additionalInfo) {

		this.character = character;
		this.combo = combo;
		this.damage = damage;
		this.additionalInfo = additionalInfo;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public String keyAsTring(){
		if(key != null){
			return KeyFactory.keyToString(key);
		}else{
			return "";
		}
	}

}
