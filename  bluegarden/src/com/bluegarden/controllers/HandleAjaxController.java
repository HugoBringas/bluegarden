package com.bluegarden.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("handleajax")
public class HandleAjaxController {

	@RequestMapping(value = "view/{name}", method = RequestMethod.GET)
	public String getView(@PathVariable String name, HttpServletRequest request) {
		if (isAjaxRequest(request.getHeader("X-Requested-With"))) {
			System.out.println("yes");
		}
		return "/views/"+name;
	}

	private boolean isAjaxRequest(String type) {
		if (type != null && type.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}

}
