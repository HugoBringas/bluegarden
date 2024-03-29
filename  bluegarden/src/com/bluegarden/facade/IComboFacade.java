package com.bluegarden.facade;

import java.util.List;

import com.bluegarden.entities.Combo;

public interface IComboFacade {
	public void save(Combo combo);
	public List<Combo> getAllCombos();
	public void deleteCombo(String key);
	public Combo getCombo(String key);
	
}
