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
		//logic here if is necessary
		comboRepository.saveCombo(combo);
	}

	@Override
	public List<Combo> getAllCombos() {
		// TODO Auto-generated method stub
		return comboRepository.getAllCombos();
	}



}
