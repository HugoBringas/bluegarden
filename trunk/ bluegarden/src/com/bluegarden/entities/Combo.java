package com.bluegarden.entities;



public class Combo {
	private String character;
	private String combo;
	private int damage;
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

}
