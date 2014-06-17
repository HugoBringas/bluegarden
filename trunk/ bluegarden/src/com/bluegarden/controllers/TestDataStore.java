package com.bluegarden.controllers;

import javax.jdo.PersistenceManager;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluegarden.dbo.PMF;
import com.bluegarden.entities.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;

@Controller
@RequestMapping("test")
public class TestDataStore {

	@RequestMapping(method = RequestMethod.GET)
	public String TestIndex() {

		return "testindex";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String posttTest(ModelMap map) {
		PersistenceManager pmf = null;
		try {
			pmf = PMF.get().getPersistenceManager();

			pmf.makePersistent(new User("hugo", "lol123"));

		} catch (Exception e) {

		} finally {

			if (pmf != null) {
				pmf.close();
			}
		}

		// Key c= KeyFactory.createKey("Users","hugo");
		// Entity en= new Entity("Users",c);
		// en.setProperty("email", "hugo");
		// en.setProperty("password","test123");
		// DatastoreService dataStore=
		// DatastoreServiceFactory.getDatastoreService();
		// dataStore.put(en);

		map.addAttribute("exito", "exito data store");
		return "testindex";

	}

	@RequestMapping(value = "/show")
	public @ResponseBody
	String show() {
		DatastoreService dataStore = DatastoreServiceFactory
				.getDatastoreService();
		Query q = new Query("Users");
		Entity e = dataStore.prepare(q)
				.asList(FetchOptions.Builder.withLimit(1)).get(0);

		return e.getProperty("email").toString() + " - "
				+ e.getProperty("password");

	}

}
