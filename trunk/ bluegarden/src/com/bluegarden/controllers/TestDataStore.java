package com.bluegarden.controllers;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluegarden.dbo.PMF;
import com.bluegarden.entities.User;

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
		PersistenceManager pmf = null;
		Query query = null;
		List<User> users = null;
		try {
			pmf = PMF.get().getPersistenceManager();
			query = pmf.newQuery(User.class);
			query.setFilter("userName == nameParameter");
			query.declareParameters("String nameParameter");

			users = (List<User>) query.execute("hugo");

			if (users != null && users.size() != 0) {
				return users.get(0).getUserName() + " password: " + users.get(0).getPassword();
			}

		} catch (Exception ex) {
			return ex.getMessage();
		} finally {
			if (pmf != null) {
				query.closeAll();
				pmf.close();
			}
		}

	

		return "no users";
	}

}
