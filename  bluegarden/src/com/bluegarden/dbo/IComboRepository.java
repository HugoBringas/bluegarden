package com.bluegarden.dbo;

import java.util.List;

import com.bluegarden.entities.Combo;

public interface IComboRepository {
	void saveCombo(Object combo);

	List<Combo> getAllCombos();

	Combo getCombo(String key);

	void deleteCombo(String key);
}
