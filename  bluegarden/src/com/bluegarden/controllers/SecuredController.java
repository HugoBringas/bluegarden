package com.bluegarden.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("secured")
public class SecuredController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	String secured() {

		return "secured " + new Date();
	}

	@RequestMapping("ee")
	public @ResponseBody
	String wtf() {
		return "wtf";

	}

}
