package com.bluegarden.controllers;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluegarden.entities.Combo;

@Controller
@RequestMapping("combos")
public class ComboController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		modelMap.addAttribute("combo", new Combo());
		return "/combos/index";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String addCombo(@Valid Combo combo,  BindingResult result){
		
		return "cool";
	}

}
