package com.bluegarden.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluegarden.entities.Combo;
import com.bluegarden.facade.IComboFacade;

@Controller
@RequestMapping("combos")
public class ComboController {
	private final IComboFacade comboFacade;

	public ComboController(IComboFacade comboFacade) {
		this.comboFacade = comboFacade;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("combo", new Combo());
		return "/combos/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addCombo(@Valid Combo combo, BindingResult result) {
		if (!result.hasErrors()) {
			comboFacade.save(combo);
			return "redirect://www.google.com.mx";
		} else {
			return "/combos/index";
		}
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody
	List<Combo> getCombos() {
		return comboFacade.getAllCombos();
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String comboList(ModelMap modelMap) {
		modelMap.addAttribute("combos", comboFacade.getAllCombos());
		return "/combos/list";
	}
	
	@RequestMapping(value = "update/{key}", method = RequestMethod.GET)
	public String updateCombo(@PathVariable String key,ModelMap modelMap){
		Combo combo = comboFacade.getCombo(key);
		//logic here or in the facade in case that given key doens't exist in the datastore 
		modelMap.addAttribute("combo",combo);
	
		return "/combos/update";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveCombo(@Valid Combo combo, BindingResult result){
		if(!result.hasErrors()){
			return "redirect://www.google.com.mx";
		}else{
			return "/combos/update";
		}
		
	}

}
