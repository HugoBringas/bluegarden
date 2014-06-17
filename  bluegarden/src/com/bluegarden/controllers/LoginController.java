package com.bluegarden.controllers;
import org.datanucleus.api.jpa.annotations.ColumnPosition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.appidentity.AppIdentityServicePb.SigningService.Method;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
@Controller
public class LoginController {
	


	 @RequestMapping(value="/",method=RequestMethod.GET)
	    public String index()
	    {
	       
	        return "index2";
	    }
	 @RequestMapping(value="/logSuccess",method=RequestMethod.GET)
	 public String logSuccess()
	 {
		
		 return "redirect:http://wwww.sankakucomplex.com";
		 
	 }
	 
	 @RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	 public String logFailed(ModelMap map)
	 {
		 map.addAttribute("error",true);
		 return "index2";
	 }


}
