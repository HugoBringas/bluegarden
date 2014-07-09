package com.bluegarden.facade;

import java.util.List;

import com.bluegarden.dbo.IComboRepository;
import com.bluegarden.entities.Combo;

public class ComboFacade implements IComboFacade {
	private final IComboRepository comboRepository;

	public ComboFacade(IComboRepository comboRepository) {

		this.comboRepository = comboRepository;
	}

	@Override
	public void save(Combo combo) {
		comboRepository.saveCombo(combo);
	}

	@Override
	public List<Combo> getAllCombos() {
		return comboRepository.getAllCombos();
	}

	@Override
	public void deleteCombo(long id) {
		comboRepository.deleteCombo(3);

	}

	@Override
	public Combo getCombo(String key) {
		return comboRepository.getCombo(key);
	}

}
